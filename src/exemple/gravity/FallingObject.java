package exemple.gravity;

import java.awt.Color;
import java.awt.Graphics;

import physics.entity.forceable.ForceableEntity;
import physics.exception.PhysicsException;
import physics.math.Vector2D;
import physics.simulator.Simulator;
import physics.simulator.controller.Mouse;

public class FallingObject extends ForceableEntity
{
	private static final int OBJECT_RADIUS_FACTOR = 10;

	private static final Vector2D GRAVITY = new Vector2D(0, 1);
	private static final Vector2D WIND = new Vector2D(0.1, 0);

	private final Simulator simulator;

	public FallingObject(Simulator simulator) throws PhysicsException
	{
		this(simulator, Vector2D.getNull());
	}

	public FallingObject(Simulator simulator, Vector2D position) throws PhysicsException
	{
		this(simulator, position, 1);
	}

	public FallingObject(Simulator simulator, Vector2D position, double mass) throws PhysicsException
	{
		super(position, mass);
		this.simulator = simulator;
	}

	@Override
	public void update()
	{
		super.update();

		int radius = this.getRadius();
		int simulationHeight = this.simulator.getHeight();
		int simulatorWidth = this.simulator.getWidth();

		if((this.getY() + radius) >= simulationHeight)
		{
			this.getPosition().setY(simulationHeight - radius);
			this.invertVerticalVelocity();
		}

		if(this.getX() < 0)
		{
			this.getPosition().setX(0);
			this.invertHorizontalVelocity();
		}

		if((this.getX() + radius) >= simulatorWidth)
		{
			this.getPosition().setX(simulatorWidth - radius);
			this.invertHorizontalVelocity();
		}
	}

	private void invertVerticalVelocity()
	{
		this.getVelocity().mult(new Vector2D(1, -1));
	}

	private void invertHorizontalVelocity()
	{
		this.getVelocity().mult(new Vector2D(-1, 1));
	}

	@Override
	protected void preForceApplied()
	{
		this.addForce(Vector2D.mult(FallingObject.GRAVITY, this.getMass()));

		if(Mouse.isLeftButtonPressed())
		{
			this.addForce(FallingObject.WIND);
		}
	}

	@Override
	protected void postForceApplied()
	{
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval((int) this.getPosition().getX(), (int) this.getPosition().getY(), this.getRadius(), this.getRadius());
	}

	public int getRadius()
	{
		return (int) (this.getMass() * FallingObject.OBJECT_RADIUS_FACTOR);
	}
}
