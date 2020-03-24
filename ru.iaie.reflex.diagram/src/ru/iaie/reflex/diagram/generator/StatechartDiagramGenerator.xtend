package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.diagram.reflex.CompoundStatement
import ru.iaie.reflex.diagram.reflex.IfElseStat
import ru.iaie.reflex.diagram.reflex.Process
import ru.iaie.reflex.diagram.reflex.SetStateStat
import ru.iaie.reflex.diagram.reflex.Statement

class StatechartDiagramGenerator  extends GMLDiagramGenerator{
var GMLTextGenerator gmlTextGenerator = new GMLTextGenerator()

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateStatechartNodes(Resource resource, Process process)
	{
		var String tempString = "";
		tempString += gmlTextGenerator.generateOneProcessNode(count_id, "     ", "circle")
		procId.add(count_id, "start_default") // запоминаем соответствие имени назначенному ему Id
	    count_id ++
		for (state : process.states)
		{ //получаем список всех состояний процесса, и проходим по нему
	    	tempString += gmlTextGenerator.generateOneProcessNode(count_id, state.name, "roundrectangle") 
	    	procId.add(count_id, state.name) // запоминаем соответствие имени назначенному ему Id
	        count_id ++
	    }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Возвращает готовый текст statechart-диаграммы
// 
// Output: finished text of GML process statechart diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateStatechartDiagram(Resource resource, Process process)
	'''«gmlTextGenerator.writeHeadGML(this)»
	«generateStatechartNodes(resource, process)»
	«generateStatechartModel(resource, process)»
	«gmlTextGenerator.generateAllEdges(procList)»
]'''	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
def generateStatechartModel(Resource resource, Process process)
	{
		var boolean flagFirstStateInProcess = true;
		for (state : process.states) 
	    {
	    	
	         for(statement: state.statements) // go throw statements
	         {
	         	if(flagFirstStateInProcess)
	         	{
	         		var ActiveProcess startNode = new ActiveProcess()
	    			startNode.idFrom = procId.indexOf("start_default")
	    			startNode.idTo = procId.indexOf(state.name)
	    			procList.add(startNode)
	         	}
	         	var ArrayList<ActiveProcess> tempProcList;
	         	tempProcList = statement.getStatechartList(procId.indexOf(state.name))
	         	procList.addAll(tempProcList)
	         	flagFirstStateInProcess = false;
	         }
	       
	         if(state.timeoutFunction !== null) // go throw timeoutFunction, if it is exist for that state
	         {
	         	for(timeoutFunctionStatements: state.timeoutFunction.statements)
	        	{
	        		var ArrayList<ActiveProcess> tempProcList;
	        		tempProcList = timeoutFunctionStatements.getStatechartList(procId.indexOf(state.name))
	        		procList.addAll(tempProcList)
	        	}
	         }
	    }
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод для суперкласса Statement (заглушка)
//
// Polymorphic method for Statement (to avoid exception)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getStatechartList(Statement statement, int contextStateId)
	{
		return new ArrayList<ActiveProcess>;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(IfElseStat statement, int contextStateId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ArrayList<ActiveProcess> procTempThenList = statement.then.getStatechartList(contextStateId)
		var ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>
		if(statement.getElse() !== null)
			procTempElseList = statement.getElse().getStatechartList(contextStateId)
		procTempList.addAll(procTempThenList)
		procTempList.addAll(procTempElseList)
		return (procTempList)
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(CompoundStatement statement, int contextStateId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		for(s : statement.statements)
		{
			var ArrayList<ActiveProcess> subProcList = s.getStatechartList(contextStateId);
			procTempList.addAll(subProcList)
		}
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(SetStateStat statement, int contextStateId)
	{
		var ActiveProcess tempElem = new ActiveProcess()
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		tempElem.idFrom = contextStateId
		if(statement.next)
			tempElem.idTo = contextStateId + 1
		else
			tempElem.idTo = (procId.indexOf(statement.stateId))
		procTempList.add(tempElem)
		return procTempList
	}
}