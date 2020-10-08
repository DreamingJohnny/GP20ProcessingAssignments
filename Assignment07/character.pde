public class Character
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	color characterColor;

	float radius;

	boolean isAlive;

	//Constructor without arguments
	public Character()
	{
		position.x = random(0, width);
		position.y = random(0, height);

		//Create vector for velocity and set random direction
		velocity.x = random(10) - 5;
		velocity.y = random(10) - 5;

		characterColor = color(247, 240, 190);

		radius = 10;
	}

	void move()
	{
		position.add(velocity);
	}

	void show()
	{
		fill(characterColor);
		ellipse(position.x, position.y, radius * 2, radius * 2);
	}

	void edgeCheck()
	{
		if (position.x > width && velocity.x > 0)
		{
			position.x = 0;	
		}
		else if (position.x < 1 && velocity.x < 0)
		{
			position.x = width;	
		}
		else if (position.y > height && velocity.y > 0)
		{
			position.y = 0;	
		}
		else if (position.y < 1 && velocity.y < 0)
		{
			position.y = height;	
		}
	}
}