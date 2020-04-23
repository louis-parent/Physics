package exemple.gravity;

import physics.math.Vector2D;
import physics.simulator.Simulator;

public class FallingObjectSimulator
{
	public static void simulate()
	{
		try
		{
			Simulator simulator = new Simulator();
			int width = simulator.getWidth();
			int height = simulator.getHeight();

			simulator.addEntity(new FallingObject(simulator, new Vector2D(width / 4, (2 * height) / 3), 1));
			simulator.addEntity(new FallingObject(simulator, new Vector2D((3 * width) / 4, (2 * height) / 3), 3));

			simulator.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
