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

public class Assignment03 extends PApplet {

float circleDiamater, circleFriction, toDivideBy;

PVector circlePositioning = new PVector();
PVector circleGoal = new PVector();
PVector circleVelocity = new PVector();
PVector circleDrag = new PVector();

public void setup() {

	//Design
	
	background(255,255,255);
	stroke(0);

	//Logical markers
	circleDiamater = width/20;
	/*The assignment says that the circle should "appear" so instead of having it appear at the very same spot everytime
	I try to give myself a few more moving parts to work with by making it random*/
	circlePositioning.x = random(width);
	circlePositioning.y = random(height);
	//Disgusting code, must fix better here.
	toDivideBy = 100;


}

public void draw() {
	
	background(255,255,255);

	ellipse(circlePositioning.x,circlePositioning.y,circleDiamater,circleDiamater);

	circlePositioning.add(circleVelocity);

	//Add friction, might use a friction PVektor instead of a friction float here, look later.

	//When hitting edge, might become problem with my friction var sending it "backwards"

	//Might be easiest to fix circle vibrating at edge with a simple "if velocity lower than 2 make velocity 0"
}
public void mouseClicked() {
	//Do I really need to recreate the vector like this?
	circlePositioning = new PVector(mouseX,mouseY);

	//I resent the fact that I need to do this for now, must be better way.
	//circlePositioning.x = mouseX;
	//circlePositioning.y = mouseY;

}
public void mouseDragged() {
	//Can processing sort this out? or do I need to divide it up for it to work?
	//TODO check if an if statement, in draw will help line to not vibrate
	line(circlePositioning.x,circlePositioning.y,mouseX,mouseY);
}
public void mouseReleased() {
	//Does 
	//So, this will save the vector for the position where user lets go of the mouse.
	circleGoal = new PVector(mouseX,mouseY);
	
	circleVelocity = circleGoal.sub(circlePositioning);
	circleVelocity = circleVelocity.div(toDivideBy);

	
}
  public void settings() { 	size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment03" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
