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
//Input: process, to which we will generate statechart diagram
//Output: string with statechart diagram node's for that process
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateStatechartNodes(Resource resource, Process process)
	{
		var String tempString = "";
		tempString += gmlTextGenerator.generateOneProcessNode(count_id, "     ", "circle")
		procId.add(count_id, "start_default") // ���������� ������������ ����� ������������ ��� Id
	    count_id ++
		for (state : process.states)//�������� ������ ���� ��������� ��������, � �������� �� ����
		{ 
	    	tempString += gmlTextGenerator.generateOneProcessNode(count_id, state.name, "roundrectangle") 
	    	procId.add(count_id, state.name) // ���������� ������������ ����� ������������ ��� Id
	        count_id ++
	    }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ���������� ������� ����� statechart-���������
// Input: process, to which we will generate statechart diagram
// Output: finished text of GML process statechart diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateStatechartDiagram(Resource resource, Process process)
	'''�gmlTextGenerator.writeHeadGML(this)�
	�generateStatechartNodes(resource, process)�
	�generateStatechartModel(resource, process)�
	�gmlTextGenerator.generateAllEdges(procList)�
]'''	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Build statechard diagram model as an ArrayList<ActiveProcess> (procList), where we save the relationships behind states of process
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
def generateStatechartModel(Resource resource, Process process)
	{
		var boolean flagFirstStateInProcess = true;
		for (state : process.states) 
	    {
	    	
	         for(statement: state.statements) // go throw statements
	         {
	         	if(flagFirstStateInProcess) // we need to put start node to diagram (such circle with edge to first state on process)
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
// ����������� ����� ��� ����������� Statement (��������)
//
// Polymorphic method for Statement (to avoid exception)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getStatechartList(Statement statement, int contextStateId)
	{
		return new ArrayList<ActiveProcess>;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for IfElseStat, input: contextStateId which is current state id in the list procId
//Method calls getStatechartList for 'else' and 'then' fields of statement and collecting their returns to return it
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(IfElseStat statement, int contextStateId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ArrayList<ActiveProcess> procTempThenList = statement.then.getStatechartList(contextStateId)
		var ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>
		if(statement.getElse() !== null) // 'if' may be without 'else'
			procTempElseList = statement.getElse().getStatechartList(contextStateId)
		procTempList.addAll(procTempThenList)
		procTempList.addAll(procTempElseList)
		return (procTempList)
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for CompoundStatement, input: contextStateId which is current state id in the list procId
//Method calls getStatechartList for their statements and collecting their returns to return it
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
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
//Polymorphic method for SetStateStat, input: contextStateId which is current state id in the list procId
//Method returns one element of ArrayList<ActiveProcess>, which have information about which state set which state (we have their id in the procId list)
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(SetStateStat statement, int contextStateId)
	{
		var ActiveProcess tempElem = new ActiveProcess()
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		tempElem.idFrom = contextStateId
		if(statement.next) // we gets id to states in the order we found states in process notification, so, next state will have number id which is currentId + 1
			tempElem.idTo = contextStateId + 1
		else
			tempElem.idTo = (procId.indexOf(statement.stateId))
		procTempList.add(tempElem)
		return procTempList
	}
}