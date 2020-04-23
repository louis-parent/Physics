package physics.math;

import java.io.Serializable;
import java.util.Random;

public class Vector2D implements Cloneable, Serializable, Comparable<Vector2D>
{
	private static final long serialVersionUID = -6007477900318466342L;

	private double x;
	private double y;

	public Vector2D()
	{
		this(0, 0);
	}

	public Vector2D(Vector2D other)
	{
		this(other.getX(), other.getY());
	}

	public Vector2D(double radians)
	{
		this(Math.cos(radians), Math.sin(radians));
	}

	public Vector2D(double x, double y)
	{
		this.set(x, y);
	}

	public void set(Vector2D other)
	{
		this.set(other.getX(), other.getY());
	}

	public void set(double x, double y)
	{
		this.setX(x);
		this.setY(y);
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getX()
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public void add(Vector2D other)
	{
		this.x += other.x;
		this.y += other.y;
	}

	public void rem(Vector2D other)
	{
		this.x %= other.x;
		this.y %= other.y;
	}

	public void sub(Vector2D other)
	{
		this.x -= other.x;
		this.y -= other.y;
	}

	public void mult(Vector2D other)
	{
		this.x *= other.x;
		this.y *= other.y;
	}

	public void mult(double factor)
	{
		this.x *= factor;
		this.y *= factor;
	}

	public void div(Vector2D other)
	{
		this.x /= other.x;
		this.y /= other.y;
	}

	public void div(double divider)
	{
		this.x /= divider;
		this.y /= divider;
	}

	public void cross(Vector2D other)
	{
		this.x = (this.x * other.y) - (this.y * other.x);
	}

	public void normalize()
	{
		double magnitude = this.getMagnitude();

		if(magnitude != 0)
		{
			this.div(magnitude);
		}
	}

	public void limit(double maxMagnitude)
	{
		if(this.getMagnitude() > maxMagnitude)
		{
			this.setMagnitude(maxMagnitude);
		}
	}

	public void setMagnitude(double mag)
	{
		this.normalize();
		this.mult(mag);
	}

	public double getMagnitude()
	{
		return Math.sqrt(this.getSquaredMagnitude());
	}

	public double getSquaredMagnitude()
	{
		double xSq = this.x * this.x;
		double ySq = this.y * this.y;
		return xSq + ySq;
	}

	public void rotate(double radians)
	{
		this.setAngle(this.getAngle() + radians);
	}

	public void setAngle(double radians)
	{
		double magnitude = this.getMagnitude();

		this.x = Math.cos(radians);
		this.y = Math.sin(radians);

		this.mult(magnitude);
	}

	public double getAngle()
	{
		return Math.atan2(this.x, this.y);
	}

	public double dot(Vector2D other)
	{
		return (this.x * other.x) + (this.y * other.y);
	}

	public double distanceTo(Vector2D other)
	{
		double xSq = Math.pow(other.x - this.x, 2);
		double ySq = Math.pow(other.y - this.y, 2);
		return Math.sqrt(xSq + ySq);
	}

	public double angleBetween(Vector2D other)
	{
		return Math.atan2(other.y - this.y, other.x - this.x);
	}

	@Override
	public boolean equals(Object other)
	{
		if(other instanceof Vector2D)
		{
			return this.equals((Vector2D) other);
		}
		else
		{
			return false;
		}
	}

	public boolean equals(Vector2D other)
	{
		return (this.x == other.x) && (this.y == other.y);
	}

	@Override
	public Vector2D clone()
	{
		try
		{
			return (Vector2D) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			return Vector2D.getNull();
		}
	}

	@Override
	public int compareTo(Vector2D other)
	{
		return Double.compare(this.getMagnitude(), other.getMagnitude());
	}

	@Override
	public String toString()
	{
		return "(" + this.x + ", " + this.y + ")";
	}

	public static Vector2D add(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.add(right);
		return v;
	}

	public static Vector2D rem(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.rem(right);
		return v;
	}

	public static Vector2D sub(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.sub(right);
		return v;
	}

	public static Vector2D mult(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.mult(right);
		return v;
	}

	public static Vector2D mult(Vector2D left, double factor)
	{
		Vector2D v = new Vector2D(left);
		v.mult(factor);
		return v;
	}

	public static Vector2D div(Vector2D left, double divider)
	{
		Vector2D v = new Vector2D(left);
		v.div(divider);
		return v;
	}

	public static Vector2D div(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.div(right);
		return v;
	}

	public static Vector2D cross(Vector2D left, Vector2D right)
	{
		Vector2D v = new Vector2D(left);
		v.cross(right);
		return v;
	}

	public static Vector2D unitFrom(Vector2D vector)
	{
		Vector2D v = new Vector2D(vector);
		v.normalize();
		return v;
	}

	public static Vector2D getRandom()
	{
		return Vector2D.getRandom(new Random());
	}

	public static Vector2D getRandom(Random rand)
	{
		final double TWO_PI = Math.PI * 2;
		return new Vector2D(rand.nextDouble() * TWO_PI);
	}

	public static Vector2D getNull()
	{
		return new Vector2D();
	}
}
