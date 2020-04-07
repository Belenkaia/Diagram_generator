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
		label	"PressControl"
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
			text	"PressControl"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	2
		label	"PauseOnButtonBounce"
	    graphics
	    [
	    	w	190.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"PauseOnButtonBounce"
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
		label	"([ (K_BUTTON_HOUR == ON) ]/Time += ONE_MIN * 60)"
	]
	edge
	[
		source	2
		target	1
		label	"(Timeout [ time = 100ticks ])"
	]
]