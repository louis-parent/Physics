package physics.entity.materialized;

import physics.material.Material;

public interface Materialized
{
	public abstract Material getMaterial();

	public abstract void setMaterial(Material material);
}
