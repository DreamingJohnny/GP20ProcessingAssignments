import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Assignment02 extends PApplet {

float xStart,yStart,xEnd=0,yEnd=0,spaceBetweenLines,numberOfLines;

public void setup() {

//Design
	
	background(255,255,255);
	stroke(229);
	strokeWeight(2);

//Logical markers goes here
	xStart = width/20;
	yEnd = height/2;
	//How well spaced out I want the lines to be.
	spaceBetweenLines = height/20;
	/*How many lines I want the parabolic curve to have, might divide if I don't
	want them to cross the entire screen*/
	numberOfLines = height/spaceBetweenLines;

}

public void draw() {
/*This was my first attempt, however, since every 3rd line should be black I resolved
to make a second parabolic curve along the bottom-right part of the screen */
	while(xStart <= height/2) {

		line(xStart,yStart,xEnd,yEnd);

		xStart+=width/20;

		yEnd -= width/20;
}

/*Second attempt,
I decided to use the translate command to reorient myself,
mostly since the command is new for me and I want to practice with it*/
translate(width, height);

xStart = -width;
yStart = 0;
xEnd = 0;
yEnd = 0;

for (int i = 0; i < numberOfLines; ++i) {

	line(xStart,yStart,xEnd,yEnd);

	/*I need to set this again here since I will have an if-statement
	further down that will change the color of every third line it draws */
	stroke(229);

	yEnd -= spaceBetweenLines;
	xStart += spaceBetweenLines;

	if(i % 3 == 0) {

		stroke(0);
	}

}

}
  public void settings() { 	size(778, 778); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment02" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
