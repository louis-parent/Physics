package exemple.attractor;

import physics.entity.materialized.Solid;
import physics.exception.PhysicsException;
import physics.force.Gravitation;
import physics.material.Material;
import physics.math.Vector2D;
import physics.shape.Shape;

public class Mover extends Solid
{
	private Solid attractor;
	
	public Mover(Vector2D position, Material material, Shape shape, Solid attractor) throws PhysicsException
	{
		super(position, material, shape);
		
		this.attractor = attractor;
	}

	@Override
	protected void preForceApplied()
	{		
		this.addForce(Gravitation.applyGravitionBetween(this.attractor, this, 500));
	}

	@Override
	protected void postForceApplied()
	{
		
	}
}
