package physics.shape;

import java.awt.Color;
import java.awt.Graphics;

public interface Shape
{
	public abstract double getWidth();

	public abstract double getHeight();

	public abstract double getArea();

	public abstract Color getColor();

	public abstract double getDragCoefficient();

	public abstract void paintWithCenterAt(Graphics g, double x, double y);

}
