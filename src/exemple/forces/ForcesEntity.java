package exemple.forces;

import physics.entity.materialized.Solid;
import physics.exception.PhysicsException;
import physics.force.Drag;
import physics.force.Friction;
import physics.force.GenericPullDown;
import physics.material.Fluids;
import physics.material.Material;
import physics.material.Materials;
import physics.math.Vector2D;
import physics.shape.Shape;
import physics.simulator.Simulator;

public class ForcesEntity extends Solid
{
	private Simulator simulator;

	public ForcesEntity(Simulator simulator, Vector2D position, Material material, Shape shape) throws PhysicsException
	{
		this(simulator, position, material, shape, Vector2D.getNull());
	}

	public ForcesEntity(Simulator simulator, Vector2D position, Material material, Shape shape, Vector2D initialForce) throws PhysicsException
	{
		super(position, material, shape, initialForce);
		this.simulator = simulator;
	}

	@Override
	protected void preForceApplied()
	{
		this.addForce(GenericPullDown.applyForEntity(this));

		if(this.isOnGround())
		{
			this.addForce(Friction.applyForOn(this, Materials.WOOD));
		}
		else
		{
			this.addForce(Drag.applyForIn(this, Fluids.AIR));
		}
	}

	@Override
	protected void postForceApplied()
	{
		if(this.isVerticalyOutOfBox())
		{
			this.getVelocity().mult(new Vector2D(1, -1));
			this.getPosition().setY(this.simulator.getHeight() - (this.getShape().getHeight() / 2));
		}

		if(this.isHorizontalyOutOfBox())
		{
			this.getVelocity().mult(new Vector2D(-1, 1));
		}
	}

	private boolean isOnGround()
	{
		return (this.simulator.getHeight() - (this.getY() + (this.getShape().getHeight() / 2))) < 1;
	}

	private boolean isVerticalyOutOfBox()
	{
		return (this.getY() + (this.getShape().getHeight() / 2)) >= this.simulator.getHeight();
	}

	private boolean isHorizontalyOutOfBox()
	{
		double halfWidth = this.getShape().getWidth() / 2;
		return ((this.getX() - halfWidth) <= 0) || ((this.getX() + halfWidth) >= this.simulator.getWidth());
	}
}
