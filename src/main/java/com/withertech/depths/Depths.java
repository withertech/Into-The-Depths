package com.withertech.depths;

import com.withertech.depths.init.ModBlocks;
import com.withertech.depths.init.ModFeatures;
import com.withertech.depths.init.ModSurfaceBuilders;
import net.fabricmc.api.ModInitializer;

public class Depths implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		ModBlocks.register();
		ModSurfaceBuilders.register();
		ModFeatures.register();
	}
}
