
/*
TODO: I want to look into the zombies movement again, could it be possble to have their movement be the same as before, only lessened?
TODO: Make humanity stuff smaller font and print time
TODO: Fix color on font, slimy green on game over?
TODO: Create effect that background fades on game over,
TODO: Set better looking background in game,
TODO: Later, learn to print time in a more elegant way
TODO: Later I need to check how millis works,because it is time since game began right? So we need to reset it first time draw starts...
*/

Character[] characters;

int amountOfCharacters = 100;
int amountOfSurvivors;

//var for gamestate
boolean isGameOver;

//var for menus
PFont gameText;
color textColor;
String gameOverMessage = "GAME OVER";
//Must be a more elegant way to do this, will fix that later.
String humanitySurvived = "Humanity survived for: ";
String sek = "seconds";
String timeSessionLasted;
String gameOverStats;

//var for time
float deltaTime;
long passedTime;
long currentTime; 

void setup()
{
	//Set our window size
	size(880,720);
	background(255, 255, 255);

	//Setup for UI
	gameText = createFont("Arial", 36);
	textColor = color(7, 167, 23);

	//Fills array 1 zombie, rest humans
	characters = new Character[amountOfCharacters];
	spawnCharacters();
	amountOfSurvivors = amountOfCharacters;

}

void draw()
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

		gameOverStats = new String (humanitySurvived + timeSessionLasted + sek);
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
void survivorCheck()
{
	if (amountOfSurvivors <= 1)
	{
		isGameOver = true;	
	}
}