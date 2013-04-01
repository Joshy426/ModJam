package client.core;

import lib.GuiIds;
import client.core.entity.EntityAdvWarriorPig;
import client.core.entity.EntityBoss;
import client.core.entity.EntityHeadPPiggy;
import client.core.entity.EntityPigCapitalist;
import client.core.entity.EntityWarriorPig;
import client.core.gui.GuiAdvWarrior;
import client.core.model.ModelAdvWarriorPig;
import client.core.model.ModelBoss;
import client.core.model.ModelCapitalistPig;
import client.core.model.ModelHeadPPiggy;
import client.core.model.ModelWarriorPig;
import client.core.render.RenderAdvWarriorPig;
import client.core.render.RenderBoss;
import client.core.render.RenderCapitalistPig;
import client.core.render.RenderHeadPPiggy;
import client.core.render.RenderWarriorPig;
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
	ModelWarriorPig pig;
	public void initMod()
	{
		super.initMod();
		//MinecraftForgeClient.registerItemRenderer(NanoEnergy.nanogun.itemID, (IItemRenderer)new ItemRenderGun());
		//RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		ModJam.modelID = RenderingRegistry.getNextAvailableRenderId();
		//RenderingRegistry.registerBlockHandler(new RenderTable(NanoEnergy.modelID));
		//ClientRegistry.bindTileEntitySpecialRenderer(TileNanoTable.class, new RenderTable(NanoEnergy.modelID));
		RenderingRegistry.registerEntityRenderingHandler(EntityBoss.class, new RenderBoss(new ModelBoss(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHeadPPiggy.class, new RenderHeadPPiggy(new ModelHeadPPiggy(0), base, 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPigCapitalist.class, new RenderCapitalistPig(new ModelCapitalistPig(0), base, 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWarriorPig.class, new RenderWarriorPig(new ModelWarriorPig(0, 0), base, 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAdvWarriorPig.class, new RenderAdvWarriorPig(new ModelAdvWarriorPig(0), base, 0.5F));


	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GuiIds.ADVWARRIOR) {
	        EntityAdvWarriorPig tileNanoTable = new EntityAdvWarriorPig(world);
	        return new GuiAdvWarrior(player.inventory, tileNanoTable);
	    }

		return null;
	}



	public void registerRenderInformation(){
		MinecraftForgeClient.preloadTexture("/modjam/items.png");

	}

}
