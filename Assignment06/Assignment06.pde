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


//Create our movement vectors
//Need to fix so that these aren't global var, is the answer to make constructor and class?
PVector position = new PVector();
PVector velocity = new PVector();
PVector acceleration = new PVector();
PVector circleMovement = new PVector();

//Vars setting up the circle, speed etc.
float circleAcceleration = 1.05;
float circleDrag = 0.2;
float circleSpeed = 15;
float circleMaxSpeed = 30;
float circleDiameter = 0;
//I don't want the circle to have absolute proportions, but I want it to be based on the size of the screen
float circleAsFractionOfScreen = 15;

//Time variables
float deltaTime;
long passedTime;
long currentTime;

void setup()
{
	//Set our window size
	size(640,480);

	//Set startposition in the middle of the screen
	position.x = width / 2;
	position.y = height / 2;

	circleDiameter = width / circleAsFractionOfScreen;
}

void draw()
{
	background(255, 255, 255);

	//These lines creates a value in time that allows me to compare and compensate for possible lag.
	currentTime = millis();
  	deltaTime = (currentTime - passedTime);
	deltaTime *= 0.001f;

	/*
	Get input from the user/player, this is sort of binary, either 0 or 1, 
	the speed comes further down, there is no possibility of pressing the key really hard.
	later on it might be possible to implement a "run" button here? if you press "r" acceleration becomes 2 instead of 1?
	*/
	acceleration = input();

	/*
	The circle accelerates multiplied by circleSpeed,
	deltaTime is to compensate for difference in frameRate.
	I also could not stop myself from adding a circleDrag here, so the circle doesn't move in a vacuum.
	circleDrag will lead to slower acceleration since the var is less than one.
	It still does create a problem for me since it is used to decrease the deacceleration,
	since it is multiplied with the velocity,
	possibly I should break it out of that equation and have it be applied on its own?
	so in the "if-statement, acceleration should be decreased twice?
	Once by "only" drag,
	and once by everything else? 
	*/
	acceleration.mult(circleAcceleration * circleDrag * circleSpeed * deltaTime);

	//If no input, length of acceleration vector is 0, so we should softly slow down
	if (acceleration.mag() == 0)
	{
		//Use our direction to create opposite breaking force.
  		acceleration.x -= velocity.x * circleDrag * circleSpeed * deltaTime;
  		acceleration.y -= velocity.y * circleDrag * circleSpeed * deltaTime;
	}

	//Update Velocity by adding acceleration.
	velocity.add(acceleration);

	//sets a hard cap on speed
	velocity.limit(circleMaxSpeed);

	/*
	Create a new temporary vector so deltaTime doesn't change our real velocity
	I will need to look at this one more time, I cannot believe that a simple
	"circleMovement = velocity" means that the vector velocity will be affected by what happens
	to the vector circleMovement when it is multiplied on the next line.
	*/
	circleMovement = velocity.copy();
	circleMovement.mult(circleSpeed * deltaTime);
	//Add our adjusted velocity to our player
	position.add(circleMovement);

	/*
	Draw our player
	Next step for me, in programming, must be to put this in it's own function.
	*/
	ellipse(position.x, position.y, circleDiameter, circleDiameter);

	/*
	Save the time when the last frame was run
	I do wonder if you couldn't make a function that keeps track of the time?
	That passed it the millis value at the beginning and end of draw?
	Would that risk taking too long time and make the whole purpose work less well?
	*/
	passedTime = currentTime;
}
