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

public class Assignment06 extends PApplet {

/*
Assignment
Start by making a copy from the "Input and Movement" lesson assignment, so we get a character that we can move on the screen.

Create a player class and move as much code out from the main file as possible.
(Let time and delta time still be calculated in the main file)

Add the Ball class from this lesson.

Add size and color to the ball class.

Make the ball class handle bounces at the edge of the screen.

Create 10 balls that can bounce around the screen.

Check if the player collides with a ball.

Make some kind of Game Over screen when the player gets hit.

Extracurricular
Create a ball manager class so we can keep the main file clean.

Add a new ball every 3 second (up to a max of 100 balls).

Add a restart function so that we can press a key to restart the game.

Make sure the new balls don't spawn on the player.
*/
PlayerAvatar firstPlayer;

//Time variables
float deltaTime;
long passedTime;
long currentTime;

public void setup()
{
	//Set our window size
	
	background(255, 255, 255);

	//call player constructor with width of screen as argument (to set size)
	firstPlayer = new PlayerAvatar();

}

public void draw()
{
	background(255, 255, 255);

	//These lines creates a value in time that allows me to compare and compensate for possible lag.
	currentTime = millis();
  	deltaTime = (currentTime - passedTime);
	deltaTime *= 0.001f;

	//draw player char on screen
	firstPlayer.draw();

	//function for moving char
	firstPlayer.moving();

	passedTime = currentTime;
}
class PlayerAvatar{

	PVector position = new PVector();
	PVector velocity = new PVector();
	PVector acceleration = new PVector();
	PVector movement = new PVector();

	//Vars setting up the circle, speed etc.
	float jerk = 2.0f;
	float drag = 0.1f;
	float speed = 25;
	float maxSpeed = 40;

	//I don't want the circle to have absolute proportions, but I want it to be based on the size of the screen
	float sizeAsFractionOfScreen = 40;
	float radius;


	PlayerAvatar(){

	position.x = width / 2;
	position.y = height / 2;

	radius = width / sizeAsFractionOfScreen;

}

public void draw() {
        //Draw our player with red color.
        fill(255, 0, 0);
        ellipse(position.x, position.y, radius * 2, radius * 2);
    }

public void moving() {

	//Need to check later, is this an amazing moment when I could use this instead?
	//Maybe I don't even need to pass something back? If I change what is instead?
	acceleration = input();

	acceleration.mult(jerk * drag * speed * deltaTime);

	//If no input, length of acceleration vector is 0, so we should softly slow down
	if (acceleration.mag() == 0)
	{
		//Use our direction to create opposite breaking force.
  		acceleration.x -= velocity.x * drag * speed * deltaTime;
  		acceleration.y -= velocity.y * drag * speed * deltaTime;
	}

	//Update Velocity by adding acceleration.
	velocity.add(acceleration);

	//sets a hard cap on speed
	velocity.limit(maxSpeed);

	//Should this really be a vector that is owned by this object?
	//Would it not be much more efficient if this were a vector in the function?
	movement = velocity.copy();
	movement.mult(speed * deltaTime);
	//Add our adjusted velocity to our player
	position.add(movement);

}
}
boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;
PVector inputVector = new PVector();

//Key pressed, set our movement variables to true
public void keyPressed()
{
    if (keyCode == LEFT || key == 'a')
      moveLeft = true;
    else if (keyCode == RIGHT || key == 'd')
      moveRight = true;

    if (keyCode == UP || key == 'w')
      moveUp = true;
    else if (keyCode == DOWN || key == 's')
      moveDown = true;
}

//When a key is released, we will set our variable to false
public void keyReleased()
{
    if (keyCode == LEFT || key == 'a')
      moveLeft = false;
    else if (keyCode == RIGHT || key == 'd')
      moveRight = false;

    if (keyCode == UP || key == 'w')
      moveUp = false;
    else if (keyCode == DOWN || key == 's')
      moveDown = false;
}

//Returns a normalized PVector input
public PVector input()
{
  /*Reset our input to zero.
  This was one of the places where my initial approach was to decrease the motion vector
  rather than resetting it to zero.
  */
  inputVector.x = 0;
  inputVector.y = 0;

  //Change our input vector based on userinput
  if (moveLeft) {
    inputVector.x -= 1;
  }
  if (moveRight) {
    inputVector.x += 1;
  }
  if (moveUp) {
    inputVector.y -= 1;
  }
  if (moveDown) {
    inputVector.y += 1;
  }

  //Normalize our input so we don't go faster diagonaly
  inputVector.normalize();

  //Returns the now normalized vector
  return inputVector;
}
  public void settings() { 	size(640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment06" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
