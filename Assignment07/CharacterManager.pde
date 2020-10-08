boolean isTouching = true;

void spawnCharacters()
{
	characters[0] = new Zombie();

	for (int i = 1; i < characters.length; i++)
	{
		characters[i] = new Human();	
	}
}

void characterHandler()
{

	for (int i = 0; i < characters.length; i++)
	{
		characters[i].move();
		characters[i].show();
		characters[i].edgeCheck();
	}
}

void plagueCheck()
{
	plagueSpreading();
}

void plagueSpreading()
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

boolean hitDetection(Character carrier, Character victim)
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