package ru.iaie.reflex.diagram.generator

class DiagramNode {
	var int index
	var String name;
	var String shape;
	var int visited;
	
	new(String name, String shape)
	{
		this.name = name
		this.shape = shape
		visited = -1;
	}
	new(String name)
	{
		this.name = name
		this.shape = "roundrectangle"
		visited = -1;
	}
/*	def int getIndex()
	{
		return index;
	}
	 */
	def void setVisited(int visit)
	{
		visited = visit;
	}
	def String getShape()
	{
		return shape
	}
	
	def String getName()
	{
		return name
	}
	def int getIndex()
	{
		return index;
	}
	def setIndex(int ind)
	{
		index = ind
	}
/*	
	def setIndex(int ind)
	{
		index = ind
	}
	 */
	def setShape(String newShape)
	{
		shape = newShape
	}
	
	def setName(String newName)
	{
		name = newName
	}
	def int getVisited()
		{
			return visited;
		}
	
}