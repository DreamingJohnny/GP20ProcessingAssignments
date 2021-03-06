class PlayerAvatar
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	color objectColor = color(289, 74, 95);
	PVector acceleration = new PVector();
	PVector movement = new PVector();

	//Vars setting up the circle, speed etc.
	float jerk = 2.0;
	float drag = 0.1;
	float speed = 25;
	float maxSpeed = 40;

	//I don't want the circle to have absolute proportions, I want it to be based on the size of the screen
	float radius;
	float sizeAsFractionOfScreen = 40;

	//Artwork
	color playerColor = color(62, 109, 245);

	//Player constructor
	PlayerAvatar() 
	{
		position.x = width / 2;
		position.y = height / 2;
		radius = width / sizeAsFractionOfScreen;
	}

	void draw()
	{
		stroke(playerColor);
		fill(playerColor);
		ellipse(position.x, position.y, radius * 2, radius * 2);
	}

	void moving()
	{
		//Need to check later, is this an amazing moment when I could use this instead?
		//Maybe I don't even need to pass something back? If I change what is instead?
		acceleration = input();

		acceleration.mult(jerk * drag * speed * deltaTime);

		//If no input, length of acceleration vector is 0, so we should softly slow down
		if (acceleration.mag() == 0)
		{
			//Use our direction to create opposite breaking force.
			acceleration.x -= velocity.x * drag * speed * deltaTime;
			acceleration.y -= velocity.y * drag * speed * deltaTime;
		}

		//Update Velocity by adding acceleration.
		velocity.add(acceleration);

		//sets a hard cap on speed
		velocity.limit(maxSpeed);

		//Should this really be a vector that is owned by this object?
		//Would it not be much more efficient if this were a vector in the function?
		movement = velocity.copy();
		movement.mult(speed * deltaTime);

		position.add(movement);
	}
}