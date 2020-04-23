package physics.entity.shaped;

import physics.shape.Shape;

public interface Shaped
{
	public abstract Shape getShape();

	public abstract void setShape(Shape shape);
}
