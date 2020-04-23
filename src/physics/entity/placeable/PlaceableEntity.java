package physics.entity.placeable;

import physics.entity.Entity;
import physics.math.Vector2D;

public abstract class PlaceableEntity implements Entity, Placeable
{
	private Vector2D position;

	public PlaceableEntity()
	{
		this(Vector2D.getNull());
	}

	public PlaceableEntity(Vector2D position)
	{
		this.setPosition(position);
	}

	@Override
	public final Vector2D getPosition()
	{
		return this.position;
	}

	@Override
	public final void setPosition(Vector2D position)
	{
		this.position = position;
	}

	@Override
	public final double getX()
	{
		return this.getPosition().getX();
	}

	@Override
	public final double getY()
	{
		return this.getPosition().getY();
	}
}
