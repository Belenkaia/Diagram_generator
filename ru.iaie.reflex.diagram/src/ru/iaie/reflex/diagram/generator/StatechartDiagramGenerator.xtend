package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.diagram.reflex.CompoundStatement
import ru.iaie.reflex.diagram.reflex.IfElseStat
import ru.iaie.reflex.diagram.reflex.Process
import ru.iaie.reflex.diagram.reflex.SetStateStat
import ru.iaie.reflex.diagram.reflex.Statement
import ru.iaie.reflex.diagram.reflex.Expression
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import ru.iaie.reflex.diagram.reflex.ExpressionStatement
import ru.iaie.reflex.diagram.reflex.AssignmentExpression

class StatechartDiagramGenerator  extends ProcessDiagramGenerator{

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Input: process, to which we will generate statechart diagram
//Output: string with statechart diagram node's for that process
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def /*String*/ getStatechartNodes(Process process)
	{
		//var String tempString = "";
		var DiagramNode newNode = new DiagramNode("   ", "circle")
		addElementToProcId(newNode)
		
		//tempString += gmlTextGenerator.generateOneProcessNode(count_id, "     ", newNode.getShape)
		//procId.add(count_id, "start_default") // ���������� ������������ ����� ������������ ��� Id
	    //count_id ++
		for (state : process.states)//�������� ������ ���� ��������� ��������, � �������� �� ����
		{ 
			var DiagramNode tmpNode = new DiagramNode(state.name)
	    	
	    	//tempString += gmlTextGenerator.generateOneProcessNode(count_id, state.name, "roundrectangle") 
	    	addElementToProcId(tmpNode)
	    	//procId.add(count_id, tmpNode) // ���������� ������������ ����� ������������ ��� Id
	        //count_id ++
	    }
	    /*System.out.println("procId:")
	    for(e: procId.values())
	    {
	    	System.out.print(e.name + ":" + e.shape +", ")
	    }
	    System.out.println(" ");*/
	  //  return tempString
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def generateStatechartDiagramModel(Resource resource, Process process)
{
	 getStatechartNodes(process)
	 generateStatechartModel(resource, process)
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ���������� ������� ����� statechart-���������
// Input: process, to which we will generate statechart diagram
// Output: finished text of GML process statechart diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateStatechartDiagram(Process process)
	'''�gmlTextGenerator.writeHeadGML(this)�
	�gmlTextGenerator.generateNodes(this/* , procId*/)�
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
	    	//var DiagramNode tmpNode = new DiagramNode(state.name)

	         for(statement: state.statements) // go throw statements
	         {
	         	if(flagFirstStateInProcess) // we need to put start node to diagram (such circle with edge to first state on process)
	         	{
	         		//var DiagramNode stNode = new DiagramNode("   ", "circle")	
	         		var ActiveProcess startNode = new ActiveProcess()
	    			startNode.idFrom = getElementIndexProcId("   ")
	    			startNode.idTo = getElementIndexProcId(state.name)
	    			procList.add(startNode)
	         	}
	         	var ArrayList<ActiveProcess> tempProcList;
	         	tempProcList = statement.getStatechartList(getElementIndexProcId(state.name), "(", "")
	         	procList.addAll(tempProcList)
	         	flagFirstStateInProcess = false;
	         }
	       
	         if(state.timeoutFunction !== null) // go throw timeoutFunction, if it is exist for that state
	         {
	         	for(timeoutFunctionStatements: state.timeoutFunction.statements)
	        	{
	        		var String contextLabel = "(Timeout [ time = "  + state.timeoutFunction.time.ticks + "ticks ]"
	        		var ArrayList<ActiveProcess> tempProcList;
	        		tempProcList = timeoutFunctionStatements.getStatechartList(getElementIndexProcId(state.name), contextLabel, "")
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
def dispatch ArrayList<ActiveProcess> getStatechartList(Statement statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		return new ArrayList<ActiveProcess>;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for IfElseStat, input: contextStateId which is current state id in the list procId
//Method calls getStatechartList for 'else' and 'then' fields of statement and collecting their returns to return it
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(IfElseStat statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		var String newThenContextLabel
		var index = contextLabel.lastIndexOf("]")
		if( index != -1)
		{
			newThenContextLabel = contextLabel.substring(0, index) + " &amp;&amp; (" + statement.cond.translateExpr() + ") ]"//collecting conditions in contextLabel
		}
		else
		{
			newThenContextLabel = contextLabel + "[ (" + statement.cond.translateExpr() + ") ]"
		}
		var String newExprLabel = "";
		newExprLabel = statement.then.getContextLabel(contextStateId, newThenContextLabel, newExprLabel) //collecting expressions context for edge label (which after /)
		
		
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ArrayList<ActiveProcess> procTempThenList = statement.then.getStatechartList(contextStateId, newThenContextLabel, newExprLabel)
		
		var ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>
		if(statement.getElse() !== null) // 'if' may be without 'else'
		{
			var String newElseContextLabel
			if( index != -1)
			{
				newElseContextLabel = contextLabel.substring(0, index) + " &amp;&amp; !(" + statement.cond.translateExpr()  + ") ]"
			}
			else
			{
				newElseContextLabel = contextLabel + "[ !(" + statement.cond.translateExpr()  + ") ]"
			}
			newExprLabel =  ""; //needed only local expressions in that scope
			newExprLabel = statement.getElse().getContextLabel(contextStateId, newElseContextLabel, newExprLabel) //collecting expressions context for edge label (which after /)
		
			procTempElseList = statement.getElse().getStatechartList(contextStateId, newElseContextLabel, newExprLabel)
		}
		procTempList.addAll(procTempThenList)
		procTempList.addAll(procTempElseList)
		return (procTempList)
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for CompoundStatement, input: contextStateId which is current state id in the list procId
//Method calls getStatechartList for their statements and collecting their returns to return it
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(CompoundStatement statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		var String newExprLabel =  expressionStatement;
		for(s : statement.statements)
		{
			newExprLabel = s.getContextLabel(contextStateId, contextLabel, newExprLabel) //collecting expressions context for edge label (which is after /)
		}
		for(s : statement.statements)
		{
			var ArrayList<ActiveProcess> subProcList = s.getStatechartList(contextStateId, contextLabel, newExprLabel);
			procTempList.addAll(subProcList)
		}
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for ExpressionStatement to collect expressions like (a = b) which have to be after '/' in edge label
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch String getContextLabel(ExpressionStatement statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		var String newExprContextLabel = "";
		if(expressionStatement.length > 0)//not first expression
		{
			newExprContextLabel = expressionStatement + "; " + statement.expr.getExpression //collecting expressions like 'a; b; c' (will be put in edge labels after '/')
		}
		else
		{
			newExprContextLabel = expressionStatement + statement.expr.getExpression //collecting expressions like 'a; b; c' (will be put in edge labels after '/')
		}
		return newExprContextLabel
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for all other Statements - they not needed
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch String getContextLabel(Statement statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		return expressionStatement
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Polymorphic method for SetStateStat, input: contextStateId which is current state id in the list procId
//Method returns one element of ArrayList<ActiveProcess>, which have information about which state set which state (we have their id in the procId list)
//Output: ArrayList<ActiveProcess> which have information about relationships between states (like set next and etc)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getStatechartList(SetStateStat statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		var String finishEdgeLabel
		if(expressionStatement.length() > 0)
			finishEdgeLabel = contextLabel + "/" + expressionStatement + ")"
		else
			finishEdgeLabel = contextLabel + ")"
		
		var ActiveProcess tempElem = new ActiveProcess()
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		tempElem.idFrom = contextStateId
		if(statement.next) // we gets id to states in the order we found states in process notification, so, next state will have number id which is currentId + 1
			tempElem.idTo = contextStateId + 1
		else
		{
			//var DiagramNode tmpNode = new DiagramNode(statement.stateId)
			tempElem.idTo = (getElementIndexProcId(statement.stateId))
		}
		tempElem.action = finishEdgeLabel
		procTempList.add(tempElem)
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Method returns expression text (used in edge labels)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def translateExpr(Expression expr) 
	{
		return '''� NodeModelUtils.getNode(expr).text.trim �'''
	}
	
	def dispatch String getExpression(Expression expr)
	{
		return ""
	}
	
	def dispatch String getExpression(AssignmentExpression expr)
	{
		return '''� NodeModelUtils.getNode(expr).text.trim �'''
	}
}
