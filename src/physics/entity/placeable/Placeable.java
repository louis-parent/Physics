package physics.entity.placeable;

import physics.math.Vector2D;

public interface Placeable
{
	public abstract Vector2D getPosition();

	public abstract void setPosition(Vector2D position);

	public abstract double getX();

	public abstract double getY();
}
