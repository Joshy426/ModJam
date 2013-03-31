package client.core.model;

import org.lwjgl.opengl.GL11;

import client.core.entity.EntityHeadPPiggy;
import client.core.entity.EntityPigCapitalist;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

public class ModelCapitalistPig extends ModelPig {

    public ModelCapitalistPig(float par1)
    {
        super(par1);
        //Base
        this.head.setTextureOffset(40, 0).addBox(-3F, -5F, -7F, 6, 1, 6);
        //Top
        this.head.setTextureOffset(24, 0).addBox(-2F, -9F, -6F, 4, 4, 4);
    }
}