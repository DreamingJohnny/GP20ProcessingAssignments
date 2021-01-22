public class Bacteria
{

PVector bacteriaPosition = new PVector();

float bacteriaDiameter;

boolean isAlive;

color livingBacteriaColor = color(255,255,255);
color deadBacteriaColor = color(0, 0, 0);

	public Bacteria (float positionX, float positionY, float bacteriaSize)
	{
		bacteriaPosition.x = positionX;
		bacteriaPosition.y = positionY;

		bacteriaDiameter = bacteriaSize;

		isAlive = false;
	}

	void draw()
	{
		fill(livingBacteriaColor);
		ellipse(bacteriaPosition.x, bacteriaPosition.y, bacteriaDiameter, bacteriaDiameter);
	}
}