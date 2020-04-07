package ru.iaie.reflex.diagram.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.diagram.reflex.Process
//import static extension org.eclipse.xtext.EcoreUtil2.*
//import java.io.File;
/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ReflexGenerator extends AbstractGenerator {
var ActivityDiagramGenerator activityDiagramGenerator = new ActivityDiagramGenerator()
var DataDiagramGenerator dataDiagramGenerator = new DataDiagramGenerator()
var StatechartDiagramGenerator statechartDiagramGenerator = new StatechartDiagramGenerator()
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Основной метод. Создает файл диаграммы и записывает в него результат генерации.
//
//Main method. Create diagramm's files and write to them generation results
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
     	fsa.generateFile("data_diagram.gml", dataDiagramGenerator.generateDataDiagram(resource));
     	dataDiagramGenerator.clear()
     	for (process : resource.allContents.toIterable.filter(Process)) 
		{
			fsa.generateFile(process.name + "_statechart_diagram.gml", statechartDiagramGenerator.generateStatechartDiagram(resource, process));
			statechartDiagramGenerator.clear()
		}
		
		fsa.generateFile("activity_diagram.gml", activityDiagramGenerator.generateActivityDiagram(resource));
		//System.out.println("url: " + resource.normalizedURI.lastSegment)
      	fsa.generateFile("activity_diagram.graphml", activityDiagramGenerator.generateActivityGraphMLDiagram(resource, "D:\\GitHub\\runtime-EclipseXtext\\test\\src-gen"));
     	activityDiagramGenerator.clear()
		
     	
      }     
}
