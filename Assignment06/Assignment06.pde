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
color textColor;
String gameOverMessage = "GAME OVER";


//Time variables
float deltaTime;
long passedTime;
long currentTime; 

void setup()
{
	//Set our window size
	size(880,720);
	background(255, 255, 255);

	gameText = createFont("Arial", 36);
	textColor = color(7, 167, 23);

	playerOne = new PlayerAvatar();
	
	balls = new Ball[amountOfBalls];
	spawnBalls();

}

void draw()
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
void spawnBalls()
{
	for (int i = 0; i < balls.length; i++)
	{
		balls[i] = new Ball();	
	}
}
void ballHandler()
{
	for (int i = 0; i < balls.length; i++)
	{
		balls[i].update();
		balls[i].show();
	}

	isGameOver = checkGameState();
}
boolean checkGameState()
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
boolean hitDetection(Ball projectile, PlayerAvatar target)
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