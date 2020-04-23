package physics.force;

import physics.entity.forceable.Forceable;
import physics.entity.materialized.Materialized;
import physics.entity.moveable.Moveable;
import physics.material.Material;
import physics.math.Vector2D;

public class Friction
{
	public static <E extends Moveable & Forceable & Materialized> Vector2D applyForOn(E entity, Material material)
	{
		Vector2D friction = entity.getVelocity().clone();
		friction.normalize();
		friction.mult(-1);
		friction.setMagnitude(entity.getMaterial().getFrictionCoefficientOn(material) * entity.getMass());

		return friction; // Formula : Friction = -1 * CoeffFriction * Mass * UnitVelocity
	}
}
