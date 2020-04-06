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
		procId.add(count_id, "start_default") // запоминаем соответствие имени назначенному ему Id
	    count_id ++
		for (state : process.states)//получаем список всех состояний процесса, и проходим по нему
		{ 
	    	tempString += gmlTextGenerator.generateOneProcessNode(count_id, state.name, "roundrectangle") 
	    	procId.add(count_id, state.name) // запоминаем соответствие имени назначенному ему Id
	        count_id ++
	    }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Возвращает готовый текст statechart-диаграммы
// Input: process, to which we will generate statechart diagram
// Output: finished text of GML process statechart diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateStatechartDiagram(Resource resource, Process process)
	'''«gmlTextGenerator.writeHeadGML(this)»
	«generateStatechartNodes(resource, process)»
	«generateStatechartModel(resource, process)»
	«gmlTextGenerator.generateAllEdges(procList)»
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
	         	tempProcList = statement.getStatechartList(procId.indexOf(state.name), "(", "")
	         	procList.addAll(tempProcList)
	         	flagFirstStateInProcess = false;
	         }
	       
	         if(state.timeoutFunction !== null) // go throw timeoutFunction, if it is exist for that state
	         {
	         	for(timeoutFunctionStatements: state.timeoutFunction.statements)
	        	{
	        		var String contextLabel = "(Timeout [ time = "  + state.timeoutFunction.time.ticks + "ticks ]"
	        		var ArrayList<ActiveProcess> tempProcList;
	        		tempProcList = timeoutFunctionStatements.getStatechartList(procId.indexOf(state.name), contextLabel, "")
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
			newThenContextLabel = contextLabel.substring(0, index) + " &amp;&amp; (" + statement.cond.translateExpr() + ") ]"
		}
		else
		{
			newThenContextLabel = contextLabel + "[ (" + statement.cond.translateExpr() + ") ]"
		}
		var String newExprLabel = "";
		newExprLabel = statement.then.getContextLabel(contextStateId, newThenContextLabel, newExprLabel)
		
		
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
			newExprLabel =  "";
			newExprLabel = statement.getElse().getContextLabel(contextStateId, newElseContextLabel, newExprLabel)
		
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
			newExprLabel = s.getContextLabel(contextStateId, contextLabel, newExprLabel)
			System.out.println("E (compound): "+ newExprLabel)
		}
		for(s : statement.statements)
		{
			var ArrayList<ActiveProcess> subProcList = s.getStatechartList(contextStateId, contextLabel, newExprLabel);
			procTempList.addAll(subProcList)
		}
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch String getContextLabel(ExpressionStatement statement, int contextStateId, String contextLabel, String expressionStatement)
	{
		var String newExprContextLabel = "";
		/*var index = contextLabel.lastIndexOf("]")
		if( index != -1)
		{
			var index2 = contextLabel.lastIndexOf("/")
			if(index2 != -1)
			{
				newExprContextLabel = contextLabel.substring(0, index) + ";" + statement.expr.getExpression + "]";
			}
			else
			{
				newExprContextLabel = contextLabel.substring(0, index) + "/" + statement.expr.getExpression + "]";
			}
		}
		else
		{
			newExprContextLabel = contextLabel + "[ /" + statement.expr.getExpression +  "]"
		}
		System.out.println("expr: " + newExprContextLabel);*/
		if(expressionStatement.length > 0)
		{
			newExprContextLabel = expressionStatement + "; " + statement.expr.getExpression
		}
		else
		{
			newExprContextLabel = expressionStatement + statement.expr.getExpression
		}
		System.out.println("expr: " + newExprContextLabel + ", getExpr: "+ statement.expr.getExpression);
		return newExprContextLabel
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
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
			tempElem.idTo = (procId.indexOf(statement.stateId))
		tempElem.action = finishEdgeLabel
		procTempList.add(tempElem)
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Method returns expression text (used in edge labels)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def translateExpr(Expression expr) 
	{
		return '''« NodeModelUtils.getNode(expr).text.trim »'''
	}
	
	def dispatch String getExpression(Expression expr)
	{
		return ""
	}
	
	def dispatch String getExpression(AssignmentExpression expr)
	{
		return '''« NodeModelUtils.getNode(expr).text.trim »'''
	}
}
