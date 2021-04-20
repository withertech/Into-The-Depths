package com.withertech.depths.init;

import com.withertech.depths.worldgen.feature.DeepHugeFungusFeature;
import com.withertech.depths.worldgen.feature.DeepHugeFungusFeatureConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures
{
	public static final Feature<DeepHugeFungusFeatureConfig> DEEP_HUGE_FUNGUS = new DeepHugeFungusFeature(DeepHugeFungusFeatureConfig.CODEC);

	public static final ConfiguredFeature<?, ?> CORRUPTED_FUNGI = DEEP_HUGE_FUNGUS.configure(DeepHugeFungusFeatureConfig.CORRUPTED_FUNGUS_NOT_PLANTED_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8)));
	public static final ConfiguredFeature<DeepHugeFungusFeatureConfig, ?> CORRUPTED_FUNGI_PLANTED = DEEP_HUGE_FUNGUS.configure(DeepHugeFungusFeatureConfig.CORRUPTED_FUNGUS_CONFIG);
	public static final ConfiguredFeature<?, ?> HALLOWED_FUNGI = DEEP_HUGE_FUNGUS.configure(DeepHugeFungusFeatureConfig.HALLOWED_FUNGUS_NOT_PLANTED_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8)));
	public static final ConfiguredFeature<DeepHugeFungusFeatureConfig, ?> HALLOWED_FUNGI_PLANTED = DEEP_HUGE_FUNGUS.configure(DeepHugeFungusFeatureConfig.HALLOWED_FUNGUS_CONFIG);

	public static void register()
	{
		registerFeatures();
		registerFeatureConfigs();
	}

	public static void registerFeatures()
	{
		Registry.register(Registry.FEATURE, "deep_huge_fungus", DEEP_HUGE_FUNGUS);
	}
	public static void registerFeatureConfigs()
	{
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("depths", "corrupted_fungi"), CORRUPTED_FUNGI);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("depths", "corrupted_fungi_planted"), CORRUPTED_FUNGI_PLANTED);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("depths", "hallowed_fungi"), HALLOWED_FUNGI);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("depths", "hallowed_fungi_planted"), HALLOWED_FUNGI_PLANTED);
	}
}
