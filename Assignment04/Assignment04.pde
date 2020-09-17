/*Using the input example from the lesson. Make it so a circle/character can move left-right-up-down.

Create input that gives the circle/character acceleration when it moves.

Make it deaccelerate down to a standstill when no key is pressed.

Use deltaTime to control movement every update.

Extracurricular
Change the program to make the character screen wrap. If it goes out from the left of the screen when it enters on the right and vice versa. The character should not be able to leave the screen up or down.

Use the PVector class to handle position and velocity.

Pressing g on the keyboard should toggle gravity on or off. With gravity on the circle/character should fall down and bounce on the bottom of the screen.*/

PVector circlePosition = new PVector(0,0);
float circleDiameter, circleSpeed = 3.0;
color colorOfBackground = color(255, 255, 255);

void setup()
{
  //Designer markers
  size(640,480);
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

void draw() {

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