import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Assignment07 extends PApplet {

//Create a new class called character and make a character manager. (the character should initially behave like the ball class from previous lecture).

//Create a Human class that extends from the character class.

//Create a Zombie class that inherits from character, but they are slower (and green).

//Let the character manager spawn 99 humans and 1 Zombie.

//Let the manager check if a Zombie "collies" with a human. If they collide, replace the Human with a new Zombie.
//(there are several reasons for not doing it this way, more on that later).

//When a human (or zombie) gets to the edge, they do not bounce like the balls, instead they screen warp to the other side.

//When all humans are (un)dead print GAME OVER on the screen and how long it took before all died (time since the program started).


/*
TODO: I want to look into the zombies movement again, could it be possble to have their movement be the same as before, only lessened?
*/

Character[] characters;

int amountOfCharacters = 100;
int amountOfSurvivors;

//var for gamestate
boolean isGameOver;

//var for menus
PFont gameText;
int textColor;
String gameOverMessage = "GAME OVER";
//Must be a more elegant way to do this, will fix that later.
String humanitySurvived = "Humanity survived for: ";
String sek = "seconds";
String timeSessionLasted;

//var for time
float deltaTime;
long passedTime;
long currentTime; 

public void setup()
{
	//Set our window size
	
	background(255, 255, 255);

	//Setup for UI
	gameText = createFont("Arial", 36);
	textColor = color(7, 167, 23);

	//Fills array 1 zombie, rest humans
	characters = new Character[amountOfCharacters];
	spawnCharacters();
	amountOfSurvivors = amountOfCharacters;

}

public void draw()
{
	background(255, 255, 255);

	//These lines creates a value in time that allows me to compare and compensate for possible lag.
	currentTime = millis();
	deltaTime = (currentTime - passedTime);
	deltaTime *= 0.001f;

	if(isGameOver)
	{
		textFont(gameText, 46);
		fill(textColor);
		textAlign(CENTER);

		text(gameOverMessage, width / 2, height / 3);
		textAlign(CENTER);
		/*
		TODO: Make humanity stuff smaller font and print time
		TODO: Fix color on font, slimy green on game over?
		TODO: Create effect that background fades on game over,
		TODO: Set better looking background in game,
		TODO: Later, learn to print time in a more elegant way
		TODO: Later I need to check how millis works,
		because it is time since game began right?
		So we need to reset it first time draw starts...
		*/
		String gameOverStats = new String (humanitySurvived + timeSessionLasted + sek);
		text(gameOverStats, width / 2, height / 2);
	}
	else
	{
		characterHandler();

		plagueCheck();

		survivorCheck();

		timeSessionLasted = str(millis() / 60);
	}

	passedTime = currentTime;
}
public void survivorCheck()
{
	if (amountOfSurvivors <= 1)
	{
		isGameOver = true;	
	}
}
public class Character
{
	PVector position = new PVector();
	PVector velocity = new PVector();

	int characterColor;

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

	public void move()
	{
		position.add(velocity);
	}

	public void show()
	{
		fill(characterColor);
		ellipse(position.x, position.y, radius * 2, radius * 2);
	}

	public void edgeCheck()
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
boolean isTouching = true;

public void spawnCharacters()
{
	characters[0] = new Zombie();

	for (int i = 1; i < characters.length; i++)
	{
		characters[i] = new Human();	
	}
}

public void characterHandler()
{

	for (int i = 0; i < characters.length; i++)
	{
		characters[i].move();
		characters[i].show();
		characters[i].edgeCheck();
	}
}

public void plagueCheck()
{
	plagueSpreading();
}

public void plagueSpreading()
{
	for (int i = 0; i < characters.length; i++)
	{
		if (characters[i].isAlive == false)
		{
			for (int j = 0; j < characters.length; j++)
			{
				if(characters[j].isAlive == true)
				{
					isTouching = hitDetection(characters[i],characters[j]);

					if(isTouching)
					{
						characters[j] = new Zombie(characters[j].position);

						//characters[i].zombieChangesDirection();

						amountOfSurvivors--;
					}
				}
			}
		}
	}
}

public boolean hitDetection(Character carrier, Character victim)
{
	float maxDistance = carrier.radius + victim.radius;

	if(abs(carrier.position.x - victim.position.x) > maxDistance || abs(carrier.position.y - victim.position.y) > maxDistance)
	{
		return false;
	}
	else if(dist(carrier.position.x, carrier.position.y, victim.position.x, victim.position.y) > maxDistance)
	{
		return false;
	}
	else
	{
		return true;
	}
}
// void zombieChangesDirection()
// 	{
// 		velocity.x = random(5) - 2.5;
// 		velocity.y = random(5) - 2.5;
// 	}
public class Human extends Character
{
	int humanColor = color(247, 190, 200);

	public Human()
	{
		super();

		characterColor = humanColor;

		isAlive = true;
	}
}
public class Zombie extends Character
{
	int zombieHue = color(190, 247, 219);
	
	public Zombie ()
	{
		super();

		velocity.x = random(5) - 2.5f;
		velocity.y = random(5) - 2.5f;

		characterColor = zombieHue;

		isAlive = false;
	}

	public Zombie(PVector startingPosition)
	{
		super();

		position = startingPosition;

		velocity.x = random(5) - 2.5f;
		velocity.y = random(5) - 2.5f;

		characterColor = zombieHue;

		isAlive = false;
	}
}
  public void settings() { 	size(880,720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment07" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
