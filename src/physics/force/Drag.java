package physics.force;

import physics.entity.moveable.Moveable;
import physics.entity.shaped.Shaped;
import physics.material.FluidProperty;
import physics.math.Vector2D;

public class Drag
{
	private static final double CONSTANT_DRAG_MAGNITUDE_FACTOR = 1 / 2;

	public static <E extends Moveable & Shaped> Vector2D applyForIn(E entity, FluidProperty fluid)
	{
		Vector2D velocity = entity.getVelocity();

		Vector2D drag = velocity.clone();
		drag.normalize();
		drag.mult(-1);

		double fluidDensity = fluid.getDensity();
		double squaredVelocity = velocity.getSquaredMagnitude();
		double dragCoefficient = entity.getShape().getDragCoefficient();
		double area = entity.getShape().getArea();

		drag.setMagnitude(Drag.CONSTANT_DRAG_MAGNITUDE_FACTOR * fluidDensity * squaredVelocity * dragCoefficient * area);

		return drag; // Formula : Drag = -1/2 * density * velocity² * DragCoeff * area
	}
}
