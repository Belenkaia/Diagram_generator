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
// Метод возвращает строку, содержащую заголовок выходного GML файла. Также обнуляется счетчик вершин (count_id)
//
// Method returns string, which is a head of output GML file. Also nodes counter is made zero 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def writeHeadGML() '''
	Creator	"tranlator"
	Version	"2.15"
	graph
	[
		hierarchic	1
		label	""
		directed	1«count_id  = 0»
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Метод получает на вход длину подписи вершины и ее тип (те форму), генерирует строку с настройками отобоажения ноды диаграммы (длина, высота, цвет границы, форма вершины, и тд)
//
// Method input: node's label length (nameLength) and its shape (typeOfNode)
// Output: generated string which have a node's properties like shape, height, weight, colors and etc 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateNodeGraphics (int nameLength, String typeOfNode) '''
			graphics
			[
				w	«(nameLength * 10)».0
				h	48.0
				type	"«typeOfNode»"
				raisedBorder	0
				fill	"#FFFFFF"
				outline	"#000000"
			]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод генерирует LabelGraphics, задающий настройки щрифта и текст подписи внутри вершины. На вход получает подпись для вершины
//
// input: label which will be in the graph's node
// Output: string which have a LabelGraphics info about label, like label text, size and font of them
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def generateLabelGraphics(String label)
	'''
			LabelGraphics
			[
				text	"«label»"
				fontSize	12
				fontName	"Dialog"
			]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// На вход поступает число, которое будет присвоено вершине в качестве Id, и текст, который будет внутри вершины  
// Метод возвращает строку, содержащую объявление одной вершины в gml графе,
// вызывая при этом generateNodeGraphics(), generateLabelGraphics() для генерации отдельных частей описания вершины
//
//Input: processId - will be put to gml like node's id
//		processName - label
//		typeOfNode - node's shape
// Output: string which will have a full defining of one node in the output GML diagram.
// Method calls generateNodeGraphics(), generateLabelGraphics() for generate some parts of node's notification
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneProcessNode(int processId, String processName, String typeOfNode)
	'''
	node
	[
		id	«processId»
		label	"«processName»"
	    «generateNodeGraphics(processName.length, typeOfNode)»
		«generateLabelGraphics(processName)»
	]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую в себе объявления всех вершин создаваемой диаграммы процессов. Запоминает соответствие имени процесса его Id в списке procId
// shape определяет форму вершин процессов
//
//Output: string which have a  notification of all process nodes. Also method is saving accord of process name and its id in ArrayList procId
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateProcessNodes(Resource resource/* , int shape*/)
	{
		var String tempString = "";
		for (e : resource.allContents.toIterable.filter(Process)) { //получаем список всех процессов, и проходим по нему
	            // if(shape == NS_RECTANGLE)
	             	tempString += generateOneProcessNode(count_id, e.name, "roundrectangle") // для каждого процесса генерируем строковое описание вершины графа, и конкатенируем его к предыдущим
	            // if(shape == NS_ELLIPSE)
	            // 	tempString += generateOneProcessNode(count_id, e.name, "ellipse")
	             procId.add(count_id, e.name) // запоминаем соответствие имени процесса назначенному ему Id
	             count_id ++ // инкрементируем счетчик процессов (это число будет Id для вершины следующего процесса)
	        }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод соединяет вместе заголовок gml файла, список вершин диаграммы и список ребер. Для этого вызываются соответствующие методы. Возвращает готовый текст activity-диаграммы
//
// Method is collecting a GML head, nodes list and edge list of diagram by calling the same methods 
// Output: finished text of GML activity diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateActivityDiagram(Resource resource)
	'''«writeHeadGML»
	«generateProcessNodes(resource/* , NS_RECTANGLE*/)»
	«constructActiveModel(resource)»
	«checkProcList()»
	«generateAllEdges()»
]'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод принимает fromId - Id вершины, из которой идет ребро. toId -  Id вершины, в которую идет ребро. label - подпись над ребром.
// Возвращает строку, содержащую описание ребра в формате gml с заданными в параметрах свойствами.
//
// Input: fromId - Id of node, from which will go that edge
//		  toId - Id of node to which will go that edge
//		  label - edge's label text
// Output: string with edge's notification
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneEdge(int fromId, int toId, String label)
	'''
	edge
	[
		source	«fromId»
		target	«toId»
		label	"«label»"«System.out.println("generate edge from " + fromId + " to " + toId)»
	]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Возвращает строку, содержащую описание всех ребер графа диаграммы процессов
//
//Output: string with notification of all edges in graph
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateAllEdges()
	{
		var String tempString = ""
		for (var int i; i < procList.size; i ++) // идем по созданной заранее модели
		{
			tempString += generateOneEdge(procList.get(i).idFrom, procList.get(i).idTo, procList.get(i).action) // конкатенация описаний ребер
		}
		return tempString
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Отладочный метод. Выводит в консоль содержимое procList (модель диаграммы)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def checkProcList()
	{
		for (proc : procList)
	    {
	    	System.out.print("proc " + proc.idFrom + " " + proc.action + " " + proc.idTo)
	    }
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод создает модель связи процессов по управлению в виде списка ArrayList<ActiveProcess>
//
// Method construct the model of manage connecting behind processes like an ArrayList<ActiveProcess> 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def constructActiveModel(Resource resource)
	{
		for (var int i = 0; i < procId.size; i ++) // для отладки
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
	         				if(elem.idTo == -1) //дефолтное значение стоит, если останавливает самого себя
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
// Метод возвращает строку, содержащую описание вершин переменных в формате gml для диаграммы связи по данным
//
// Output: string with data nodes notification in the GML format
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def getVariablesNodes(Resource resource)
	{
		var String tempStr = "";
		for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // идем по объявленным переменным
		{
			tempStr += generateOneProcessNode(count_id, variable.getVariableNameAndType(), "ellipse"/*"roundrectangle"*/)
			variableId.put(variable.name, count_id) // запоминаем соответствие имени переменной назначенной ее вершине Id
	        count_id ++ // инкрементируем счетчик вершин (это число будет Id для вершины следующей вершины)
	    }
	    return tempStr;
	}

	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод создает модель связи процессов и переменных в формате ArrayList<ActiveProcess> (procList)
//
//Method construct the model of connecting behind processes and variables like an ArrayList<ActiveProcess> (procList)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataModel(Resource resource)
	{
		for (process : resource.allContents.toIterable.filter(Process)) 
		{
			for(vars : process.variable)
			{
				var ArrayList<String> tempNames = vars.getVariableName()  //импортируемые переменные хранятся списком, а объявленные по одной
				for (varName : tempNames)
				{
					var ActiveProcess node = new ActiveProcess
					node.idFrom = procId.indexOf(process.name)
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
	return variable.type.getSigned + " ReflexType : "/*  variable.type.getReflexType() + " " + */  + " " + variable.name
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
		return 	"signed"
}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Полиморфный метод для StartProcStat: возвращает 1 элемент ArrayList<ActiveProcess>, класс, отражающий связь между командой старт и процессом, внутри которого она
// находится
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
// Полиморфный метод для StopProcStat: возвращает 1 элемент ArrayList<ActiveProcess>, класс, отражающий связь между командой стоп и процессом, внутри которого она
// находится
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
// Полиморфный метод для IfElseStat: возвращает ArrayList<ActiveProcess>, те список классов, отражающих связь между командами старт/стоп и процессом, внутри которого они находятся
// Метод последовательно вызывает функцию getActiveList у полей IfElseStat, после чего собирает вместе результат, и возвращает его
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
// Полиморфный метод getActiveList для составной операции (CompoundStatement) 
// Возвращает общий список объектов ActiveProcess со всех операций внутри составной операции
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
// Полиморфный метод для суперкласса Statement (заглушка)
//
// Polymorphic method for Statement (to avoid exception)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getActiveList(Statement statement, int contextProcessId)
	{
		return new ArrayList<ActiveProcess>;
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод соединяет вместе заголовок gml файла, список вершин диаграммы и список ребер. Для этого вызываются соответствующие методы. Возвращает готовый текст data-диаграммы
//
// Method is collecting a GML head, nodes list (process nodes and data nodes) and edge list of diagram by calling the same methods 
// Output: finished text of GML data diagram
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateDataDiagram(Resource resource)
	'''«writeHeadGML»
	«generateProcessNodes(resource/*, NS_RECTANGLE*/)»
	«getVariablesNodes(resource)»
	«generateDataModel(resource)»
	«generateAllEdges()»
]'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Очистка памяти, обнуление счетчиков
//
// garbage collector, make variables zero
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def void clear()
{
	 	procList.clear()
      	count_id  = 0
      	procId.clear()
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Основной метод. Создает файл диаграммы и записывает в него результат генерации.
//
//Main method. Create diagramm's files and write to them generation results
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
      	fsa.generateFile("activity_diagram.gml", generateActivityDiagram(resource));
     	clear()
     	fsa.generateFile("data_diagram.gml", generateDataDiagram(resource));
     	clear()
      }     
}
