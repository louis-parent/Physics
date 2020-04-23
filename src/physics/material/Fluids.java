package physics.material;

public enum Fluids implements FluidProperty
{
	AIR(1.2041), WATER(1);

	private final double density;

	private Fluids(double density)
	{
		this.density = density;
	}

	@Override
	public double getDensity()
	{
		return this.density;
	}
}
