boolean moveLeft;
boolean moveRight;
boolean moveUp;
boolean moveDown;
PVector inputVector = new PVector();

//Key pressed, set our movement variables to true
void keyPressed()
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
void keyReleased()
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
PVector input()
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
