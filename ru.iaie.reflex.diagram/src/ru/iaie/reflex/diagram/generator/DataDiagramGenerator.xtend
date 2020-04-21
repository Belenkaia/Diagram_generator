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

class DataDiagramGenerator extends ProcessDiagramGraphMLGenerator{
	var HashMap<String, Integer> variableId = new HashMap<String, Integer>();

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую описание вершин переменных в формате gml для диаграммы связи по данным
//
// Output: string with data nodes notification in the GML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def getVariablesNodes(Resource resource)
	{
		count_id = procId.size()
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // идем по объявленным переменным
		{
			var DiagramNode newNode = new DiagramNode(variable.getVariableNameAndType(), "ellipse")
			addElementToProcId(newNode)
		 	variableId.put(variable.name, count_id - 1) // запоминаем соответствие имени переменной назначенной ее вершине Id
	        //incrementCountId() // инкрементируем счетчик вершин (это число будет Id для вершины следующей вершины)
	    }
	    zeroCountId()
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую описание вершин переменных в формате gml для диаграммы связи по данным
//
// Output: string with data nodes notification in the GML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*	def generateVariablesNodes(Resource resource)
	{
		var String tempStr = "";
		for (variable : variableId.values()) // идем по объявленным переменным
		{
			tempStr += gmlTextGenerator.generateOneProcessNode(count_id, variable, "ellipse"/*"roundrectangle"*/ //)
			//variableId.put(variable.name, count_id) // запоминаем соответствие имени переменной назначенной ее вершине Id
/*	        incrementCountId() // инкрементируем счетчик вершин (это число будет Id для вершины следующей вершины)
	    }
	    return tempStr;
	}
 */
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую описание вершин переменных в формате GraphML для диаграммы связи по данным
//
// Output: string with data nodes notification in the GraphML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*	def getVariablesNodesGraphML(Resource resource)
	{
		var String tempStr = "";
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // идем по объявленным переменным
		{
			tempStr += graphMLTextGenerator.nodeGraphMLGenerate(count_id, variable.getVariableNameAndType(), "ellipse", "")
			variableId.put(variable.name, count_id) // запоминаем соответствие имени переменной назначенной ее вершине Id
	        incrementCountId() // инкрементируем счетчик вершин (это число будет Id для вершины следующей вершины)
	    }
	    return tempStr;
	}

 */
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод создает модель связи процессов и переменных в формате ArrayList<ActiveProcess> (procList)
//
//Method construct the model of connecting behind processes and variables like an ArrayList<ActiveProcess> (procList)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataModel(Resource resource)
	{
		
		for (process : resource.allContents.toIterable.filter(Process)) 
		{
			//var DiagramNode tmp = new DiagramNode(process.name)
			for(vars : process.variable)
			{
				var ArrayList<String> tempNames = vars.getVariableName()  //импортируемые переменные хранятся списком, а объявленные по одной
				for (varName : tempNames)
				{
					var ActiveProcess node = new ActiveProcess
					node.idFrom = getElementIndexProcId(process.name)
					node.idTo = variableId.get(varName)
					node.action = vars.getVariableAction() //отражаем связь - импорт или объявление
					procList.add(node)
				}
			}
		}
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Возвращает имя переменной DeclaredVariable, обернутое в список
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
// Полиморфный метод. Возвращает список имен импортируемых из одного процесса переменных ImportedVariable
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
// Полиморфный метод. Возвращает подпись для ребра, соединяющего процесс и переменную. Подпись зависит от типа зависимости (декларация или импорт)
//
//Polymorphic method. Output: string which is a label of edge between variable node and process node in graph. "declare" for DeclaredVariable 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(DeclaredVariable variable)
{
	return "declare"
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Возвращает подпись для ребра, соединяющего процесс и переменную. Подпись зависит от типа зависимости (декларация или импорт)
//
//Polymorphic method. Output: string which is a label of edge between variable node and process node in graph. "import" for ImportedVariable
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableAction(ImportedVariable variable)
{	
	return "import"	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Возвращает строку с именем переменной и ее типом
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
		return '''« NodeModelUtils.getNode(type).text.trim »'''
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Возвращает строку с именем переменной и ее типом
// Polymorphic method. Output: string with variable's name and type
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getVariableNameAndType(PhysicalVariable variable)
{
	return variable.type + " : " + variable.name	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Заглушка на случай, если поле не определено
// Polymorphic method. Output: nullable string
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch String getSigned(ReflexType type)
{
	return ""	
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод. Возвращает строку signed/unsigned
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
//
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def generateDataDiagramModel(Resource resource)
{
	generateProcList(resource)
	getVariablesNodes(resource)
	generateDataModel(resource)
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод соединяет вместе заголовок gml файла, список вершин диаграммы и список ребер. Для этого вызываются соответствующие методы. Возвращает готовый текст data-диаграммы
//
// Method is collecting a GML head, nodes list (process nodes and data nodes) and edge list of diagram by calling the same methods 
// Output: finished text of GML data diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateDataDiagram(HashMap<String, DiagramNode> nodesId, ArrayList<ActiveProcess> diagramModel)
	{
		var String result = ""
		System.out.print("Generate GML data diagram...")
		procId = nodesId
		procList = diagramModel
		result += '''«gmlTextGenerator.writeHeadGML(this)»
		'''
		result += '''	«gmlTextGenerator.generateNodes(this/*, nodesId */)»
		'''
		result += '''	«gmlTextGenerator.generateAllEdges(diagramModel)»
		'''
		result += "]"
		System.out.println("done.")
		return result
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод соединяет вместе заголовок GraphML файла, список вершин диаграммы и список ребер. Для этого вызываются соответствующие методы. Возвращает готовый текст data-диаграммы
//
// Method is collecting a GraphML head, nodes list (process nodes and data nodes) and edge list of diagram by calling the same methods 
// Output: finished text of GraphML data diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateDataGraphMLDiagram(HashMap<String, DiagramNode> nodesId, ArrayList<ActiveProcess> diagramModel, String url, String statechartFileNameTail)
	{
		var String result = ""
		System.out.print("Generate GraphML data diagram...")
		result += '''«graphMLTextGenerator.headGraphMlGenerator(this)»
		'''
		procId = nodesId
		procList = diagramModel
		result +='''<graph edgedefault="directed" id="G">
	«graphMLTextGenerator.generateNodes(this/*, nodesId */, url, statechartFileNameTail)»
	«graphMLTextGenerator.generateAllEdges(diagramModel)»
  </graph>
    <data key="d6">
	  <y:Resources/>
	</data>
</graphml>'''
		System.out.println("done.")
		return result
	}
}