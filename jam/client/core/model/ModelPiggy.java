package client.core.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPiggy extends ModelPig {
	//fields	
    ModelRenderer Top;
    ModelRenderer EarOut2;
    ModelRenderer EarOut1;
    ModelRenderer Ear1;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Ear2;
  
  public ModelPiggy()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Top = new ModelRenderer(this, 0, 29);
      Top.addBox(-5F, 7F, -11F, 10, 1, 2);
      Top.setRotationPoint(0F, 0F, 0F);
      Top.setTextureSize(64, 32);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      EarOut2 = new ModelRenderer(this, 42, 0);
      EarOut2.addBox(-5F, 7F, -11F, 1, 2, 2);
      EarOut2.setRotationPoint(10F, 4F, 0F);
      EarOut2.setTextureSize(64, 32);
      EarOut2.mirror = true;
      setRotation(EarOut2, 0F, 0F, 0F);
      EarOut1 = new ModelRenderer(this, 42, 0);
      EarOut1.addBox(-5F, 7F, -11F, 1, 2, 2);
      EarOut1.setRotationPoint(-1F, 4F, 0F);
      EarOut1.setTextureSize(64, 32);
      EarOut1.mirror = true;
      setRotation(EarOut1, 0F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 32, 0);
      Ear1.addBox(-5F, 7F, -11F, 1, 4, 4);
      Ear1.setRotationPoint(0F, 3F, -1F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 28);
      Side1.addBox(-5F, 7F, -11F, 1, 2, 2);
      Side1.setRotationPoint(0F, 1F, 0F);
      Side1.setTextureSize(64, 32);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 28);
      Side2.addBox(-5F, 7F, -11F, 1, 2, 2);
      Side2.setRotationPoint(9F, 1F, 0F);
      Side2.setTextureSize(64, 32);
      Side2.mirror = true;
      setRotation(Side2, 0F, 0F, 0F);
      Ear2 = new ModelRenderer(this, 32, 0);
      Ear2.addBox(-5F, 7F, -11F, 1, 4, 4);
      Ear2.setRotationPoint(9F, 3F, -1F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Top.render(f5);
    EarOut2.render(f5);
    EarOut1.render(f5);
    Ear1.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Ear2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}