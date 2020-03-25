package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.diagram.reflex.CompoundStatement
import ru.iaie.reflex.diagram.reflex.IfElseStat
import ru.iaie.reflex.diagram.reflex.Process
import ru.iaie.reflex.diagram.reflex.StartProcStat
import ru.iaie.reflex.diagram.reflex.Statement
import ru.iaie.reflex.diagram.reflex.StopProcStat

class ActivityDiagramGenerator extends GMLDiagramGenerator{
	var GMLTextGenerator gmlTextGenerator = new GMLTextGenerator()
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ������� ������ ����� ��������� �� ���������� � ���� ������ ArrayList<ActiveProcess>
//
// Method construct the model of manage connecting behind processes like an ArrayList<ActiveProcess> 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def constructActiveModel(Resource resource)
	{
		for (var int i = 0; i < procId.size; i ++) // ��� �������
		{
			System.out.print(i + ":" + procId.get(i) + ", ")
		}
		System.out.println()
		
		for (process : resource.allContents.toIterable.filter(Process)) 
		{
	         for (state : process.states) 
	         {
	         	for(statement: state.statements) // go throw statements
	         	{
	         		var ArrayList<ActiveProcess> tempProcList;
	         		tempProcList = statement.getActiveList(procId.indexOf(process.name))
	         		procList.addAll(tempProcList)
	         	}
	       
	         	if(state.timeoutFunction !== null) // go throw timeoutFunction, if it is exist for that state
	         	{
	         		for(timeoutFunctionStatements: state.timeoutFunction.statements)
	         		{
	         			var ArrayList<ActiveProcess> tempProcList;
	         			tempProcList = timeoutFunctionStatements.getActiveList(procId.indexOf(process.name))
	         			procList.addAll(tempProcList)
	         		}
	         	}  
	         }    	 
	     }
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� StartProcStat: ���������� 1 ������� ArrayList<ActiveProcess>, �����, ���������� ����� ����� �������� ����� � ���������, ������ �������� ���
// ���������
//
// Polymorphic method. For StartProcStat returns 1 element of ArrayList<ActiveProcess>. It express how connecting the process and statement "start" in them
// Input: contextProcessId - id of process, in which is that statement
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(StartProcStat statement, int contextProcessId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ActiveProcess proc = new ActiveProcess()
	    proc.setAction("start");
	    proc.setIdFrom(contextProcessId)
	    proc.setIdTo(procId.indexOf(statement.procId))
	    procTempList.add(proc)
	    
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� StopProcStat: ���������� 1 ������� ArrayList<ActiveProcess>, �����, ���������� ����� ����� �������� ���� � ���������, ������ �������� ���
// ���������
//
// Polymorphic method. For StopProcStat returns 1 element of ArrayList<ActiveProcess>. It express how connecting the process and statement "stop" in them
// Input: contextProcessId - id of process, in which is that statement
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(StopProcStat statement, int contextProcessId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ActiveProcess proc = new ActiveProcess()
	    proc.setAction("stop");
	    proc.setIdFrom(contextProcessId)
	    if (statement.procId !== null)
	    {
	    	proc.setIdTo(procId.indexOf(statement.procId))
	    }
	    else
	    {
	    	proc.setIdTo(contextProcessId)
	    }
	    procTempList.add(proc)
	    
		return procTempList
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� IfElseStat: ���������� ArrayList<ActiveProcess>, �� ������ �������, ���������� ����� ����� ��������� �����/���� � ���������, ������ �������� ��� ���������
// ����� ��������������� �������� ������� getActiveList � ����� IfElseStat, ����� ���� �������� ������ ���������, � ���������� ���
//
// Polymorphic method. For IfElseStat returns ArrayList<ActiveProcess>. It express how connecting the process and statement "stop"/"start" in them
// Method calls getActiveList from IfElseStat statement's fields, then collect results and return them
// Input: contextProcessId - id of process, in which is that statement
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(IfElseStat statement, int contextProcessId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ArrayList<ActiveProcess> procTempThenList = statement.then.getActiveList(contextProcessId)
		var ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>
		if(statement.getElse() !== null)
			procTempElseList = statement.getElse().getActiveList(contextProcessId)
		procTempList.addAll(procTempThenList)
		procTempList.addAll(procTempElseList)
		return (procTempList)
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� getActiveList ��� ��������� �������� (CompoundStatement) 
// ���������� ����� ������ �������� ActiveProcess �� ���� �������� ������ ��������� ��������
//
// Polymorphic method. For CompoundStatement returns ArrayList<ActiveProcess>. It express how connecting the process and statement "stop"/"start" in them
// Method calls getActiveList from statement's fields, then collect results and return them
// Input: contextProcessId - id of process, in which is that statement
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(CompoundStatement statement, int contextProcessId)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>;
		for(s : statement.statements)
		{
			var ArrayList<ActiveProcess> subProcList = s.getActiveList(contextProcessId);
			procTempList.addAll(subProcList)
		}
		return procTempList
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� ����������� Statement (��������)
//
// Polymorphic method for Statement (to avoid exception)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getActiveList(Statement statement, int contextProcessId)
	{
		return new ArrayList<ActiveProcess>;
	}

	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� gml �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������. ���������� ������� ����� activity-���������
//
// Method is collecting a GML head, nodes list and edge list of diagram by calling the same methods 
// Output: finished text of GML activity diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateActivityDiagram(Resource resource)
	'''�gmlTextGenerator.writeHeadGML(this)�
	�gmlTextGenerator.generateProcessNodes(resource, this/* , NS_RECTANGLE*/)�
	�constructActiveModel(resource)�
	�gmlTextGenerator.generateAllEdges(procList)�
]'''



}