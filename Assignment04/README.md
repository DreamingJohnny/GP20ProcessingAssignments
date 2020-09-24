# 04 - Input and Motion

[<img src="https://media.giphy.com/media/5FTe65sKNVfEc/giphy.gif" alt="04 - Input and Motion" width="100%">](https://www.topgear.com/)

> _"How hard can it be?"_ **- Jeremy Clarkson**

We actually started with inputs in last lecture. We looked at mouse input and learned to use `mouseX`, `mouseY` and functions like `mousePressed()`. In this lesson we will look at keyboard input and make more interesting motion, like simulated physics.

## Key Input
We have two functions built into processing that will be called automatically when a key is pressed/released.
The `keyPressed` function will run the frame a key is pressed and will look for what keys are pressed down. There is a corresponding `keyReleased` function.
We can then check the variable `key` for a certain button that we use to flip our bools on or off.


```java
boolean moveLeft;
boolean moveRight;

//Key pressed, set our variables to true
void keyPressed()
{
	if (keyCode == LEFT || key == 'a')
		moveLeft = true;
	else if (keyCode == RIGHT || key == 'd')
		moveRight = true;
 }

//When a key is released, we will set our variable to false
void keyReleased()
{
	if (keyCode == LEFT || key == 'a')
		moveLeft = false;
	else if (keyCode == RIGHT || key == 'd')
		moveRight = false;
}
```

Using this we can make our "player" move.

```java
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
```

> We can check for player input directly in the draw function since there is also a build in bool (boolean) called `keyPressed` but separating the code makes it more manageable.

#### Working with multiple files
We can put the `keyPressed()` and `keyReleased()` function in a new `.pde` file in the same folder, and perhaps call it `input.pde`, and it will work just fine. This will keep the draw function clean and the files shorter.

## Motion
We now have motion based on our input. We can look at it as when we press the key we get a velocity of 5 pixels / frame. Acceleration on the other hand is the change in velocity over time.

#### Velocity
```java
int posY; // y position of ball

int v = 1; // constant velocity

//In the update loop:  
posY = posY + v;
```

#### Acceleration
```java
int a = 1; // constant acceleration

// update loop same as before, but:

v = v + a; // v increases by acceleration
```

> Velocity and gravity is basically the same thing, we have a constant acceleration downwards. That's a gravity simulation.


### Frame delta time / time per frame
Using the unit of pixels / frame is quite bad, basically the game will run faster with higher framerate. It's therefore a good idea to change our code to use pixels / second. This can be done using deltaTime. It's basically the time it took to get from one frame to anther. So if it took a long time we should move our character longer then if it was a shorter time.

Define a time count.
Measure time at start of frame and end of frame.
After measuring time at start of frame, calculate fraction for movement (`deltaTime`). Convert to seconds!

```java
float deltaTime;

void draw(){
  long currentTime = millis();
	// we want this is seconds, fraction of a second
  deltaTime = (currentTime - time) * 0.001f;

  // do your drawing stuff...

	//Update time in preparation for next frame.
  time = currentTime;
}
```

You need to apply this to both position `pos` updates and velocity `v` updates. Since deltaTime is likely to be a small number you will most likely have to increase your movement speed since it's a different scale.

Pseudo code:
```java
pos = pos + v * deltaTime
v = v + a * deltaTime
```


## Assignments
- Using the input example from the lesson. Make it so a circle/character/player can move left-right-up-down.

- Normalize the input so the player isn't faster when moving diagonal.

- Create input that gives the circle/character acceleration when it moves.

- Give the player a max speed so its easier to control.

- Make the player deaccelerate down to a standstill when no key is pressed.

- Use `deltaTime` to control movement every update. The easy way of applying this is doing the x and y axis separated since working with vectors in processing is a bit tricky.
You can test if this is working by changing the `framerate()` of your program, 20 / 60 /120 is good testing values.

- Adjust the acceleration/deacceleration values until it feels good.


## Extracurricular
- Change the program to make the character screen wrap. If it goes out from the left of the screen when it enters on the right and vice versa. The character should not be able to leave the screen up or down.

- Make it so that when the character is half outside the window he is peeking in on the other side.

- Use the PVector class to handle position and velocity.

- Pressing `g` on the keyboard should toggle gravity on or off. With gravity on the circle/character should fall down and bounce on the bottom of the screen.


## References
- [Processing bounce](https://www.processing.org/examples/bounce.html)
- [Bounce Solution](https://processing.org/examples/bouncingball.html)


## Review and Evaluation
[Lesson Evaluation](https://docs.google.com/forms/d/e/1FAIpQLSfrNqoY_tShBR73uU3bTePYADYK6cdFG7NKa3YaWtzNv6wDQQ/viewform?usp=pp_url&entry.998900666=04+-+Input+and+Movement)
