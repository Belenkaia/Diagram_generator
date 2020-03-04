package ru.iaie.reflex.diagram.generator

class ActiveProcess {
		var int idFrom = 0;
		var int idTo = 0;
		var String action = "";
		/*new (int idF, int idT, String act)
		{
			idFrom = idF
			idTo = idT
			action = act
		}*/
		def void setAction(String act)
		{
			action = act;
		}
		def void setIdFrom(int id)
		{
			idFrom = id;
		}
		def void setIdTo(int id)
		{
			idTo = id;
		}
		
		def String getAction()
		{
			return action;
		}
		def int getIdFrom()
		{
			return idFrom;
		}
		def int getIdTo()
		{
			return idTo
		}
	}