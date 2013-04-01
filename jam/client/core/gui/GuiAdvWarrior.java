package client.core.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import client.core.entity.EntityAdvWarriorContainer;
import client.core.entity.EntityAdvWarriorPig;
import client.core.gui.container.AdvWarriorContainer;


import cpw.mods.fml.common.registry.LanguageRegistry;

public class GuiAdvWarrior extends GuiContainer {

	private IInventory upperChestInventory;
    private IInventory lowerChestInventory;

    /**
     * window height is calculated with this values, the more rows, the heigher
     */
    private int inventoryRows = 0;

    public GuiAdvWarrior(IInventory par1IInventory, IInventory par2IInventory)
    {
        super(new AdvWarriorContainer(par1IInventory, par2IInventory));
        this.upperChestInventory = par1IInventory;
        this.lowerChestInventory = par2IInventory;
        this.allowUserInput = false;
        short short1 = 222;
        int i = short1 - 108;
        this.inventoryRows = par2IInventory.getSizeInventory() / 9;
        this.ySize = i + this.inventoryRows * 18;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString("Stuff", 8, 6, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/crafting.png");
        int k = (this.width - this.xSize);
        int l = (this.height - this.ySize);
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, 5 * 18 + 17);
        this.drawTexturedModalRect(k, l + 5 * 18 + 17, 0, 126, this.xSize, 96);
    }
}
