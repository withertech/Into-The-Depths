package com.withertech.depths.blocks;

import com.withertech.depths.worldgen.feature.DeepHugeFungusFeatureConfig;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;
import java.util.function.Supplier;

public class DeepFungusBlock extends PlantBlock implements Fertilizable
{
	protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
	private final Supplier<ConfiguredFeature<DeepHugeFungusFeatureConfig, ?>> field_22135;

	public DeepFungusBlock(AbstractBlock.Settings settings, Supplier<ConfiguredFeature<DeepHugeFungusFeatureConfig, ?>> supplier) {
		super(settings);
		this.field_22135 = supplier;
	}

	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) || super.canPlantOnTop(floor, world, pos);
	}

	public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
		Block block = ((DeepHugeFungusFeatureConfig)((ConfiguredFeature)this.field_22135.get()).config).validBaseBlock.getBlock();
		Block block2 = world.getBlockState(pos.down()).getBlock();
		return block2 == block;
	}

	public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
		return (double)random.nextFloat() < 0.4D;
	}

	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		((ConfiguredFeature)this.field_22135.get()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos);
	}
}
