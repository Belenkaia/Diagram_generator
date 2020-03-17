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
// Метод, увеличивающий счетчик процессов. count_id используется для задания Id нодам процессов в выходном файле GML
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	def void increaseProcessId()
	{
		count_id ++
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод, обнуляющий счетчик процессов. count_id используется для задания Id нодам процессов в выходном файле GML
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def void NullProcessId()
	{
		count_id  = 0
	}	
	
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую заголовок выходного GML файла. Также обнуляется счетчик процессов (count_id) 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def writeHeadGML() '''
	Creator	"tranlator"
	Version	"2.15"
	graph
	[
		hierarchic	1
		label	""
		directed	1«NullProcessId()»
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Метод получает на вход длину имени процесса и генерирует строку с настройками отобоажения ноды процесса (длина, высота, цвет границы, форма вершины, и тд)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateNodeGraphics (int nameLength) '''
			graphics
			[
				w	«(nameLength * 5 + 25)».0
				h	48.0
				type	"roundrectangle"
				raisedBorder	0
				fill	"#FFFFFF"
				outline	"#000000"
			]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод генерирует LabelGraphics, задающий настройки щрифта и текст подписи внутри вершины. На вход получает имя процесса
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def generateLabelGraphics(String processName)
	'''
			LabelGraphics
			[
				text	"«processName»"
				fontSize	12
				fontName	"Dialog"
			]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// На вход поступает число, которое будет присвоено вершине процесса в качестве Id, и строковое имя процесса  
// Метод возвращает строку, содержащую объявление одной вершины (те одного процесса) в gml графе,
// вызывая при этом generateNodeGraphics(), generateLabelGraphics() для генерации отдельных частей описания вершины 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateOneProcessNode(int processId, String processName)
	'''
	node
	[
		id	«processId»
		label	"«processName»"
	    «generateNodeGraphics(processName.length)»
		«generateLabelGraphics(processName)»
	]
	'''

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод возвращает строку, содержащую в себе объявления всех вершин создаваемой диаграммы процессов. запоминает соответствие имени процесса его Id в списке procId
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateProcessNodes(Resource resource)
	{
		var String tempString = "";
		for (e : resource.allContents.toIterable.filter(Process)) { //получаем список всех процессов, и проходим по нему
	             tempString += generateOneProcessNode(count_id, e.name) // для каждого процесса генерируем строковое описание вершины графа, и конкатенируем его к предыдущим
	             procId.add(count_id, e.name) // запоминаем соответствие имени процесса назначенному ему Id
	             increaseProcessId() // инкрементируем счетчик процессов (это число будет Id для вершины следующего процесса)
	        }
	    return tempString
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод соединяет вместе заголовок gml файла, список вершин диаграммы и список ребер. Для этого вызываются соответствующие методы.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def generateActivityDiagram(Resource resource)
	'''«writeHeadGML»
	«generateProcessNodes(resource)»
	«constructActiveModel(resource)»
	«checkProcList()»
	«generateAllEdges()»
]'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Метод принимает fromId - Id вершины, из которой идет ребро. toId -  Id вершины, в которую идет ребро. label - подпись над ребром.
// Возвращает строку, содержащую описание ребра в формате gml с заданными в параметрах свойствами.
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
// Полиморфный метод для StartProcStat: возвращает 1 элемент ArrayList<ActiveProcess>, класс, отражающий связь между командой старт и процессом, внутри которого она
// находится, при этом внутри метода информация о процессе недоступна, поэтому заполняется дефолтными значениями, а после перезаписывается
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
// Полиморфный метод для StopProcStat: возвращает 1 элемент ArrayList<ActiveProcess>, класс, отражающий связь между командой стоп и процессом, внутри которого она
// находится, при этом внутри метода информация о процессе недоступна, поэтому заполняется дефолтными значениями, а после перезаписывается
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
// Полиморфный метод для IfElseStat: возвращает ArrayList<ActiveProcess>, те список классов, отражающих связь между командами старт/стоп и процессом, внутри которого они находятся
// Метод последовательно вызывает функцию getActiveList у полей IfElseStat, после чего собирает вместе результат, и возвращает его
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
// Полиморфный метод для суперкласса Statement (заглушка)
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
def dispatch ArrayList<ActiveProcess> getActiveList(Statement statement)
	{
		return null
	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Основной метод. Создает файл диаграммы и записывает в него результат генерации.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	
      	fsa.generateFile("activity_diagram.gml", generateActivityDiagram(resource));
      	procList.clear()
      	NullProcessId()
      	procId.clear()
      }     
}
