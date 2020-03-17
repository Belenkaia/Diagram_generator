package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import ru.iaie.reflex.diagram.reflex.Process
import ru.iaie.reflex.diagram.reflex.StartProcStat
import ru.iaie.reflex.diagram.reflex.StopProcStat
import ru.iaie.reflex.diagram.reflex.Statement
import ru.iaie.reflex.diagram.reflex.IfElseStat
import ru.iaie.reflex.diagram.reflex.CompoundStatement

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ReflexGenerator extends AbstractGenerator {
	var int count_id = 0;
	var ArrayList<ActiveProcess> procList = new ArrayList<ActiveProcess>;
	var procId = new ArrayList(); 	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �����, ������������� ������� ���������. count_id ������������ ��� ������� Id ����� ��������� � �������� ����� GML
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	def void increaseProcessId()
	{
		count_id ++
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �����, ���������� ������� ���������. count_id ������������ ��� ������� Id ����� ��������� � �������� ����� GML
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def void NullProcessId()
	{
		count_id  = 0
	}	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� ��������� ��������� GML �����. ����� ���������� ������� ��������� (count_id) 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def writeHeadGML() '''
	Creator	"tranlator"
	Version	"2.15"
	graph
	[
		hierarchic	1
		label	""
		directed	1�NullProcessId()�
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//����� �������� �� ���� ����� ����� �������� � ���������� ������ � ����������� ����������� ���� �������� (�����, ������, ���� �������, ����� �������, � ��)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateNodeGraphics (int nameLength) '''
			graphics
			[
				w	�(nameLength * 5 + 25)�.0
				h	48.0
				type	"roundrectangle"
				raisedBorder	0
				fill	"#FFFFFF"
				outline	"#000000"
			]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� LabelGraphics, �������� ��������� ������ � ����� ������� ������ �������. �� ���� �������� ��� ��������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def generateLabelGraphics(String processName)
	'''
			LabelGraphics
			[
				text	"�processName�"
				fontSize	12
				fontName	"Dialog"
			]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �� ���� ��������� �����, ������� ����� ��������� ������� �������� � �������� Id, � ��������� ��� ��������  
// ����� ���������� ������, ���������� ���������� ����� ������� (�� ������ ��������) � gml �����,
// ������� ��� ���� generateNodeGraphics(), generateLabelGraphics() ��� ��������� ��������� ������ �������� ������� 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneProcessNode(int processId, String processName)
	'''
	node
	[
		id	�processId�
		label	"�processName�"
	    �generateNodeGraphics(processName.length)�
		�generateLabelGraphics(processName)�
	]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� � ���� ���������� ���� ������ ����������� ��������� ���������. ���������� ������������ ����� �������� ��� Id � ������ procId
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateProcessNodes(Resource resource)
	{
		var String tempString = "";
		for (e : resource.allContents.toIterable.filter(Process)) { //�������� ������ ���� ���������, � �������� �� ����
	             tempString += generateOneProcessNode(count_id, e.name) // ��� ������� �������� ���������� ��������� �������� ������� �����, � ������������� ��� � ����������
	             procId.add(count_id, e.name) // ���������� ������������ ����� �������� ������������ ��� Id
	             increaseProcessId() // �������������� ������� ��������� (��� ����� ����� Id ��� ������� ���������� ��������)
	        }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� gml �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateActivityDiagram(Resource resource)
	'''�writeHeadGML�
	�generateProcessNodes(resource)�
	�constructActiveModel(resource)�
	�checkProcList()�
	�generateAllEdges()�
]'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� fromId - Id �������, �� ������� ���� �����. toId -  Id �������, � ������� ���� �����. label - ������� ��� ������.
// ���������� ������, ���������� �������� ����� � ������� gml � ��������� � ���������� ����������.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneEdge(int fromId, int toId, String label)
	'''
	edge
	[
		source	�fromId�
		target	�toId�
		label	"�label�"�System.out.println("generate edge from " + fromId + " to " + toId)�
	]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ���������� ������, ���������� �������� ���� ����� ����� ��������� ���������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateAllEdges()
	{
		var String tempString = ""
		for (var int i; i < procList.size; i ++) // ���� �� ��������� ������� ������
		{
			tempString += generateOneEdge(procList.get(i).idFrom, procList.get(i).idTo, procList.get(i).action) // ������������ �������� �����
		}
		return tempString
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ���������� �����. ������� � ������� ���������� procList (������ ���������)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def checkProcList()
	{
		for (proc : procList)
	    {
	    	System.out.print("proc " + proc.idFrom + " " + proc.action + " " + proc.idTo)
	    }
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ������� ������ ����� ��������� �� ���������� � ���� ������ ArrayList<ActiveProcess>
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def constructActiveModel(Resource resource)
	{
		for (var int i = 0; i < procId.size; i ++)
		{
			System.out.print(i + ":" + procId.get(i) + ", ")
		}
		System.out.println()
		for (process : resource.allContents.toIterable.filter(Process)) 
		{
	         for (state : process.states) 
	         {
	         		for(statement: state.statements)
	         		{
	         			var ArrayList<ActiveProcess> tempProcList;
	         			try {
	         				tempProcList = statement.getActiveList()
	         			}
	         			catch(IllegalArgumentException ex)
	         			{
	         				System.out.println(ex)
	         			}
	         			if(tempProcList !== null)
	         			{
	         				for (elem: tempProcList)
	         				{
	         					elem.setIdFrom(procId.indexOf(process.name))
	         					if(elem.idTo == -1)
	         					{
	         						elem.setIdTo(procId.indexOf(process.name)) // stopping itself
	         					}
	         					procList.add(elem);
	         				}
	         			}
	         		
	         		}	
	         }    
	        }
	        
	}

	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� StartProcStat: ���������� 1 ������� ArrayList<ActiveProcess>, �����, ���������� ����� ����� �������� ����� � ���������, ������ �������� ���
// ���������, ��� ���� ������ ������ ���������� � �������� ����������, ������� ����������� ���������� ����������, � ����� ����������������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(StartProcStat statement)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ActiveProcess proc = new ActiveProcess()
	    proc.setAction("start");
	    proc.setIdFrom(-1) // default value
	    proc.setIdTo(procId.indexOf(statement.procId))
	    procTempList.add(proc)
	    
		return procTempList
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� StopProcStat: ���������� 1 ������� ArrayList<ActiveProcess>, �����, ���������� ����� ����� �������� ���� � ���������, ������ �������� ���
// ���������, ��� ���� ������ ������ ���������� � �������� ����������, ������� ����������� ���������� ����������, � ����� ����������������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(StopProcStat statement)
	{
		var ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>
		var ActiveProcess proc = new ActiveProcess()
	    proc.setAction("stop");
	    proc.setIdFrom(-1) // default value
	    if(statement.procId !== null)
	    {
	    	proc.setIdTo(procId.indexOf(statement.procId))
	    }
	    else
	    {
	    	proc.setIdTo(-1) // stopping itself
	    }
	    procTempList.add(proc)
	    
		return procTempList
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� IfElseStat: ���������� ArrayList<ActiveProcess>, �� ������ �������, ���������� ����� ����� ��������� �����/���� � ���������, ������ �������� ��� ���������
// ����� ��������������� �������� ������� getActiveList � ����� IfElseStat, ����� ���� �������� ������ ���������, � ���������� ���
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def dispatch ArrayList<ActiveProcess> getActiveList(IfElseStat statement)
	{
		var ArrayList<ActiveProcess> procTempList = null;
		System.out.println("then: " + statement.then)
		System.out.println("else: " + statement.getElse)
		var ArrayList<ActiveProcess> procTempThenList = statement.then.getActiveList()
		var ArrayList<ActiveProcess> procTempElseList = statement.getElse().getActiveList()
		if(procTempThenList !== null)
		{
			for (l: procTempThenList)
			{
				procTempList.add(l)
			}
		}
		
		if(procTempElseList !== null)
		{
			for (l: procTempElseList)
			{
				procTempList.add(l)
			}
		}
		return (procTempList)
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� ����������� Statement (��������)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getActiveList(Statement statement)
	{
		return null
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �������� �����. ������� ���� ��������� � ���������� � ���� ��������� ���������.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
      	fsa.generateFile("activity_diagram.gml", generateActivityDiagram(resource));
      	procList.clear()
      	NullProcessId()
      	procId.clear()
      }     
}
