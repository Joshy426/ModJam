package client.core.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPiggy extends ModelBase {
	//fields
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer Top;
    public ModelRenderer EarOut2;
    public ModelRenderer EarOut1;
    public ModelRenderer Ear1;
    public ModelRenderer Side1;
    public ModelRenderer Side2;
    public ModelRenderer Ear2;
    public ModelRenderer Shape1;
  
  public ModelPiggy()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -8F, 8, 8, 8);
      head.setRotationPoint(0F, 12F, -6F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 28, 8);
      body.addBox(-5F, -10F, -7F, 10, 16, 8);
      body.setRotationPoint(0F, 11F, 3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg1.setRotationPoint(-3F, 18F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg2.setRotationPoint(3F, 18F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 18F, -2F, 4, 6, 4);
      leg3.setRotationPoint(-3F, 0F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
      leg4.setRotationPoint(3F, 18F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
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
      Shape1 = new ModelRenderer(this, 16, 16);
      Shape1.addBox(0F, -1F, 0F, 4, 3, 1);
      Shape1.setRotationPoint(-2F, 13F, -15F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Top.render(f5);
    EarOut2.render(f5);
    EarOut1.render(f5);
    Ear1.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Ear2.render(f5);
    Shape1.render(f5);
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
