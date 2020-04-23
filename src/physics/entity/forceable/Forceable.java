package physics.entity.forceable;

import physics.math.Vector2D;

public interface Forceable
{
	public abstract double getMass();

	public abstract void setMass(double mass);

	public abstract Vector2D getNetForce();

	public abstract void setNetForce(Vector2D netForce);

	public abstract void addForce(Vector2D force);
}
