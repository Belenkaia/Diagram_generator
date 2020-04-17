package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import java.util.HashMap
import org.eclipse.emf.ecore.resource.Resource
import ru.iaie.reflex.diagram.reflex.CType
import ru.iaie.reflex.diagram.reflex.DeclaredVariable
import ru.iaie.reflex.diagram.reflex.ImportedVariable
import ru.iaie.reflex.diagram.reflex.PhysicalVariable
import ru.iaie.reflex.diagram.reflex.Process
import ru.iaie.reflex.diagram.reflex.ProgramVariable
import ru.iaie.reflex.diagram.reflex.ReflexType
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class DataDiagramGenerator extends ProcessDiagramGenerator{
	var HashMap<String, Integer> variableId = new HashMap<String, Integer>();
	var GMLTextGenerator gmlTextGenerator = new GMLTextGenerator()
	var GraphMLTextGenerator graphMLTextGenerator = new GraphMLTextGenerator()
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� �������� ������ ���������� � ������� gml ��� ��������� ����� �� ������
//
// Output: string with data nodes notification in the GML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def getVariablesNodes(Resource resource)
	{
		var String tempStr = "";
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // ���� �� ����������� ����������
		{
			tempStr += gmlTextGenerator.generateOneProcessNode(count_id, variable.getVariableNameAndType(), "ellipse"/*"roundrectangle"*/)
			variableId.put(variable.name, count_id) // ���������� ������������ ����� ���������� ����������� �� ������� Id
	        incrementCountId() // �������������� ������� ������ (��� ����� ����� Id ��� ������� ��������� �������)
	    }
	    return tempStr;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� �������� ������ ���������� � ������� GraphML ��� ��������� ����� �� ������
//
// Output: string with data nodes notification in the GraphML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def getVariablesNodesGraphML(Resource resource)
	{
		var String tempStr = "";
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // ���� �� ����������� ����������
		{
			tempStr += graphMLTextGenerator.nodeGraphMLGenerate(count_id, variable.getVariableNameAndType(), "ellipse", "")
			variableId.put(variable.name, count_id) // ���������� ������������ ����� ���������� ����������� �� ������� Id
	        incrementCountId() // �������������� ������� ������ (��� ����� ����� Id ��� ������� ��������� �������)
	    }
	    return tempStr;
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ������� ������ ����� ��������� � ���������� � ������� ArrayList<ActiveProcess> (procList)
//
//Method construct the model of connecting behind processes and variables like an ArrayList<ActiveProcess> (procList)
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
//
// Polymorphic method. Output: name of variable DeclaredVariable which was put in ArrayList
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<String> getVariableName(DeclaredVariable variable)
{
	var ArrayList<String> nameList = new ArrayList<String>
	nameList.add(variable.name)
	return nameList
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ ���� ������������� �� ������ �������� ���������� ImportedVariable
//
// Polymorphic method. Output:list of imported from 1 process variable's names
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<String> getVariableName(ImportedVariable variable)
{
	var ArrayList<String> nameList = new ArrayList<String>
	nameList.addAll(variable.varNames)
	return nameList	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������� ��� �����, ������������ ������� � ����������. ������� ������� �� ���� ����������� (���������� ��� ������)
//
//Polymorphic method. Output: string which is a label of edge between variable node and process node in graph. "declare" for DeclaredVariable 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(DeclaredVariable variable)
{
	return "declare"
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������� ��� �����, ������������ ������� � ����������. ������� ������� �� ���� ����������� (���������� ��� ������)
//
//Polymorphic method. Output: string which is a label of edge between variable node and process node in graph. "import" for ImportedVariable
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(ImportedVariable variable)
{	
	return "import"	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ � ������ ���������� � �� �����
// Polymorphic method. Output: string with variable's name and type
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableNameAndType(ProgramVariable variable)
{
	return variable.type.getSigned +" " + variable.type.getType +" :" + variable.name
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

def String getType(ReflexType type)
	{
		return '''� NodeModelUtils.getNode(type).text.trim �'''
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ � ������ ���������� � �� �����
// Polymorphic method. Output: string with variable's name and type
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableNameAndType(PhysicalVariable variable)
{
	return variable.type + " : " + variable.name	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. �������� �� ������, ���� ���� �� ����������
// Polymorphic method. Output: nullable string
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getSigned(ReflexType type)
{
	return ""	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����������� �����. ���������� ������ signed/unsigned
// Polymorphic method. Output: string with signed/unsigned
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getSigned(CType type)
{
	if(type.signSpec)
		return 	"unsigned"
	else
		return 	""
}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� gml �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������. ���������� ������� ����� data-���������
//
// Method is collecting a GML head, nodes list (process nodes and data nodes) and edge list of diagram by calling the same methods 
// Output: finished text of GML data diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataDiagram(Resource resource)
	'''�System.out.print("Generate GML data diagram...")�
	�gmlTextGenerator.writeHeadGML(this)�
	�gmlTextGenerator.generateProcessNodes(resource, this)�
	�getVariablesNodes(resource)�
	�generateDataModel(resource)�
	�gmlTextGenerator.generateAllEdges(procList)�
]�System.out.println("done.")�'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� ������ ��������� GraphML �����, ������ ������ ��������� � ������ �����. ��� ����� ���������� ��������������� ������. ���������� ������� ����� data-���������
//
// Method is collecting a GraphML head, nodes list (process nodes and data nodes) and edge list of diagram by calling the same methods 
// Output: finished text of GraphML data diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataGraphMLDiagram(Resource resource, String url, String statechartFileNameTail)
	'''�System.out.print("Generate GraphML data diagram...")��graphMLTextGenerator.headGraphMlGenerator(this)�
<graph edgedefault="directed" id="G">
	�graphMLTextGenerator.generateProcessNodes(resource, this, url, statechartFileNameTail)�
	�getVariablesNodesGraphML(resource)�
	�graphMLTextGenerator.generateAllEdges(procList)�
  </graph>
    <data key="d6">
	  <y:Resources/>
	</data>
</graphml>�System.out.println("done.")�'''
		
}