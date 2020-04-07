Creator	"tranlator"
Version	"2.15"
graph
[
	hierarchic	1
	label	""
	directed	10
	node
	[
		id	0
		label	"     "
	    graphics
	    [
	    	w	50.0
	    	h	48.0
	    	type	"circle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"     "
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	1
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
		id	2
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
		id	3
		label	"AddMinute"
	    graphics
	    [
	    	w	90.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"AddMinute"
			fontSize	12
			fontName	"Dialog"
		]
	]
	edge
	[
		source	0
		target	1
		label	""
	]
	edge
	[
		source	1
		target	2
		label	"()"
	]
	edge
	[
		source	2
		target	3
		label	"()"
	]
	edge
	[
		source	3
		target	2
		label	"(Timeout [ time = 6000ticks ]/Time += ONE_MIN)"
	]
]