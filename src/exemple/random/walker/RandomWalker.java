package exemple.random.walker;

import java.awt.Graphics;

import physics.entity.moveable.MoveableEntity;
import physics.math.Vector2D;

public class RandomWalker extends MoveableEntity
{
	private static final int WALKER_RADIUS = 10;

	public RandomWalker(Vector2D defaultPosition)
	{
		super(defaultPosition);
	}

	@Override
	protected void preUpdate()
	{
		this.setAcceleration(Vector2D.getRandom());
	}

	@Override
	protected void postUpdate()
	{
		this.getVelocity().limit(2);
	}

	@Override
	public void paint(Graphics g)
	{
		g.fillOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), RandomWalker.WALKER_RADIUS, RandomWalker.WALKER_RADIUS);
	}
}
