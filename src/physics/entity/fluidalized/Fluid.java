package physics.entity.fluidalized;

import physics.entity.shaped.ShapedEntity;
import physics.exception.PhysicsException;
import physics.material.FluidProperty;
import physics.math.Vector2D;
import physics.shape.Shape;

public abstract class Fluid extends ShapedEntity implements Fluidalized
{
	private FluidProperty property;

	public Fluid(Vector2D position, FluidProperty property, Shape shape) throws PhysicsException
	{
		this(position, property, shape, Vector2D.getNull());
	}

	public Fluid(Vector2D position, FluidProperty property, Shape shape, Vector2D initialForce) throws PhysicsException
	{
		super(position, 1, shape, initialForce);
		this.property = property;
	}

	@Override
	public FluidProperty getProperty()
	{
		return this.property;
	}

	@Override
	public void setProperty(FluidProperty property)
	{
		this.property = property;
	}
}