class Ball
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	color ballColor;

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
	
	void update()
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

	void show()
	{
		//Draw ball on the screen
		fill(ballColor);
		ellipse(position.x - radius, position.y - radius, radius * 2, radius * 2);
	}
}