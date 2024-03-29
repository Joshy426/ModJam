package client.core.render;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import client.core.entity.EntityHeadPPiggy;
import client.core.entity.EntityPigCapitalist;
import client.core.model.ModelCapitalistPig;
import client.core.model.ModelHeadPPiggy;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.model.ModelChest;
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
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class RenderCapitalistPig extends RenderLiving {
	 
	ModelChest chest = new ModelChest();
	ModelCapitalistPig pig = new ModelCapitalistPig(0);
	
	public RenderCapitalistPig(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
        chest = new ModelChest();
        pig = new ModelCapitalistPig(0);
    }

    protected int renderSaddledPig(EntityPigCapitalist par1EntityPig, int par2, float par3)
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

    public void renderLivingPig(EntityPigCapitalist par1EntityPig, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityPig, par2, par4, par6, par8, par9);
        
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.renderSaddledPig((EntityPigCapitalist)par1EntityLiving, par2, par3);
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLivingPig((EntityPigCapitalist)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double x, double y, double z, float par8, float par9)
    {
        this.renderLivingPig((EntityPigCapitalist)par1Entity, x, y, z, par8, par9);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);

				GL11.glScalef(0.5F, 0.5F, 0.5F);
				loadTexture("/item/chest.png");
				pig.boxList.add(chest.chestBelow);
				pig.boxList.add(chest.chestKnob);
				pig.boxList.add(chest.chestLid);

				GL11.glPopMatrix();
    }
}
