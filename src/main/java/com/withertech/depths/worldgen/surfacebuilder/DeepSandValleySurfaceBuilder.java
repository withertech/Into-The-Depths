package com.withertech.depths.worldgen.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.withertech.depths.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.AbstractNetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class DeepSandValleySurfaceBuilder extends AbstractNetherSurfaceBuilder
{
	private static final BlockState DEEP_SAND;
	private static final BlockState DEEP_SOIL;
	private static final BlockState GRAVEL;
	private static final ImmutableList<BlockState> SURFACE_STATES;

	public DeepSandValleySurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
		super(codec);
	}

	protected ImmutableList<BlockState> getSurfaceStates() {
		return SURFACE_STATES;
	}

	protected ImmutableList<BlockState> getUnderLavaStates() {
		return SURFACE_STATES;
	}

	protected BlockState getLavaShoreState() {
		return GRAVEL;
	}

	static {
		DEEP_SAND = ModBlocks.DEEP_SAND.getDefaultState();
		DEEP_SOIL = ModBlocks.DEEP_SOIL.getDefaultState();
		GRAVEL = Blocks.GRAVEL.getDefaultState();
		SURFACE_STATES = ImmutableList.of(DEEP_SAND, DEEP_SOIL);
	}
}