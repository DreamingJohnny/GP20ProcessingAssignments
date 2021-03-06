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

//Is this an example of a disgusting "magic number" would Robert say?
float circleDiamater, toDivideBy = 100, circleInerta = 5.0f, circleFriction = 0.01f;

PVector circlePositioning = new PVector();
PVector circleGoal = new PVector();
PVector circleVelocity = new PVector();

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

}

public void draw() {
	
	background(255,255,255);

	/*This is to make it so that the circle will halt if moving too slowly
	Partly to make sure it does not vibrate at the edge for some reason*/
	if ((circleVelocity.x + circleVelocity.y <= circleInerta) && (circleVelocity.x + circleVelocity.y >= (circleInerta*=-1)))  {

		circleVelocity.x = 0;
		circleVelocity.y = 0;
	/*Not quite sure if this way, with one if statement and one if else statement is the best way to do this,
	it would mean less code for the program to check I think,
	seeing as it can just check and move on if the "outer" conditions does not apply, rather than needing to go into the loop
	to check both x and y values*/	
	}

	if (circlePositioning.x < 1 || circlePositioning.x > width || circlePositioning.y < 1 || circlePositioning.y > height) {
		
		if (circlePositioning.x < 1 || circlePositioning.x > width) {
			
				circleVelocity.x *= -1;

		}else {

				circleVelocity.y *= -1;

		}		
	}else {//I can't think of a better way right now for fixing this. Since it needs to check velocity for each solar at a time.
		
		if (circleVelocity.x > circleInerta) {

			circleVelocity.x = circleVelocity.x - circleFriction;
			
		}

		if (circleVelocity.y > circleInerta) {

			circleVelocity.y = circleVelocity.y - circleFriction;
			
		}

		if (circleVelocity.x < (circleInerta*-1)) {

			circleVelocity.x = circleVelocity.x + circleFriction;
			
		}

		if (circleVelocity.y < (circleInerta*-1)) {

			circleVelocity.y = circleVelocity.y + circleFriction;
			
		}
	}

	circlePositioning.add(circleVelocity);

	ellipse(circlePositioning.x,circlePositioning.y,circleDiamater,circleDiamater);

}
public void mouseClicked() {
	//Do I really need to recreate the vector like this?
	circlePositioning = new PVector(mouseX,mouseY);

}
public void mouseDragged() {
	//TODO check if an if statement, in draw will help line to not vibrate
	line(circlePositioning.x,circlePositioning.y,mouseX,mouseY);

}
public void mouseReleased() { 
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
