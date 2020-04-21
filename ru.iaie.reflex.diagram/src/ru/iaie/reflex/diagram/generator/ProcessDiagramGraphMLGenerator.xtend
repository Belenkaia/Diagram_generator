package ru.iaie.reflex.diagram.generator

import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.diagram.reflex.Process

class ProcessDiagramGraphMLGenerator extends ProcessDiagramGenerator 
{
	protected var GraphMLTextGenerator graphMLTextGenerator = new GraphMLTextGenerator()
	protected var GraphSeparator graphSeparator = new GraphSeparator()
	
	def void generateProcList(Resource resource)
	{
		for (e : resource.allContents.toIterable.filter(Process)) //получаем список всех процессов, и проходим по нему
		{
			var DiagramNode newNode = new DiagramNode(e.name)
		 	addElementToProcId(newNode)
		}
		zeroCountId()
	}
	
	def ResultOfSeparation separateDiadram()
	{
		return graphSeparator.separateGraph(procList, procId)
	}
	
}