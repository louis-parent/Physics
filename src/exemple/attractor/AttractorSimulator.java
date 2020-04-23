package exemple.attractor;

import java.awt.Color;

import physics.material.Materials;
import physics.math.Vector2D;
import physics.shape.Circle;
import physics.simulator.Simulator;

public class AttractorSimulator
{
	public static void simulate()
	{
		try
		{
			Simulator simulator = new Simulator();
			int width = simulator.getWidth();
			int height = simulator.getHeight();

			Attractor attractor = new Attractor(new Vector2D(width/2, height/2), Materials.METAL, new Circle(Math.sqrt(Materials.METAL.getMass()) * 10, Color.BLACK));
			simulator.addEntity(attractor);
			
			simulator.addEntity(new Mover(new Vector2D(width/4, height/4), Materials.STONE, new Circle(Math.sqrt(Materials.STONE.getMass()) * 10, Color.RED), attractor));

			simulator.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
