//Var for grid 2D array
Bacteria[][] petriGrid;
int numberOfColumns;
int numberOfRows;

//var for bacteria
float bacteriaDiameter = 10;

//var for spawning
float spawnPercentageBacteria = 15;

void setup()
{
	size(512, 512);

	frameRate(4);

	startPetriGrid();
}

void draw()
{

	


	
	//checks for next generation
	for (int i = 0; i < numberOfRows; i++)
	{
		for (int j = 0; j < numberOfColumns; j++)
		{
			if(petriGrid[i][j])
			{
				petriGrid[i][j]
			}


			if(petriGrid[i][j].isAlive == false)
			{

			}
		}	
	}
/*
Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by overpopulation.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
*/

	//switches on next generation

	//design
	background(0, 0, 0);
	//Calculate next generation

	//update buffer


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
