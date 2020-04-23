package physics.entity.shaped;

import java.awt.Graphics;

import physics.entity.forceable.ForceableEntity;
import physics.exception.PhysicsException;
import physics.math.Vector2D;
import physics.shape.Shape;

public abstract class ShapedEntity extends ForceableEntity implements Shaped
{
	private Shape shape;

	public ShapedEntity(Vector2D position, double mass, Shape shape) throws PhysicsException
	{
		this(position, mass, shape, Vector2D.getNull());
	}

	public ShapedEntity(Vector2D position, double mass, Shape shape, Vector2D initialForce) throws PhysicsException
	{
		super(position, mass, initialForce);
		this.shape = shape;
	}

	@Override
	public Shape getShape()
	{
		return this.shape;
	}

	@Override
	public void setShape(Shape shape)
	{
		this.shape = shape;
	}

	@Override
	public void paint(Graphics g)
	{
		this.shape.paintWithCenterAt(g, this.getX(), this.getY());
	}
}
