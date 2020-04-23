package physics.entity.forceable;

import physics.entity.moveable.MoveableEntity;
import physics.exception.PhysicsException;
import physics.math.Vector2D;

public abstract class ForceableEntity extends MoveableEntity implements Forceable
{
	private double mass;

	private Vector2D lastForce;
	private Vector2D netForce;

	public ForceableEntity(double mass) throws PhysicsException
	{
		this(Vector2D.getNull(), mass);
	}

	public ForceableEntity(Vector2D position, double mass) throws PhysicsException
	{
		this(position, mass, Vector2D.getNull());
	}

	public ForceableEntity(Vector2D position, double mass, Vector2D force) throws PhysicsException
	{
		super(position);

		if(mass <= 0)
		{
			throw new PhysicsException("Mass cannot be null");
		}

		this.setMass(mass);
		this.setNetForce(force);
	}

	@Override
	protected void preUpdate()
	{
		this.preForceApplied();

		this.applyForce();

		this.postForceApplied();
	}

	private final void applyForce()
	{
		this.setAcceleration(Vector2D.div(this.netForce, this.mass)); // Newton's second law : F = m * A
	}

	@Override
	protected void postUpdate()
	{
		this.lastForce = this.netForce;
		this.netForce = Vector2D.getNull();
	}

	protected abstract void preForceApplied();

	protected abstract void postForceApplied();

	@Override
	public final double getMass()
	{
		return this.mass;
	}

	@Override
	public final void setMass(double mass)
	{
		this.mass = mass;
	}

	public Vector2D getLastForce()
	{
		return this.lastForce;
	}

	public void setLastForce(Vector2D lastForce)
	{
		this.lastForce = lastForce;
	}

	@Override
	public final Vector2D getNetForce()
	{
		return this.netForce;
	}

	@Override
	public final void setNetForce(Vector2D netForce)
	{
		this.netForce = netForce;
	}

	@Override
	public final void addForce(Vector2D force)
	{
		this.netForce.add(force);
	}
}
