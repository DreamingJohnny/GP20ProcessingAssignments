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

public class Assignment04 extends PApplet {

/*Using the input example from the lesson. Make it so a circle/character can move left-right-up-down.

Create input that gives the circle/character acceleration when it moves.

Make it deaccelerate down to a standstill when no key is pressed.

Use deltaTime to control movement every update.

Extracurricular
Change the program to make the character screen wrap. If it goes out from the left of the screen when it enters on the right and vice versa. The character should not be able to leave the screen up or down.

Use the PVector class to handle position and velocity.

Pressing g on the keyboard should toggle gravity on or off. With gravity on the circle/character should fall down and bounce on the bottom of the screen.*/

PVector circlePosition = new PVector(0,0);
PVector circleMovement = new PVector(0,0);
/*Acceleration and speed causes a problem here, since the ball will try to accelerate and might reach too high speeds. Either add a cap or make
circles acceleration work in another way*/
float circleDiameter, circleVelocity, circleSpeed = 2.0f, circleAcceleration = 1.01f, circleFriction = 0.99f, deltaTime;
int colorOfBackground = color(255, 255, 255);
int timePassed, currentTime;

public void setup()
{
  //Designer markers
  
  background(colorOfBackground);
  stroke(0);

  //Logical markers
  circlePosition.x = width/2;
  circlePosition.y = height/2;
  circleDiameter = width/40;
}

/*
TODO: Automate tabs
TODO: Accelerate
TODO: Decelerate
//Go through this again. 
TODO: deltaTime
TODO: Screenwrap
*/

public void draw() {

  background(colorOfBackground);
  //Need to check, was there really a problem with having two keys pressed at the same time?

  currentTime = millis();

  deltaTime = currentTime - timePassed;

  deltaTime *= 0.001f;

  movement();
  
  ellipse(circlePosition.x, circlePosition.y, circleDiameter, circleDiameter);

  timePassed = currentTime;
}
// Assignment04EdgeCheck.pde

// void edgeCheck(){

// if(circlePosition.x > width && circleMo

// }
boolean moveLeft,moveRight,moveUp,moveDown;

//Key pressed, set our variables to true
public void keyPressed(){

  	if (keyCode == LEFT || key == 'a'){
    	moveLeft = true;
    	circleMovement.x *= (circleAcceleration*deltaTime);
    	circleMovement.x += circleSpeed*-1;

	}
  	else if (keyCode == RIGHT || key == 'd'){
    	moveRight = true;
    	circleMovement.x *= (circleAcceleration*deltaTime);
    	circleMovement.x += circleSpeed;
	}
	if (keyCode == UP || key == 'w'){
    	moveUp = true;
	}
  	else if (keyCode == DOWN || key == 's'){
    	moveDown = true;
	}

 }

//When a key is released, we will set our variable to false
public void keyReleased(){

  	if (keyCode == LEFT || key == 'a'){
    	moveLeft = false;
	}
  	else if (keyCode == RIGHT || key == 'd'){
    	moveRight = false;
	}
	if (keyCode == UP || key == 'w'){
    	moveUp = false;
	}
 	else if (keyCode == DOWN || key == 's'){
    	moveDown = false;
	}

}

public void movement(){

	circlePosition.add(circleMovement);

 	circleMovement.x *= circleFriction;


	// if (moveLeft == true && moveRight == false) {
	// 	circlePosition.add(circleMovement);
	//   	}
 //  	if (moveRight == true && moveLeft == false) {
 //    	circlePosition.add(circleMovement);
 //  	}
 //  	if (moveUp == true && moveDown == false) {
 //    	circlePosition.y -= circleSpeed;
 //  	}
 //    if (moveDown == true && moveUp == false) {
 //    	circlePosition.y += circleSpeed;

}
  public void settings() {  size(1280,960); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment04" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
