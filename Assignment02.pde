float xAlongTop=10,yAlongSide=400,xGonnaStayZero=0,yGonnaStayZero=0;

void setup() {

//Logical markers goes here

//Design
	size(512, 512);
	background(#2B0DFA);
	stroke(#5B6267);

}

void draw() {
//Try first, then change to do-while, better otherwise x won't be one ever
	while(xAlongTop <= 400) {

		line(xAlongTop,yGonnaStayZero,xGonnaStayZero,yAlongSide);

		xAlongTop+=10;

		yAlongSide = 400-xAlongTop;
}

}
