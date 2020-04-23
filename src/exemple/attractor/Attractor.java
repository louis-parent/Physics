package exemple.attractor;

import physics.entity.materialized.Solid;
import physics.exception.PhysicsException;
import physics.material.Material;
import physics.math.Vector2D;
import physics.shape.Shape;

public class Attractor extends Solid
{
	public Attractor(Vector2D position, Material material, Shape shape) throws PhysicsException
	{
		super(position, material, shape);
	}

	@Override
	protected void preForceApplied()
	{
		
	}

	@Override
	protected void postForceApplied()
	{
		
	}

}
