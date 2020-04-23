package physics.force;

import physics.entity.forceable.Forceable;
import physics.entity.placeable.Placeable;
import physics.math.Vector2D;

public class Gravitation
{
	public static double UNIVERSAL_GRAVITATION = 6.6743015e-11;

	public static <E extends Forceable & Placeable> Vector2D applyGravitionBetween(E attractor, E mover)
	{
		return Gravitation.applyGravitionBetween(attractor, mover, Gravitation.UNIVERSAL_GRAVITATION);
	}

	public static <E extends Forceable & Placeable> Vector2D applyGravitionBetween(E attractor, E mover, double gravitationConstant)
	{
		Vector2D direction = Vector2D.sub(attractor.getPosition(), mover.getPosition());
		double distanceSquared = direction.getSquaredMagnitude();
		
		double gravitationStrength = ((attractor.getMass() * mover.getMass()) / distanceSquared) * gravitationConstant;

		Vector2D gravitation = direction.clone();
		gravitation.setMagnitude(gravitationStrength);
		
		return gravitation; // Formula : Gravitation = ((mass1 * mass2) / distance²) * G * direction unit vector
	}
}
