package physics.entity.moveable;

import physics.math.Vector2D;

public interface Moveable
{
	public abstract Vector2D getVelocity();

	public abstract void setVelocity(Vector2D velocity);

	public abstract Vector2D getAcceleration();

	public abstract void setAcceleration(Vector2D acceleration);
}
