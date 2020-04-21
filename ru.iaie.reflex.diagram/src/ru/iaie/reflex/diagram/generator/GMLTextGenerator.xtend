package ru.iaie.reflex.diagram.generator

import java.util.ArrayList
import java.util.HashMap

class GMLTextGenerator {
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� ��������� ��������� GML �����. ����� ���������� ������� ������ (count_id)
//
// Method returns string, which is a head of output GML file. Also nodes counter is made zero 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	def writeHeadGML(ProcessDiagramGenerator generator) '''
	Creator	"tranlator"
	Version	"2.15"
	graph
	[
		hierarchic	1
		label	""
		directed	1�generator.zeroCountId()�
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//����� �������� �� ���� ����� ������� ������� � �� ��� (�� �����), ���������� ������ � ����������� ����������� ���� ��������� (�����, ������, ���� �������, ����� �������, � ��)
//
// Method input: node's label length (nameLength) and its shape (typeOfNode)
// Output: generated string which have a node's properties like shape, height, weight, colors and etc 
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
//
// input: label which will be in the graph's node
// Output: string which have a LabelGraphics info about label, like label text, size and font of them
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
		id	�processId�
		label	"�processName�"
	    �generateNodeGraphics(processName.length, typeOfNode)�
		�generateLabelGraphics(processName)�
	]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ��������� fromId - Id �������, �� ������� ���� �����. toId -  Id �������, � ������� ���� �����. label - ������� ��� ������.
// ���������� ������, ���������� �������� ����� � ������� gml � ��������� � ���������� ����������.
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
		source	�fromId�
		target	�toId�
		label	"�label�"
	]
	'''
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ���������� ������, ���������� �������� ���� ����� ����� ��������� ���������
//
//Output: string with notification of all edges in graph
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateAllEdges(ArrayList<ActiveProcess> procList)
	{
		var String tempString = ""
		for (var int i; i < procList.size; i ++) // ���� �� ��������� ������� ������
		{
			tempString += generateOneEdge(procList.get(i).idFrom, procList.get(i).idTo, procList.get(i).action) // ������������ �������� �����
		}
		return tempString
	}


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ����� ���������� ������, ���������� � ���� ���������� ���� ������ ����������� ��������� ���������. ���������� ������������ ����� �������� ��� Id � ������ procId
// shape ���������� ����� ������ ���������
//
//Output: string which have a  notification of all process nodes. Also method is saving accord of process name and its id in ArrayList procId
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	def String generateNodes(ProcessDiagramGenerator generator/* ,  HashMap<String, DiagramNode> nodeList*/)
	{
		var String tempString = "";
		for (e : generator.procId.values()) //�������� ������ ���� node, � �������� �� ����
		{ 
	         tempString += generateOneProcessNode(generator.getElementIndexProcId(e.getName()), e.getName(), e.getShape()) // ��� ������� �������� ���������� ��������� �������� ������� �����, � ������������� ��� � ����������
	         //generator.addElementToProcId(generator.getCountId(), e.name)// procId.add(count_id, e.name) // ���������� ������������ ����� �������� ������������ ��� Id
	         //generator.incrementCountId()// �������������� ������� ��������� (��� ����� ����� Id ��� ������� ���������� ��������)
	     }
	    return tempString
	}
	
}

