package ru.iaie.reflex.diagram.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.diagram.reflex.Process
//import org.eclipse.core.runtime.*
//import static extension org.eclipse.xtext.EcoreUtil2.*
//import java.io.File;
/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ReflexGenerator extends AbstractGenerator {
	val WORKING_DIRECTORY = "D:\\GitHub\\runtime-EclipseXtext\\test\\src-gen"
	val STATECHART_FILE_NAME_TAIL = "_statechart_diagram.gml"
	var ActivityDiagramGenerator activityDiagramGenerator = new ActivityDiagramGenerator()
	
	var DataDiagramGenerator dataDiagramGenerator = new DataDiagramGenerator()
	var StatechartDiagramGenerator statechartDiagramGenerator = new StatechartDiagramGenerator()

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Основной метод. Создает файл диаграммы и записывает в него результат генерации.
//
//Main method. Create diagramm's files and write to them generation results
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
     	//System.out.println(resource.URI)
     	//System.out.println(Platform.getLocation())
     	System.out.print("Generate statechart GML diagrams...")
     	for (process : resource.allContents.toIterable.filter(Process)) 
		{
			statechartDiagramGenerator.generateStatechartDiagramModel(resource, process)
			fsa.generateFile(process.name + STATECHART_FILE_NAME_TAIL, statechartDiagramGenerator.generateStatechartDiagram(process));
			statechartDiagramGenerator.clear()
		}
		System.out.println("done.")
		
		activityDiagramGenerator.generateActivityDiagramModel(resource)
		var ResultOfSeparation activityResult = activityDiagramGenerator.separateDiadram()
		//fsa.generateFile("activity_diagram" + "_"  + ".gml", activityDiagramGenerator.generateActivityDiagram(activityDiagramGenerator.procId, activityDiagramGenerator.procList));
		//fsa.generateFile("activity_diagram" + "_"  + ".graphml", activityDiagramGenerator.generateActivityGraphMLDiagram(activityDiagramGenerator.procId, activityDiagramGenerator.procList, WORKING_DIRECTORY, STATECHART_FILE_NAME_TAIL));
     	//activityDiagramGenerator.clear()
		
		for (var i = 0; i < activityResult.getDiagramComponents.size(); i ++)
		{
			fsa.generateFile("activity_diagram" + "_" + i + ".gml", activityDiagramGenerator.generateActivityDiagram(activityResult.getDiagramComponentNodes.get(i), activityResult.getDiagramComponents.get(i)));
			fsa.generateFile("activity_diagram" + "_" + i + ".graphml", activityDiagramGenerator.generateActivityGraphMLDiagram(activityResult.getDiagramComponentNodes.get(i), activityResult.getDiagramComponents.get(i), WORKING_DIRECTORY, STATECHART_FILE_NAME_TAIL));
     		activityDiagramGenerator.clear()
		}
		
		dataDiagramGenerator.generateDataDiagramModel(resource)
		var ResultOfSeparation dataResult = dataDiagramGenerator.separateDiadram()
		//var ArrayList<ArrayList<DiagramNode>> dataDiagramComponentNodes =  dataDiagramGenerator.getNodeList()
		
		for (var j = 0; j < dataResult.getDiagramComponents.size(); j ++)
		{
			fsa.generateFile("data_diagram" + "_" + j + ".gml", dataDiagramGenerator.generateDataDiagram(dataResult.getDiagramComponentNodes.get(j), dataResult.getDiagramComponents.get(j)));
			fsa.generateFile("data_diagram" + "_" + j + ".graphml", dataDiagramGenerator.generateDataGraphMLDiagram(dataResult.getDiagramComponentNodes.get(j), dataResult.getDiagramComponents.get(j), WORKING_DIRECTORY, STATECHART_FILE_NAME_TAIL));
     		dataDiagramGenerator.clear()
		}
     	
      }     
}
