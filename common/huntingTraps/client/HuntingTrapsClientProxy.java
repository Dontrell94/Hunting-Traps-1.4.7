package huntingTraps.client;

import net.minecraftforge.client.MinecraftForgeClient;

public class HuntingTrapsClientProxy extends huntingTraps.common.HuntingtrapsCommonProxy
{
	@Override
	public void registerRenders()
	{
		MinecraftForgeClient.preloadTexture("/huntingTraps/textures/hnttrp.png");
		// RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
		// registerBlockHandler
	}
}
