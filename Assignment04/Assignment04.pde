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
float circleDiameter, circleVelocity, circleSpeed = 2.0, circleAcceleration = 1.01, circleFriction = 0.99, deltaTime;
color colorOfBackground = color(255, 255, 255);
int timePassed, currentTime;

void setup()
{
  //Designer markers
  size(1280,960);
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

void draw() {

  background(colorOfBackground);
  //Need to check, was there really a problem with having two keys pressed at the same time?

  currentTime = millis();

  deltaTime = currentTime - timePassed;

  deltaTime *= 0.001f;

  movement();
  
  ellipse(circlePosition.x, circlePosition.y, circleDiameter, circleDiameter);

  timePassed = currentTime;
}