package com.withertech.depths.blocks;

import com.withertech.depths.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Iterator;
import java.util.Random;

public class DeepStoneBlock extends NetherrackBlock
{
	public DeepStoneBlock(Settings settings)
	{
		super(settings);
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state)
	{
		boolean bl = false;
		boolean bl2 = false;

		for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1)))
		{
			BlockState blockState = world.getBlockState(blockPos);
			if (blockState.isOf(ModBlocks.HALLOWED_NYLIUM))
			{
				bl2 = true;
			}

			if (blockState.isOf(ModBlocks.CORRUPTED_NYLIUM))
			{
				bl = true;
			}

			if (bl2 && bl)
			{
				break;
			}
		}

		if (bl2 && bl)
		{
			world.setBlockState(pos, random.nextBoolean() ? ModBlocks.HALLOWED_NYLIUM.getDefaultState() : ModBlocks.CORRUPTED_NYLIUM.getDefaultState(), 3);
		}
		else if (bl2)
		{
			world.setBlockState(pos, ModBlocks.HALLOWED_NYLIUM.getDefaultState(), 3);
		}
		else if (bl)
		{
			world.setBlockState(pos, ModBlocks.CORRUPTED_NYLIUM.getDefaultState(), 3);
		}
	}
}
