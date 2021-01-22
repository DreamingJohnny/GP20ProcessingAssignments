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

public class Assignment10Main extends PApplet {

//Var for grid 2D array
Bacteria[][] petriGrid;
int numberOfColumns;
int numberOfRows;

//var for bacteria
float bacteriaDiameter = 10;

//var for spawning
float spawnPercentageBacteria = 15;

public void setup()
{
	

	frameRate(4);

	startPetriGrid();

}

public void draw()
{

  background(0, 0, 0);
  //Calculate next generation

  //update buffer

  //Draw all cells.
	for (int y = 0; y < numberOfRows; y++)
	{
		for (int x = 0; x < numberOfColumns; x++)
		{
			
			if (petriGrid[x][y].isAlive)
			{
				petriGrid[x][y].draw();
			}
		}
	}
}
public class Bacteria
{

PVector bacteriaPosition = new PVector();

float bacteriaDiameter;

boolean isAlive;

int livingBacteriaColor = color(255,255,255);
int deadBacteriaColor = color(0, 0, 0);

	public Bacteria (float positionX, float positionY, float bacteriaSize)
	{
		bacteriaPosition.x = positionX;
		bacteriaPosition.y = positionY;

		bacteriaDiameter = bacteriaSize;

		isAlive = false;
	}

	public void draw()
	{
		fill(livingBacteriaColor);
		ellipse(bacteriaPosition.x, bacteriaPosition.y, bacteriaDiameter, bacteriaDiameter);
	}
}
// boolean shouldBeBorn = true;

public void startPetriGrid()
{
	setupPetriGrid();
	
	fillUpPetriGrid();
}

public void setupPetriGrid()
{
	numberOfColumns = (int)Math.floor(width / bacteriaDiameter);
	numberOfRows = (int)Math.floor(height / bacteriaDiameter);

	petriGrid = new Bacteria[numberOfColumns][numberOfRows];
}

public void fillUpPetriGrid()
{
	for (int y = 0; y < numberOfRows; y++)
	{
		//for each column in each row
		for (int x = 0; x < numberOfColumns; x++) 
		{
			//Create our game objects, multiply by cellSize for correct placement
			petriGrid[x][y] = new Bacteria(x * bacteriaDiameter, y * bacteriaDiameter, bacteriaDiameter);

				//Random if it should be alive
				if (random(0, 100) < spawnPercentageBacteria)
				{
					petriGrid[x][y].isAlive = true;
				}
		}
	}
}
// 	setupRandomBirth();

// 	setRandomToAlive();

// 	/*
// 	This method will first fill upp the petri dish with bacteria, all set to dead.

// 	It will then create a value that is 20% of maximum value,

// 	it will then randomize that many pairs of ints between 0 and 10,
// 	so that we have the positions of all birthing bacteria,
// 	it will then take each pair of ints. Find that position in the grid, and set that bacteria to alive.

// 	When it has done so, it will be done,
// 	*/
// }
// void updatePetriGrid()
// {
	
// 	This function will check each cell in the grid, 
// 	Beginning on zero, zero, it will then climb,
// 	first one number to top, then reset and climb the other one step.

// 	It will compare each cell with each of each of its 8 neighbours.
// 	So it will check same column number one more and one lower.
// 	and each column one more and one lower...

// 	it will record how many are alive,

// 	so we need an int that goes up for each that is alive? Right?

// 	After having checked all eight it makes a desision is that right?
// 	Should be able to make more clever desicions here... right? Does not need to check after number x for instance...
// 	Have a bool that checks and breaks?

// 	Need to be able to handle edge-cases as well

// 	Depending on int that counts alive neighbours we then give it a value...
// 	Could you have two booleans, isAlive, and comingAlive? So checking each...
// 	then going through and switching them?
	
// }
// void showPetriGrid()
// {

// }
  public void settings() { 	size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Assignment10Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
