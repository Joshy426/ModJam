package client.core.render;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import client.core.entity.EntityAdvWarriorPig;
import client.core.model.ModelHeadPPiggy;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class RenderAdvWarriorPig extends RenderLiving {
	 
	public RenderAdvWarriorPig(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected int renderSaddledPig(EntityAdvWarriorPig par1EntityPig, int par2, float par3)
    {
        if (par2 == 0 && par1EntityPig.getSaddled())
        {
            this.loadTexture("/mob/saddle.png");
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public void renderLivingPig(EntityAdvWarriorPig par1EntityPig, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityPig, par2, par4, par6, par8, par9);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.renderSaddledPig((EntityAdvWarriorPig)par1EntityLiving, par2, par3);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingPig((EntityAdvWarriorPig)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingPig((EntityAdvWarriorPig)par1Entity, par2, par4, par6, par8, par9);
    }
}