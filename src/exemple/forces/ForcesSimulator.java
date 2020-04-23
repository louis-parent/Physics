package exemple.forces;

import java.awt.Color;

import physics.material.Materials;
import physics.math.Vector2D;
import physics.shape.Circle;
import physics.simulator.Simulator;

public class ForcesSimulator
{
	public static void simulate()
	{
		try
		{
			Simulator simulator = new Simulator();
			int width = simulator.getWidth();
			int height = simulator.getHeight();

			simulator.addEntity(new ForcesEntity(simulator, new Vector2D(width / 4, (2 * height) / 3), Materials.STONE, new Circle(10, Color.BLACK), new Vector2D(2, 0)));

			simulator.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
