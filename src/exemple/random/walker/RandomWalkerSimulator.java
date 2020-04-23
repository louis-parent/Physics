package exemple.random.walker;

import physics.math.Vector2D;
import physics.simulator.Simulator;

public class RandomWalkerSimulator
{
	public static void simulate()
	{
		new Simulator(new RandomWalker(new Vector2D(250, 250))).start();
	}
}
