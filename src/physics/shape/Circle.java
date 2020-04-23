package physics.shape;

import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Shape
{
	private double diameter;
	private double radius;

	private Color color;

	public Circle(double diameter, Color color)
	{
		this.diameter = diameter;
		this.radius = diameter / 2;

		this.color = color;
	}

	@Override
	public double getWidth()
	{
		return this.diameter;
	}

	@Override
	public double getHeight()
	{
		return this.diameter;
	}

	@Override
	public double getArea()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public void paintWithCenterAt(Graphics g, double x, double y)
	{
		g.setColor(this.color);
		g.fillOval((int) (x - this.radius), (int) (y - this.radius), (int) this.diameter, (int) this.diameter);
	}

	@Override
	public Color getColor()
	{
		return this.color;
	}

	@Override
	public double getDragCoefficient()
	{
		return 0.47;
	}
}
