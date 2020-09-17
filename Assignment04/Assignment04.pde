float x = 0;

void setup()
{
  size(640,480);
  x = width/2;
  ellipseMode(CENTER);
}

void draw() {
	background(50, 166, 240);
  if (moveLeft) {
    x -= 5;
  }
  if (moveRight) {
    x += 5;
  }

	ellipse(x, height / 2, 20, 20);
}
