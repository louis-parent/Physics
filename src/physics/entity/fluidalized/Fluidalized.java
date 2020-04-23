package physics.entity.fluidalized;

import physics.material.FluidProperty;

public interface Fluidalized
{
	public abstract FluidProperty getProperty();

	public abstract void setProperty(FluidProperty property);
}
