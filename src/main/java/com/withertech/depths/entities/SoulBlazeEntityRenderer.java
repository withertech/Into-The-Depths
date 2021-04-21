package com.withertech.depths.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BlazeEntityModel;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class SoulBlazeEntityRenderer extends MobEntityRenderer<SoulBlazeEntity, SoulBlazeEntityModel<SoulBlazeEntity>>
{
	private static final Identifier TEXTURE = new Identifier("depths", "textures/entity/soul_blaze.png");

	public SoulBlazeEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
		super(entityRenderDispatcher, new SoulBlazeEntityModel(), 0.5F);
	}

	protected int getBlockLight(SoulBlazeEntity blazeEntity, BlockPos blockPos) {
		return 15;
	}

	public Identifier getTexture(SoulBlazeEntity blazeEntity) {
		return TEXTURE;
	}
}