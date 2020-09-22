boolean moveLeft,moveRight,moveUp,moveDown;

//Key pressed, set our variables to true
void keyPressed(){

  	if (keyCode == LEFT || key == 'a'){
    	moveLeft = true;
    	circleMovement.x *= (circleAcceleration*deltaTime);
    	circleMovement.x += circleSpeed*-1;

	}
  	else if (keyCode == RIGHT || key == 'd'){
    	moveRight = true;
    	circleMovement.x *= (circleAcceleration*deltaTime);
    	circleMovement.x += circleSpeed;
	}
	if (keyCode == UP || key == 'w'){
    	moveUp = true;
	}
  	else if (keyCode == DOWN || key == 's'){
    	moveDown = true;
	}

 }

//When a key is released, we will set our variable to false
void keyReleased(){

  	if (keyCode == LEFT || key == 'a'){
    	moveLeft = false;
	}
  	else if (keyCode == RIGHT || key == 'd'){
    	moveRight = false;
	}
	if (keyCode == UP || key == 'w'){
    	moveUp = false;
	}
 	else if (keyCode == DOWN || key == 's'){
    	moveDown = false;
	}

}

void movement(){

	circlePosition.add(circleMovement);

 	circleMovement.x *= circleFriction;


	// if (moveLeft == true && moveRight == false) {
	// 	circlePosition.add(circleMovement);
	//   	}
 //  	if (moveRight == true && moveLeft == false) {
 //    	circlePosition.add(circleMovement);
 //  	}
 //  	if (moveUp == true && moveDown == false) {
 //    	circlePosition.y -= circleSpeed;
 //  	}
 //    if (moveDown == true && moveUp == false) {
 //    	circlePosition.y += circleSpeed;

}