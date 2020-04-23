package physics.material;

public interface Material
{
	public abstract double getMass();

	public abstract double getFrictionCoefficientOn(Material material);
}
