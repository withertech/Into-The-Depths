package com.withertech.depths.init;

import com.withertech.depths.blocks.DeepFungusBlock;
import com.withertech.depths.blocks.DeepNyliumBlock;
import com.withertech.depths.blocks.DeepStoneBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class ModBlocks
{
	public static final Block DEEP_SOIL = new Block(FabricBlockSettings.of(Material.SOIL).strength(0.5F));
	public static final Block DEEP_SAND = new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5F));

	public static final Block CORRUPTED_WART_BLOCK = new Block(AbstractBlock.Settings.of(Material.SOLID_ORGANIC, MaterialColor.PURPLE).strength(1.0F).sounds(BlockSoundGroup.WART_BLOCK));
	public static final Block HALLOWED_WART_BLOCK = new Block(AbstractBlock.Settings.of(Material.SOLID_ORGANIC, MaterialColor.GOLD).strength(1.0F).sounds(BlockSoundGroup.WART_BLOCK));

	public static final DeepStoneBlock DEEP_STONE = new DeepStoneBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(0.4F));
	public static final DeepNyliumBlock CORRUPTED_NYLIUM = new DeepNyliumBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.PURPLE).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());
	public static final DeepNyliumBlock HALLOWED_NYLIUM = new DeepNyliumBlock(FabricBlockSettings.of(Material.STONE, MaterialColor.GOLD).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());

	public static final DeepFungusBlock CORRUPTED_FUNGUS = new DeepFungusBlock(AbstractBlock.Settings.of(Material.PLANT, MaterialColor.PURPLE).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS), () -> ModFeatures.CORRUPTED_FUNGI_PLANTED);
	public static final DeepFungusBlock HALLOWED_FUNGUS = new DeepFungusBlock(AbstractBlock.Settings.of(Material.PLANT, MaterialColor.GOLD).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS), () -> ModFeatures.HALLOWED_FUNGI_PLANTED);

	public static final PillarBlock CORRUPTED_STEM = new PillarBlock(AbstractBlock.Settings.of(Material.NETHER_WOOD, (blockState) -> MaterialColor.PURPLE).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM));
	public static final PillarBlock HALLOWED_STEM = new PillarBlock(AbstractBlock.Settings.of(Material.NETHER_WOOD, (blockState) -> MaterialColor.GOLD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM));

	public static void register()
	{
		registerBlocks();
		registerItems();
	}

	public static void registerClient()
	{
		BlockRenderLayerMap.INSTANCE.putBlock(CORRUPTED_FUNGUS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(HALLOWED_FUNGUS, RenderLayer.getCutout());
	}

	private static void registerBlocks()
	{
		Registry.register(Registry.BLOCK, new Identifier("depths", "deep_stone"), DEEP_STONE);
		Registry.register(Registry.BLOCK, new Identifier("depths", "deep_soil"), DEEP_SOIL);
		Registry.register(Registry.BLOCK, new Identifier("depths", "deep_sand"), DEEP_SAND);
		Registry.register(Registry.BLOCK, new Identifier("depths", "corrupted_nylium"), CORRUPTED_NYLIUM);
		Registry.register(Registry.BLOCK, new Identifier("depths", "hallowed_nylium"), HALLOWED_NYLIUM);
		Registry.register(Registry.BLOCK, new Identifier("depths", "corrupted_wart_block"), CORRUPTED_WART_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("depths", "hallowed_wart_block"), HALLOWED_WART_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("depths", "corrupted_fungus"), CORRUPTED_FUNGUS);
		Registry.register(Registry.BLOCK, new Identifier("depths", "hallowed_fungus"), HALLOWED_FUNGUS);
		Registry.register(Registry.BLOCK, new Identifier("depths", "corrupted_stem"), CORRUPTED_STEM);
		Registry.register(Registry.BLOCK, new Identifier("depths", "hallowed_stem"), HALLOWED_STEM);
	}

	private static void registerItems()
	{
		Registry.register(Registry.ITEM, new Identifier("depths", "deep_stone"), new BlockItem(DEEP_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "deep_soil"), new BlockItem(DEEP_SOIL, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "deep_sand"), new BlockItem(DEEP_SAND, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "corrupted_nylium"), new BlockItem(CORRUPTED_NYLIUM, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "hallowed_nylium"), new BlockItem(HALLOWED_NYLIUM, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "corrupted_wart_block"), new BlockItem(CORRUPTED_WART_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "hallowed_wart_block"), new BlockItem(HALLOWED_WART_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "corrupted_fungus"), new BlockItem(CORRUPTED_FUNGUS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "hallowed_fungus"), new BlockItem(HALLOWED_FUNGUS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "corrupted_stem"), new BlockItem(CORRUPTED_STEM, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.ITEM, new Identifier("depths", "hallowed_stem"), new BlockItem(HALLOWED_STEM, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
