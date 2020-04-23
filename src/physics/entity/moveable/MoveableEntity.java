package physics.entity.moveable;

import physics.entity.placeable.PlaceableEntity;
import physics.math.Vector2D;

public abstract class MoveableEntity extends PlaceableEntity implements Moveable
{
	private Vector2D velocity;
	private Vector2D acceleration;

	public MoveableEntity(Vector2D position)
	{
		this(position, Vector2D.getNull());
	}

	public MoveableEntity(Vector2D position, Vector2D velocity)
	{
		this(position, velocity, Vector2D.getNull());
	}

	public MoveableEntity(Vector2D position, Vector2D velocity, Vector2D acceleration)
	{
		super(position);

		this.setVelocity(velocity);
		this.setAcceleration(acceleration);
	}

	@Override
	public void update()
	{
		this.preUpdate();

		this.applyMovement();

		this.postUpdate();
	}

	private final void applyMovement()
	{
		this.velocity.add(this.acceleration);
		this.getPosition().add(this.velocity);
	}

	protected abstract void preUpdate();

	protected abstract void postUpdate();

	@Override
	public final Vector2D getVelocity()
	{
		return this.velocity;
	}

	@Override
	public final void setVelocity(Vector2D velocity)
	{
		this.velocity = velocity;
	}

	@Override
	public final Vector2D getAcceleration()
	{
		return this.acceleration;
	}

	@Override
	public final void setAcceleration(Vector2D acceleration)
	{
		this.acceleration = acceleration;
	}
}
