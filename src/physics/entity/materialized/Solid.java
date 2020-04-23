package physics.entity.materialized;

import physics.entity.shaped.ShapedEntity;
import physics.exception.PhysicsException;
import physics.material.Material;
import physics.math.Vector2D;
import physics.shape.Shape;

public abstract class Solid extends ShapedEntity implements Materialized
{
	private Material material;

	public Solid(Vector2D position, Material material, Shape shape) throws PhysicsException
	{
		this(position, material, shape, Vector2D.getNull());
	}

	public Solid(Vector2D position, Material material, Shape shape, Vector2D initialForce) throws PhysicsException
	{
		super(position, material.getMass(), shape, initialForce);
		this.material = material;
	}

	@Override
	public Material getMaterial()
	{
		return this.material;
	}

	@Override
	public void setMaterial(Material material)
	{
		this.material = material;
	}
}
