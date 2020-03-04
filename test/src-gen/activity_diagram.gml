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
		label	"Dryer"
	    graphics
	    [
	    	w	50.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Dryer"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	1
		label	"Proc1"
	    graphics
	    [
	    	w	50.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Proc1"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	2
		label	"Proc2"
	    graphics
	    [
	    	w	50.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Proc2"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	3
		label	"Proc3"
	    graphics
	    [
	    	w	50.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"Proc3"
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
		source	1
		target	2
		label	"start"
	]
	edge
	[
		source	1
		target	3
		label	"start"
	]
	edge
	[
		source	2
		target	1
		label	"stop"
	]
	edge
	[
		source	3
		target	3
		label	"stop"
	]
]