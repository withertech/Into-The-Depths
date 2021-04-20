package com.withertech.depths.init;

import com.withertech.depths.worldgen.surfacebuilder.DeepSandValleySurfaceBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModSurfaceBuilders
{
	public static final SurfaceBuilder<TernarySurfaceConfig> DEEP_SAND_VALLEY = new DeepSandValleySurfaceBuilder(TernarySurfaceConfig.CODEC);

	public static void register()
	{
		Registry.register(Registry.SURFACE_BUILDER, new Identifier("depths", "deep_sand_valley"), DEEP_SAND_VALLEY);
	}
}
