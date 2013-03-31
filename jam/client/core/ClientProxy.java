package client.core;

import client.core.entity.EntityBoss;
import client.core.entity.EntityPiggy;
import client.core.model.ModelBoss;
import client.core.model.ModelPiggy;
import client.core.render.RenderBoss;
import client.core.render.RenderPiggy;
import common.ModJam;
import common.core.CommonProxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
public class ClientProxy extends CommonProxy {
	ModelBase base;
	public void initMod()
	{
		super.initMod();
		//MinecraftForgeClient.registerItemRenderer(NanoEnergy.nanogun.itemID, (IItemRenderer)new ItemRenderGun());
		//RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		ModJam.modelID = RenderingRegistry.getNextAvailableRenderId();
		//RenderingRegistry.registerBlockHandler(new RenderTable(NanoEnergy.modelID));
		//ClientRegistry.bindTileEntitySpecialRenderer(TileNanoTable.class, new RenderTable(NanoEnergy.modelID));
		 RenderingRegistry.registerEntityRenderingHandler(EntityBoss.class, new RenderBoss(new ModelBoss(), 0.5F));
		 RenderingRegistry.registerEntityRenderingHandler(EntityPiggy.class, new RenderPiggy(new ModelPiggy(0), base, 0.5F));
		

	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		/*if (ID == GuiIds.NANOTABLE) {
	        TileNanoTable tileNanoTable = (TileNanoTable) world.getBlockTileEntity(x, y, z);
	        return new GuiCalcinator(player.inventory, tileNanoTable);
	    }*/

	    return null;
	}
	
	
        
public void registerRenderInformation(){
	MinecraftForgeClient.preloadTexture("/modjam/items.png");
	
}

}
