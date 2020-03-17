Creator	"tranlator"
Version	"2.15"
graph
[
	hierarchic	1
	label	""
	directed	1
	node
	[
		id	0
		label	"INIT"
	    graphics
	    [
	    	w	40.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"INIT"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	1
		label	"Start_Button_Controle"
	    graphics
	    [
	    	w	210.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Start_Button_Controle"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	2
		label	"Lights_alarm"
	    graphics
	    [
	    	w	120.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Lights_alarm"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	3
		label	"Cooking"
	    graphics
	    [
	    	w	70.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Cooking"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	4
		label	"Clocks"
	    graphics
	    [
	    	w	60.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Clocks"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	5
		label	"Display_work"
	    graphics
	    [
	    	w	120.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Display_work"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	6
		label	"ChangeTimeButtonControle"
	    graphics
	    [
	    	w	240.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"ChangeTimeButtonControle"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	7
		label	"HourButtonControle"
	    graphics
	    [
	    	w	180.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"HourButtonControle"
			fontSize	12
			fontName	"Dialog"
		]
	]
	edge
	[
		source	0
		target	1
		label	"start"
	]
	edge
	[
		source	0
		target	3
		label	"start"
	]
	edge
	[
		source	0
		target	2
		label	"start"
	]
	edge
	[
		source	0
		target	4
		label	"start"
	]
	edge
	[
		source	0
		target	5
		label	"start"
	]
	edge
	[
		source	0
		target	6
		label	"start"
	]
	edge
	[
		source	0
		target	7
		label	"start"
	]
	edge
	[
		source	0
		target	0
		label	"stop"
	]
]