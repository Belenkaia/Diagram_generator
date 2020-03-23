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
import ru.iaie.reflex.diagram.reflex.DeclaredVariable
import ru.iaie.reflex.diagram.reflex.ProgramVariable
import ru.iaie.reflex.diagram.reflex.PhysicalVariable
import java.util.HashMap
import ru.iaie.reflex.diagram.reflex.ReflexType
import ru.iaie.reflex.diagram.reflex.CType
import ru.iaie.reflex.diagram.reflex.ImportedVariable
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
	var HashMap<String, Integer> variableId = new HashMap<String, Integer>();
//	val NS_RECTANGLE = 0
//	val NS_ELLIPSE = 1
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� ��������� ��������� GML �����. ����� ���������� ������� ������ (count_id) 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def writeHeadGML() '''
	Creator	"tranlator"
	Version	"2.15"
	graph
	[
		hierarchic	1
		label	""
		directed	1�count_id  = 0�
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//����� �������� �� ���� ����� ������� ������� � �� ��� (�� �����), ���������� ������ � ����������� ����������� ���� ��������� (�����, ������, ���� �������, ����� �������, � ��)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateNodeGraphics (int nameLength, String typeOfNode) '''
			graphics
			[
				w	�(nameLength * 10)�.0
				h	48.0
				type	"�typeOfNode�"
				raisedBorder	0
				fill	"#FFFFFF"
				outline	"#000000"
			]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� LabelGraphics, �������� ��������� ������ � ����� ������� ������ �������. �� ���� �������� ������� ��� �������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def generateLabelGraphics(String label)
	'''
			LabelGraphics
			[
				text	"�label�"
				fontSize	12
				fontName	"Dialog"
			]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �� ���� ��������� �����, ������� ����� ��������� ������� � �������� Id, � �����, ������� ����� ������ �������  
// ����� ���������� ������, ���������� ���������� ����� ������� � gml �����,
// ������� ��� ���� generateNodeGraphics(), generateLabelGraphics() ��� ��������� ��������� ������ �������� ������� 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneProcessNode(int processId, String processName, String typeOfNode)
	'''
	node
	[
		id	�processId�
		label	"�processName�"
	    �generateNodeGraphics(processName.length, typeOfNode)�
		�generateLabelGraphics(processName)�
	]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� � ���� ���������� ���� ������ ����������� ��������� ���������. ���������� ������������ ����� �������� ��� Id � ������ procId
