package client.core.render;

import java.util.Random;

import client.core.entity.EntityBoss;
import client.core.model.ModelBoss;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class RenderBoss extends RenderLiving
{
private ModelBoss modelBoss;
private Random rnd = new Random();
public RenderBoss(ModelBoss var1, float var2)
{
         super(var1, 0.5F);
         this.modelBoss = (ModelBoss)super.mainModel;
         this.setRenderPassModel(var1);
}

public void renderChicken(EntityBoss par1EntityChicken, double par2, double par4, double par6, float par8, float par9)
{
         super.doRenderLiving(par1EntityChicken, par2, par4, par6, par8, par9);
}
protected float getWingRotation(EntityBoss par1EntityChicken, float par2)
{
	return par2;
}
/**
         * Defines what float the third param in setRotationAngles of ModelBase is
         */
protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
{
         return this.getWingRotation((EntityBoss)par1EntityLiving, par2);
}
public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
{
         this.renderChicken((EntityBoss)par1EntityLiving, par2, par4, par6, par8, par9);
}
/**
         * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
         * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
         * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
         * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
         */
public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
{
         this.renderChicken((EntityBoss)par1Entity, par2, par4, par6, par8, par9);
}
}