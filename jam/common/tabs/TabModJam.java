package common.tabs;

import common.ModJam;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
public class TabModJam extends CreativeTabs {
public TabModJam(int position, String tabID) {
super(position, tabID); //The constructor for your tab
}
@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() //The item it displays for your tab
{
return ModJam.wand.itemID;
}
public String getTranslatedTabLabel()
{
return "Nano Energy"; //The name of the tab ingame
}
}