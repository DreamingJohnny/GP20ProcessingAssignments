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

//Time markers
float deltaTime;
long passedTime;
long currentTime;

void setup()
{
	//Art markers
	size(640,480);
	background(255, 255, 255);

	//call player constructor
	firstPlayer = new PlayerAvatar();

}

void draw()
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
