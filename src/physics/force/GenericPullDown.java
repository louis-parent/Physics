package physics.force;

import physics.entity.forceable.Forceable;
import physics.math.Vector2D;

public class GenericPullDown
{
	private static final double UNIT_FORCE = 1;

	public static Vector2D applyForEntity(Forceable entity)
	{
		return GenericPullDown.applyForEntity(entity, GenericPullDown.UNIT_FORCE);
	}
	
	public static Vector2D applyForEntity(Forceable entity, double force)
	{
		return new Vector2D(0, force * entity.getMass());
	}
}
