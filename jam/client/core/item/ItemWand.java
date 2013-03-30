package client.core.item;

import common.ModJam;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemWand extends Item {

	public ItemWand(int id) {
		super(id);
		this.setUnlocalizedName("nanochip"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		this.setCreativeTab(ModJam.tabModJam); //Tells the game what creative mode tab it goes in
		}
		@Override
		public void updateIcons(IconRegister iconRegister)
		{
			iconIndex = iconRegister.registerIcon("modjam:wand");
		}
		}