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
		label	"Start"
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
			text	"Start"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	2
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
		id	3
		label	"VoiceAlarm"
	    graphics
	    [
	    	w	100.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"VoiceAlarm"
			fontSize	12
			fontName	"Dialog"
		]
	]
	node
	[
		id	4
		label	"WaitForDoorClose"
	    graphics
	    [
	    	w	160.0
	    	h	48.0
	    	type	"roundrectangle"
	    	raisedBorder	0
	    	fill	"#FFFFFF"
	    	outline	"#000000"
	    ]
		LabelGraphics
		[
			text	"WaitForDoorClose"
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
		label	"([ !(K_DOOR == OPEN)  &amp;&amp; (COOK_TIME != 0) ]/Y_WARM = ON)"
	]
	edge
	[
		source	2
		target	4
		label	"([ (K_DOOR == OPEN) ]/Y_WARM = OFF)"
	]
	edge
	[
		source	2
		target	3
		label	"(Timeout [ time = 100ticks ]/Y_WARM = OFF)"
	]
	edge
	[
		source	3
		target	1
		label	"(Timeout [ time = 100ticks ]/Y_ALARM = OFF)"
	]
	edge
	[
		source	4
		target	1
		label	"([ (COOK_TIME == 0) ])"
	]
	edge
	[
		source	4
		target	2
		label	"([ !(COOK_TIME == 0)  &amp;&amp; (K_DOOR != OPEN) ]/Y_WARM = ON)"
	]
	edge
	[
		source	4
		target	4
		label	"([ !(COOK_TIME == 0)  &amp;&amp; !(K_DOOR != OPEN) ])"
	]
	edge
	[
		source	4
		target	1
		label	"(Timeout [ time = 180000ticks ]/COOK_TIME = 0)"
	]
]