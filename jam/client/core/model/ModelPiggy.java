package client.core.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPiggy extends ModelPig {

    public ModelPiggy(float par1)
    {
        super(par1);
        this.field_78145_g = 4.0F;
        //Top
        this.head.setTextureOffset(0, 29).addBox(-5F, -5F, -5F, 10, 1, 2);
        //Sides
        this.head.setTextureOffset(0, 28).addBox(-5F, -4F, -5F, 1, 2, 2);
        this.head.setTextureOffset(0, 28).addBox(4F, -4F, -5F, 1, 2, 2);
        //Ears
        this.head.setTextureOffset(32, 0).addBox(-5F, -2F, -6F, 1, 4, 4);
        this.head.setTextureOffset(32, 0).addBox(4F, -2F, -6F, 1, 4, 4);
        //Ear Peice
        this.head.setTextureOffset(42, 0).addBox(-6F, -1F, -5F, 1, 2, 2);
        this.head.setTextureOffset(42, 0).addBox(5F, -1F, -5F, 1, 2, 2);
    }

}