package ru.iaie.reflex.diagram.generator

import java.util.ArrayList

class GMLDiagramGenerator {
	protected var count_id = 0;
	protected var ArrayList<ActiveProcess> procList = new ArrayList<ActiveProcess>;
	protected var procId = new ArrayList<String>();
	 
	def addElementToProcList(ActiveProcess elem)
	{
		procList.add(elem)
	}
	 
	def addAllElementsToProcList(ArrayList<ActiveProcess> list)
	{
		procList.addAll(list)
	}
	def addElementToProcId(String elem)
	{
		procId.add(elem)
	}
	def addElementToProcId(int index, String elem)
	{
		procId.add(index, elem)
	}
	def String getElementProcId(int index)
	{
		return procId.get(index)
	}
	
	def int getElementIndexProcId(String elem)
	{
		return procId.indexOf(elem)
	}
	
	def zeroCountId()
	{
		count_id = 0
	}
	def incrementCountId()
	{
		count_id ++;
	}
	def int getCountId()
	{
		return count_id
	}
	
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
}