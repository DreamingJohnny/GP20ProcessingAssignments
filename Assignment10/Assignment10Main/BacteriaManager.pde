void startPetriGrid()
{
	setupPetriGrid();
	
	fillUpPetriGrid();
}

void setupPetriGrid()
{
	numberOfColumns = (int)Math.floor(width / bacteriaDiameter);
	numberOfRows = (int)Math.floor(height / bacteriaDiameter);

	petriGrid = new Bacteria[numberOfColumns][numberOfRows];
}

void fillUpPetriGrid()
{
	for (int y = 0; y < numberOfRows; y++)
	{
		for (int x = 0; x < numberOfColumns; x++) 
		{
			/*
			fills up with bacteria, objects position is vector position proportional to screen.
			percentage chance sets to alive, while standard when born is that they are dead.
			*/
			petriGrid[x][y] = new Bacteria(x * bacteriaDiameter, y * bacteriaDiameter, bacteriaDiameter);

				//Sets some fraction of whole to alive
				if (random(0, 100) < spawnPercentageBacteria)
				{
					petriGrid[x][y].isAlive = true;
				}
		}
	}
}

void updatePetriGrid()
{
	if (x > 0 && y > 0 && x < numberOfColumns && y < numberOfRows)
	{
		//countNeighboursNormal	
	}
	else
	{	
		//Leftmost row
		if (x == 0 && y != 0 && y != numberOfRows)
		{
			if (y == 0)
			{
				
			}

		}
		else if (x == numberOfColumns && y != 0 && y != numberOfRows)
		{
			//Rightmost row
		}
		else if (y == 0 && x != 0 && x != numberOfColumns)
		{
			//Topmost row
		}
		else if (y == numberOfRows && x != 0 && x != numberOfColumns)
		{
			//Bottom row
		}
		else if ()
	}




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