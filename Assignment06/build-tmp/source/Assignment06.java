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
PlayerAvatar playerOne;
boolean isPlayerHit;

//Var for ball
Ball[] balls;
int amountOfBalls = 10;

//var for gamestate
boolean isGameOver;

PFont gameText;
int textColor;
String gameOverMessage = "GAME OVER";


//Time variables
float deltaTime;
long passedTime;
long currentTime; 

public void setup()
{
	//Set our window size
	
	background(255, 255, 255);

	gameText = createFont("Arial", 36);
	textColor = color(7, 167, 23);

	playerOne = new PlayerAvatar();
	
	balls = new Ball[amountOfBalls];
	spawnBalls();

}

public void draw()
{
	background(255, 255, 255);

	//These lines creates a value in time that allows me to compare and compensate for possible lag.
	currentTime = millis();
	deltaTime = (currentTime - passedTime);
	deltaTime *= 0.001f;

	if (isGameOver)
	{
		textFont(gameText, 46);
		fill(textColor);
		textAlign(CENTER);

		text(gameOverMessage, width / 2, height / 3);
	}
	else
	{
		//draw player char on screen
		playerOne.draw();

		ballHandler();
	}
	passedTime = currentTime;
}
public void spawnBalls()
{
	for (int i = 0; i < balls.length; i++)
	{
		balls[i] = new Ball();	
	}
}
public void ballHandler()
{
	for (int i = 0; i < balls.length; i++)
	{
		balls[i].update();
		balls[i].show();
	}

	isGameOver = checkGameState();
}
public boolean checkGameState()
{
	for (int i = 0; i < balls.length; i++)
	{
		isPlayerHit = hitDetection(balls[i], playerOne);

		if (isPlayerHit)
		{
			return true;
		}	
	}

	return false;
}
public boolean hitDetection(Ball projectile, PlayerAvatar target)
{
	float maxDistance = projectile.radius + target.radius;

	if(abs(projectile.position.x - target.position.x) > maxDistance || abs(projectile.position.y - target.position.y) > maxDistance)
	{
		return false;
	}
	else if(dist(projectile.position.x, projectile.position.y, target.position.x, target.position.y) > maxDistance)
	{
		return false;
	}
	else
	{
		return true;
	}
}
class PlayerAvatar
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	int objectColor = color(289, 74, 95);
	PVector acceleration = new PVector();
	PVector movement = new PVector();

	//Vars setting up the circle, speed etc.
	float jerk = 2.0f;
	float drag = 0.1f;
	float speed = 25;
	float maxSpeed = 40;

	//I don't want the circle to have absolute proportions, I want it to be based on the size of the screen
	float radius;
	float sizeAsFractionOfScreen = 40;

	//Artwork
	int playerColor = color(62, 109, 245);

	//Player constructor
	PlayerAvatar() 
	{
		position.x = width / 2;
		position.y = height / 2;
		radius = width / sizeAsFractionOfScreen;
	}

	public void draw()
	{
		stroke(playerColor);
		fill(playerColor);
		ellipse(position.x, position.y, radius * 2, radius * 2);
	}

	public void moving()
	{
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
	if (moveLeft)
	{
		inputVector.x -= 1;
	}
	if (moveRight)
	{
		inputVector.x += 1;
	}
	if (moveUp)
	{
		inputVector.y -= 1;
	}
	if (moveDown)
	{
	inputVector.y += 1;
	}

	//Normalize our input so we don't go faster diagonaly
  	inputVector.normalize();

	//Returns the now normalized vector
	return inputVector;
}
class Ball
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	int ballColor;

	float radius;


	//Constructor without arguments
	public Ball()
	{
		//Create vector objects

		position.x = random(0, width);
		position.y = random(0, height);

		//Create vector for velocity and set random direction
		velocity.x = random(10) - 5;
		velocity.y = random(10) - 5;

		ballColor = color(289, 74, 95);

		radius = 10;

	}

	//Constructor with position arguments
	public Ball (int x, int y)
	{
		position = new PVector(x, y);

		velocity = new PVector();
		velocity.x = random(10) - 5;
		velocity.y = random(10) - 5;
	}
	
	public void update()
	{
		//Update ball position
		position.x += velocity.x;
		position.y += velocity.y;

		//Bounce if hit wall
		if (position.x > width || position.x < 0)
		{
			velocity.x *= -1;
		}
		if (position.y > height || position.y < 0)
		{
	   		velocity.y *= -1;
		}
	}

	public void show()
	{
		//Draw ball on the screen
		fill(ballColor);
		ellipse(position.x - radius, position.y - radius, radius * 2, radius * 2);
	}
}
  public void settings() { 	size(880,720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment06" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
