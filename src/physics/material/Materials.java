package physics.material;

import java.util.Map;

public enum Materials implements Material
{
	METAL(1), WOOD(1), STONE(1);

	private final static Map<Material, Map<Material, Double>> COEFFICIENTS_FRICTION = Map.of(
			METAL, Map.of(
					METAL, 0.47, 
					WOOD, 0.47, 
					STONE, 1.5), 
			WOOD, Map.of(
					METAL, 0.47, 
					WOOD, 0.47, 
					STONE, 1.5), 
			STONE, Map.of(
					METAL, 0.47, 
					WOOD, 0.47, 
					STONE, 1.5));

	private final double mass;

	private Materials(double mass)
	{
		this.mass = mass;
	}

	@Override
	public double getMass()
	{
		return this.mass;
	}

	@Override
	public double getFrictionCoefficientOn(Material material)
	{
		return Materials.COEFFICIENTS_FRICTION.get(this).get(material);
	}

}
