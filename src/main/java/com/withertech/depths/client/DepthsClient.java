package com.withertech.depths.client;

import com.withertech.depths.init.ModBlocks;
import com.withertech.depths.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class DepthsClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		ModBlocks.registerClient();
		ModEntities.registerClient();
	}
}
