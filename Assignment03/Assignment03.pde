//Is this an example of a disgusting "magic number" would Robert say?
float circleDiamater, toDivideBy = 100, circleInerta = 0.004;

PVector circlePositioning = new PVector();
PVector circleGoal = new PVector();
PVector circleVelocity = new PVector();
//Is this an example of a disgusting "magic number" would Robert say?
//PVector circleInerta = new PVector(2,2);
PVector circleFriction = new PVector(0.01,0.01);

void setup() {

	//Design
	size(512, 512);
	background(255,255,255);
	stroke(0);

	//Logical markers
	circleDiamater = width/20;
	/*The assignment says that the circle should "appear" so instead of having it appear at the very same spot everytime
	I try to give myself a few more moving parts to work with by making it random*/
	circlePositioning.x = random(width);
	circlePositioning.y = random(height);

}

void draw() {
	
	background(255,255,255);

	// /*This is to make it so that the circle will halt if moving too slowly
	// Partly to make sure it does not vibrate at the edge for some reason
	// Now that it is circleVelocity compared to circleDrag I'm unsure how that will compare, will it compare the sum to the sum?

	if ((circleVelocity.x + circleVelocity.y <= circleInerta) && (circleVelocity.x + circleVelocity.y >= (circleInerta*=-1)))  {

		circleVelocity.x = 0;
		circleVelocity.y = 0;
	/*Not quite sure if this way, with one if statement and one if else statement is the best way to do this,
	it would mean less code for the program to check I think,
	seeing as it can just check and move on if the "outer" conditions does not apply, rather than needing to go into the loop
	to check both x and y values*/	
	}else if (circlePositioning.x < 1 || circlePositioning.x > width || circlePositioning.y < 1 || circlePositioning.y > height) {
		
		if (circlePositioning.x < 1 || circlePositioning.x > width) {
			
				circleVelocity.x *= -1;

		}else {

				circleVelocity.y *= -1;

		}		
	}
	// 	/*The way I figure it this should gradually slow the circle down.
	// 	And adding it here should make the code read more "effective" seeing as this is only applied when the ball isn't already still*/

	circlePositioning.add(circleVelocity);

	ellipse(circlePositioning.x,circlePositioning.y,circleDiamater,circleDiamater);


	//Add friction, might use a friction PVektor instead of a friction float here, look later.

	//When hitting edge, might become problem with my friction var sending it "backwards"

}
void mouseClicked() {
	//Do I really need to recreate the vector like this?
	circlePositioning = new PVector(mouseX,mouseY);

}
void mouseDragged() {
	//TODO check if an if statement, in draw will help line to not vibrate
	line(circlePositioning.x,circlePositioning.y,mouseX,mouseY);
}
void mouseReleased() { 
	//So, this will save the vector for the position where user lets go of the mouse.
	circleGoal = new PVector(mouseX,mouseY);
	
	circleVelocity = circleGoal.sub(circlePositioning);
	circleVelocity = circleVelocity.div(toDivideBy);

	
}