package com.withertech.depths.init;

import com.withertech.depths.entities.SoulBlazeEntity;
import com.withertech.depths.entities.SoulBlazeEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities
{
	public static final EntityType<SoulBlazeEntity> SOUL_BLAZE = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulBlazeEntity::new).fireImmune().dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackRangeBlocks(8).build();

	public static void register()
	{
		registerTypes();
		registerAttributes();
	}
	public static void registerTypes()
	{
		Registry.register(Registry.ENTITY_TYPE, new Identifier("depths", "soul_blaze"), SOUL_BLAZE);
	}

	public static void registerAttributes()
	{
		FabricDefaultAttributeRegistry.register(SOUL_BLAZE, SoulBlazeEntity.createMobAttributes());
	}

	public static void registerClient()
	{
		EntityRendererRegistry.INSTANCE.register(SOUL_BLAZE, (dispatcher, context) -> new SoulBlazeEntityRenderer(dispatcher));
	}
}
