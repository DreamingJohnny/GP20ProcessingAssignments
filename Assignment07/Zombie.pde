public class Zombie extends Character
{
	color zombieHue = color(190, 247, 219);
	
	public Zombie ()
	{
		super();

		velocity.x = random(5) - 2.5;
		velocity.y = random(5) - 2.5;

		characterColor = zombieHue;

		isAlive = false;
	}

	public Zombie(PVector startingPosition)
	{
		super();

		position = startingPosition;

		velocity.x = random(5) - 2.5;
		velocity.y = random(5) - 2.5;

		characterColor = zombieHue;

		isAlive = false;
	}
}