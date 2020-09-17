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
float circleDiameter, circleSpeed = 5.0f;
int colorOfBackground = color(255, 255, 255);

public void setup()
{
  //Designer markers
  
  background(colorOfBackground);
  stroke(0);
  
  //Logical markers
  circlePosition.x = width/2;
  circlePosition.y = height/2;
  circleDiameter = width/20;
}

/*
TODO: Accelerate
TODO: Decelerate
TODO: deltaTime
TODO: Screenwrap
*/

public void draw() {

  background(colorOfBackground);
  //Need to check, was there really a problem with having two keys pressed at the same time?
  if (moveLeft == true && moveRight == false) {
    circlePosition.x -= circleSpeed;
  }
  if (moveRight == true && moveLeft == false) {
    circlePosition.x += circleSpeed;
  }
  if (moveUp == true && moveDown == false) {
    circlePosition.y -= circleSpeed;
  }
    if (moveDown == true && moveUp == false) {
    circlePosition.y += circleSpeed;
  }
  ellipse(circlePosition.x, circlePosition.y, circleDiameter, circleDiameter);
}
boolean moveLeft,moveRight,moveUp,moveDown;

//Key pressed, set our variables to true
public void keyPressed()
{

  	if (keyCode == LEFT || key == 'a'){
    moveLeft = true;
	}
  	else if (keyCode == RIGHT || key == 'd'){
    moveRight = true;
	}
	if (keyCode == UP || key == 'w'){
    moveUp = true;
	}
  	else if (keyCode == DOWN || key == 's'){
    moveDown = true;
	}
 }

//When a key is released, we will set our variable to false
public void keyReleased()
{
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
  public void settings() {  size(640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment04" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
