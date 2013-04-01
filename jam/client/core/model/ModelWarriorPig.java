package client.core.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWarriorPig extends ModelBase {
	ModelChest chest = new ModelChest();
	 public ModelRenderer head = new ModelRenderer(this, 0, 0);
	    public ModelRenderer body;
	    public ModelRenderer leg1;
	    public ModelRenderer leg2;
	    public ModelRenderer leg3;
	    public ModelRenderer leg4;
	    protected float field_78145_g = 8.0F;
	    protected float field_78151_h = 4.0F;

	    public ModelWarriorPig(int par1, float par2)
	    {
	    	textureHeight = 128;
	        textureWidth = 128;
	        chest = new ModelChest();
	        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8);
	        this.head.setRotationPoint(0.0F, (float)(18 - 6), -6.0F);
	        this.body = new ModelRenderer(this, 28, 8);
	        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8);
	        this.body.setRotationPoint(0.0F, (float)(17 - 6), 2.0F);
	        this.leg1 = new ModelRenderer(this, 0, 16);
	        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, par2);
	        this.leg1.setRotationPoint(-3.0F, (float)(24 - 6), 7.0F);
	        this.leg2 = new ModelRenderer(this, 0, 16);
	        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, par2);
	        this.leg2.setRotationPoint(3.0F, (float)(24 - 6), 7.0F);
	        this.leg3 = new ModelRenderer(this, 0, 16);
	        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, par2);
	        this.leg3.setRotationPoint(-3.0F, (float)(24 - 6), -5.0F);
	        this.leg4 = new ModelRenderer(this, 0, 16);
	        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, par2);
	        this.leg4.setRotationPoint(3.0F, (float)(24 - 6), -5.0F);
	        this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1);
	    	this.head.setTextureOffset(0, 32).addBox(-5F, -5F, -9F, 10, 3, 9);
	        this.head.setTextureOffset(0, 44).addBox(-1F, -2F, -9F, 2, 2, 1);
	        this.head.setTextureOffset(0, 48).addBox(-5F, -2F, -6F, 1, 1, 5);
	    }

	    /**
	     * Sets the models various rotation angles then renders the model.
	     */
	    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	    {
	        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
	        this.textureHeight = 128;
	        this.textureWidth = 128;

	        if (this.isChild)
	        {
	        	this.textureHeight = 128;
		        this.textureWidth = 128;
	            float f6 = 2.0F;
	            GL11.glPushMatrix();
	            this.head.render(par7);
	            GL11.glPopMatrix();
	            GL11.glPushMatrix();
	            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
	            this.body.render(par7);
	            this.leg1.render(par7);
	            this.leg2.render(par7);
	            this.leg3.render(par7);
	            this.leg4.render(par7);
	            GL11.glPopMatrix();
	        }
	        else
	        {
	        	this.textureHeight = 128;
		        this.textureWidth = 128;
	            this.head.render(par7);
	            this.body.render(par7);
	            this.leg1.render(par7);
	            this.leg2.render(par7);
	            this.leg3.render(par7);
	            this.leg4.render(par7);
	        }
	    }

	    /**
	     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
	     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
	     * "far" arms and legs can swing at most.
	     */
	    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	    {
	        this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
	        this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
	        this.body.rotateAngleX = ((float)Math.PI / 2F);
	        this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	        this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	        this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	        this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	    }
	}
