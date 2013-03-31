package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import client.core.entity.EntityBoss;
import client.core.entity.EntityPiggy;
import client.core.handlers.ClientPacketHandler;
import client.core.item.ItemWand;

import common.core.CommonProxy;
import common.core.handlers.ServerPacketHandler;
import common.tabs.TabModJam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@NetworkMod(clientSideRequired = true, serverSideRequired = false, // Whether
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "ModJam" }, packetHandler = ClientPacketHandler.class), // For
serverPacketHandlerSpec = @SidedPacketHandler(channels = {}, packetHandler = ServerPacketHandler.class))
@Mod(modid = "modjam", name = "Mod Jam", version = "0.1")




public class ModJam {

	//EntityPiggy piggy = new EntityPiggy(world);
	@Instance("modjam")
	// The instance, this is very important later on
	public static ModJam instance = new ModJam();

	@SidedProxy(clientSide = "client.core.ClientProxy", serverSide = "common.core.CommonProxy")
	// Tells Forge the location of your proxies

	public static CommonProxy proxy;
	public static List<ItemStack> inputs;

	@Init
	public void InitCobaltCraft(FMLInitializationEvent event) { // Your main
		// initialization
		// method
		proxy.registerEntity();

		NetworkRegistry.instance().registerGuiHandler(this, proxy); // Registers
		// the class
		// that
		// deals
		// with GUI
		// data
		proxy.addNames();
	}

	public int getMetadata(int damageValue) {
		return damageValue;
	}

	// Tab
	public static HashMap cHex = new HashMap();
	public static HashMap modPartMap = new HashMap();
	public static CreativeTabs tabModJam = new TabModJam(
			CreativeTabs.getNextID(), "Mod Jam"); // Our custom creative
	// tab's object

	// Items
	//public static Item nanochip = new ItemNanoChip(5432, 0); // Nano Chip
	public static Item wand = new ItemWand(6400); // Wand

	// Blocks
	//public static Block blockTable;
	public static int modelID = RenderingRegistry.getNextAvailableRenderId();;

	@Init
	public void load(FMLInitializationEvent event) {
		//blockTable = new BlockTable(234, Material.rock).setHardness(1F).setResistance(1F);
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.initMod();
		proxy.initTileEntities();
		MinecraftForge.EVENT_BUS.register(this);
		int redColor = (255 << 16);
		int orangeColor = (255 << 16)+ (200 << 8);
		ModLoader.registerEntityID(EntityBoss.class, "Boss", ModLoader.getUniqueEntityId(), redColor,orangeColor);
		ModLoader.registerEntityID(EntityPiggy.class, "Pig", ModLoader.getUniqueEntityId(), redColor,orangeColor);
	}

	/*@ForgeSubscribe
	public void onInteract(EntityInteractEvent event) {
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && event.target instanceof EntityPig) {
		String name = event.target.getEntityName();
			World world = event.entity.worldObj;
			EntityPig pig = new EntityPig(world);
			double posX = event.target.posX;
			double posY = event.target.posY;
			double posZ = event.target.posZ;
			//world.spawnEntityInWorld(piggy);
			System.out.println(name);
			if(!pig.worldObj.isRemote) {
				world.setSpawnLocation((int)posX, (int)posY, (int)posZ);
				Entity e = new EntityPiggy(world);
				e.posX = posX;
				e.posY = posY;
				e.posZ = posZ;
				System.out.println("Works!");
				world.spawnEntityInWorld(e);
				//event.target.setDead();
	                }
			System.out.println("Coordinates:" + posX + posY + posZ);

		}
	}*/
	@ForgeSubscribe

	public void entityInteracted(EntityInteractEvent ev){

		EntityPlayer player = ev.entityPlayer;
		ItemStack itemstack = player.getCurrentEquippedItem();

		Entity target = ev.target;



		if (target instanceof EntityPig && itemstack != null && itemstack.getItem() == Item.appleGold)
		{
			EntityPig oldpiggy = (EntityPig) ev.target;
			World world = target.worldObj;

			if (world.isRemote)
			{
				return;
			}
			EntityPiggy newpiggy = new EntityPiggy(world);
			newpiggy.setLocationAndAngles(oldpiggy.posX, oldpiggy.posY, oldpiggy.posZ, oldpiggy.rotationYaw, oldpiggy.rotationPitch);
			world.spawnEntityInWorld(newpiggy);
			oldpiggy.setDead();
			System.out.println("Attempted!");
			if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }
				return;
			}   
		}
	}