// ���� diagrammFlag ���������� ����� ������ ��������� (� activity-diagramm ��� �������������, � data diagramm ��� ������)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateProcessNodes(Resource resource/* , int shape*/)
	{
		var String tempString = "";
		for (e : resource.allContents.toIterable.filter(Process)) { //�������� ������ ���� ���������, � �������� �� ����
	            // if(shape == NS_RECTANGLE)
	             	tempString += generateOneProcessNode(count_id, e.name, "roundrectangle") // ��� ������� �������� ���������� ��������� �������� ������� �����, � ������������� ��� � ����������
	            // if(shape == NS_ELLIPSE)
	            // 	tempString += generateOneProcessNode(count_id, e.name, "ellipse")
	             procId.add(count_id, e.name) // ���������� ������������ ����� �������� ������������ ��� Id
	             count_id ++ // �������������� ������� ��������� (��� ����� ����� Id ��� ������� ���������� ��������)
	        }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� gml �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������. ���������� ������� ����� activity-���������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateActivityDiagram(Resource resource)
	'''�writeHeadGML�
	�generateProcessNodes(resource/* , NS_RECTANGLE*/)�
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
		for (var int i = 0; i < procId.size; i ++) // ��� �������
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
	         			tempProcList = statement.getActiveList(procId.indexOf(process.name))
	         			procList.addAll(tempProcList)
	         			/*for (elem: tempProcList)
	         			{
	         				elem.setIdFrom(procId.indexOf(process.name))
	         				if(elem.idTo == -1) //��������� �������� �����, ���� ������������� ������ ����
	         				{
	         					elem.setIdTo(procId.indexOf(process.name)) // stopping itself
	         				}
	         				procList.add(elem);
	         			}*/
	         		}	
	         }    
	        }
	        
	}


	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� �������� ������ ���������� � ������� gml ��� ��������� ����� �� ������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def getVariablesNodes(Resource resource)
	{
		var String tempStr = "";
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // ���� �� ����������� ����������
		{
			tempStr += generateOneProcessNode(count_id, variable.getVariableNameAndType(), "ellipse"/*"roundrectangle"*/)
			variableId.put(variable.name, count_id) // ���������� ������������ ����� ���������� ����������� �� ������� Id
	        count_id ++ // �������������� ������� ������ (��� ����� ����� Id ��� ������� ��������� �������)
	    }
	    return tempStr;
	}

	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ������� ������ ����� ��������� � ���������� � ������� ArrayList<ActiveProcess> (procList)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataModel(Resource resource)
	{
		for (process : resource.allContents.toIterable.filter(Process)) 
		{
			for(vars : process.variable)
			{
				var ArrayList<String> tempNames = vars.getVariableName()  //������������� ���������� �������� �������, � ����������� �� �����
				for (varName : tempNames)
				{
					var ActiveProcess node = new ActiveProcess
					node.idFrom = procId.indexOf(process.name)
					node.idTo = variableId.get(varName)
					node.action = vars.getVariableAction() //�������� ����� - ������ ��� ����������
					procList.add(node)
				}
			}
		}
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ��� ���������� DeclaredVariable, ��������� � ������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<String> getVariableName(DeclaredVariable variable)
{
	var ArrayList<String> nameList = new ArrayList<String>
	nameList.add(variable.name)
	return nameList
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ ���� ������������� �� ������ �������� ���������� ImportedVariable
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<String> getVariableName(ImportedVariable variable)
{
	var ArrayList<String> nameList = new ArrayList<String>
	nameList.addAll(variable.varNames)
	return nameList	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������� ��� �����, ������������ ������� � ����������. ������� ������� �� ���� ����������� (���������� ��� ������)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(DeclaredVariable variable)
{
	return "declare"
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������� ��� �����, ������������ ������� � ����������. ������� ������� �� ���� ����������� (���������� ��� ������)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(ImportedVariable variable)
{	
	return "import"	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ � ������ ���������� � �� �����
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableNameAndType(ProgramVariable variable)
{
	return variable.type.getSigned + " ReflexType : "/*  variable.type.getReflexType() + " " + */  + " " + variable.name
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ � ������ ���������� � �� �����
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableNameAndType(PhysicalVariable variable)
{
	return variable.type + " : " + variable.name	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getReflexType(CType type)
{
	return type.toString
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getReflexType(ReflexType type)
{
	return "ReflexType"
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. �������� �� ������, ���� ���� �� ����������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getSigned(ReflexType type)
{
	return ""	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ signed/unsigned
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getSigned(CType type)
{
	if(type.signSpec)
		return 	"unsigned"
	else
		return 	"signed"
}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� ����� ��� StartProcStat: ���������� 1 ������� ArrayList<ActiveProcess>, �����, ���������� ����� ����� �������� ����� � ���������, ������ �������� ���
// ���������, ��� ���� ������ ������ ���������� � �������� ����������, ������� ����������� ���������� ����������, � ����� ����������������
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
// ���������, ��� ���� ������ ������ ���������� � �������� ����������, ������� ����������� ���������� ����������, � ����� ����������������
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
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getActiveList(Statement statement, int contextProcessId)
	{
		return new ArrayList<ActiveProcess>;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� gml �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������. ���������� ������� ����� data-���������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataDiagram(Resource resource)
	'''�writeHeadGML�
	�generateProcessNodes(resource/*, NS_RECTANGLE*/)�
	�getVariablesNodes(resource)�
	�generateDataModel(resource)�
	�generateAllEdges()�
]'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ������� ������, ��������� ���������
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def void clear()
{
	 	procList.clear()
      	count_id  = 0
      	procId.clear()
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// �������� �����. ������� ���� ��������� � ���������� � ���� ��������� ���������.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
      	fsa.generateFile("activity_diagram.gml", generateActivityDiagram(resource));
     	clear()
     	fsa.generateFile("data_diagram.gml", generateDataDiagram(resource));
     	clear()
      }     
}
