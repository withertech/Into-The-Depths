package com.withertech.depths.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.withertech.depths.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;

public class DeepHugeFungusFeatureConfig implements FeatureConfig
{
	public static final Codec<DeepHugeFungusFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
			BlockState.CODEC.fieldOf("valid_base_block").forGetter((hugeFungusFeatureConfig) -> hugeFungusFeatureConfig.validBaseBlock),
			BlockState.CODEC.fieldOf("stem_state").forGetter((hugeFungusFeatureConfig) -> hugeFungusFeatureConfig.stemState),
			BlockState.CODEC.fieldOf("hat_state").forGetter((hugeFungusFeatureConfig) -> hugeFungusFeatureConfig.hatState),
			BlockState.CODEC.fieldOf("decor_state").forGetter((hugeFungusFeatureConfig) -> hugeFungusFeatureConfig.decorationState),
			Codec.BOOL.fieldOf("planted").orElse(false).forGetter((hugeFungusFeatureConfig) -> hugeFungusFeatureConfig.planted)
	).apply(instance, (DeepHugeFungusFeatureConfig::new)));
	public static final DeepHugeFungusFeatureConfig CORRUPTED_FUNGUS_CONFIG;
	public static final DeepHugeFungusFeatureConfig CORRUPTED_FUNGUS_NOT_PLANTED_CONFIG;
	public static final DeepHugeFungusFeatureConfig HALLOWED_FUNGUS_CONFIG;
	public static final DeepHugeFungusFeatureConfig HALLOWED_FUNGUS_NOT_PLANTED_CONFIG;
	public final BlockState validBaseBlock;
	public final BlockState stemState;
	public final BlockState hatState;
	public final BlockState decorationState;
	public final boolean planted;

	public DeepHugeFungusFeatureConfig(BlockState validBaseBlock, BlockState stemState, BlockState hatState, BlockState decorationState, boolean planted)
	{
		this.validBaseBlock = validBaseBlock;
		this.stemState = stemState;
		this.hatState = hatState;
		this.decorationState = decorationState;
		this.planted = planted;
	}

	static
	{
		CORRUPTED_FUNGUS_CONFIG = new DeepHugeFungusFeatureConfig(ModBlocks.CORRUPTED_NYLIUM.getDefaultState(), ModBlocks.CORRUPTED_STEM.getDefaultState(), ModBlocks.CORRUPTED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
		CORRUPTED_FUNGUS_NOT_PLANTED_CONFIG = new DeepHugeFungusFeatureConfig(CORRUPTED_FUNGUS_CONFIG.validBaseBlock, CORRUPTED_FUNGUS_CONFIG.stemState, CORRUPTED_FUNGUS_CONFIG.hatState, CORRUPTED_FUNGUS_CONFIG.decorationState, false);
		HALLOWED_FUNGUS_CONFIG = new DeepHugeFungusFeatureConfig(ModBlocks.HALLOWED_NYLIUM.getDefaultState(), ModBlocks.HALLOWED_STEM.getDefaultState(), ModBlocks.HALLOWED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
		HALLOWED_FUNGUS_NOT_PLANTED_CONFIG = new DeepHugeFungusFeatureConfig(HALLOWED_FUNGUS_CONFIG.validBaseBlock, HALLOWED_FUNGUS_CONFIG.stemState, HALLOWED_FUNGUS_CONFIG.hatState, HALLOWED_FUNGUS_CONFIG.decorationState, false);
	}
}