class PlayerAvatar{

	PVector position = new PVector();
	PVector velocity = new PVector();
	PVector acceleration = new PVector();
	PVector movement = new PVector();

	//Vars setting up the circle, speed etc.
	float jerk;
	float drag;
	float speed;
	float maxSpeed;
	float radius;
	//I don't want the circle to have absolute proportions, but I want it to be based on the size of the screen
	float sizeAsFractionOfScreen;


public PlayerAvatar(){

	PVector position = new PVector(320, 240);
	PVector velocity = new PVector();
	PVector acceleration = new PVector();
	PVector movement = new PVector();

	//Vars setting up the circle, speed etc.
	float jerk = 1.05;
	float drag = 0.2;
	float speed = 15;
	float maxSpeed = 30;

	//I don't want the circle to have absolute proportions, but I want it to be based on the size of the screen
	float sizeAsFractionOfScreen = 7;
	float radius = 20;

}

void draw() {
        //Draw our player with red color.
        fill(255, 0, 0);
        ellipse(position.x, position.y, radius, radius);
    }

PlayerAvatar playerMoving(PlayerAvatar playerToMove, float deltaTime) {

	//Need to check later, is this an amazing moment when I could use this instead?
	//Maybe I don't even need to pass something back? If I change what is instead?
	playerToMove.acceleration = input();

	playerToMove.acceleration.mult(jerk * drag * speed * deltaTime);

	//If no input, length of acceleration vector is 0, so we should softly slow down
	if (playerToMove.acceleration.mag() == 0)
	{
		//Use our direction to create opposite breaking force.
  		playerToMove.acceleration.x -= velocity.x * drag * speed * deltaTime;
  		playerToMove.acceleration.y -= velocity.y * drag * speed * deltaTime;
	}

	//Update Velocity by adding acceleration.
	playerToMove.velocity.add(acceleration);

	//sets a hard cap on speed
	playerToMove.velocity.limit(maxSpeed);

	//Should this really be a vector that is owned by this object?
	//Would it not be much more efficient if this were a vector in the function?
	playerToMove.movement = playerToMove.velocity.copy();
	playerToMove.movement.mult(speed * deltaTime);
	//Add our adjusted velocity to our player
	playerToMove.position.add(movement);

	return playerToMove;

}
}