package client.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBoss extends ModelBase
{
  //fields
    ModelRenderer wing1;
    ModelRenderer wing2;
    ModelRenderer wing3;
    ModelRenderer wing4;
    ModelRenderer wing5;
    ModelRenderer wing6;
    ModelRenderer wing7;
    ModelRenderer wing8;
    ModelRenderer wing9;
    ModelRenderer wing10;
    ModelRenderer wing11;
    ModelRenderer wing12;
    ModelRenderer wing13;
    ModelRenderer wing14;
    ModelRenderer wing15;
    ModelRenderer Head;
    ModelRenderer Right_Arm;
    ModelRenderer Left_Arm;
    ModelRenderer Body;
    ModelRenderer Right_Leg;
    ModelRenderer Left_Leg;
  
  public ModelBoss()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      wing1 = new ModelRenderer(this, 81, 0);
      wing1.addBox(0F, -1F, -1F, 15, 2, 3);
      wing1.setRotationPoint(3F, 0F, -1F);
      wing1.setTextureSize(128, 128);
      wing1.mirror = true;
      setRotation(wing1, -0.669215F, 0.4833219F, -0.3346075F);
      wing2 = new ModelRenderer(this, 0, 0);
      wing2.addBox(0F, -1F, -1F, 15, 2, 3);
      wing2.setRotationPoint(15F, -5F, -7F);
      wing2.setTextureSize(128, 128);
      wing2.mirror = true;
      setRotation(wing2, -0.7435722F, 0.3346075F, 0.2974289F);
      wing3 = new ModelRenderer(this, 0, 0);
      wing3.addBox(0F, -1F, -1F, 11, 1, 3);
      wing3.setRotationPoint(27F, 0F, -12F);
      wing3.setTextureSize(128, 128);
      wing3.mirror = true;
      setRotation(wing3, -0.5576792F, 0.2230717F, 0.8922867F);
      wing4 = new ModelRenderer(this, 92, 92);
      wing4.addBox(0F, 0F, 0F, 6, 14, 1);
      wing4.setRotationPoint(4F, -1F, -4F);
      wing4.setTextureSize(128, 128);
      wing4.mirror = true;
      setRotation(wing4, 0.9294653F, -0.1115358F, -0.1115358F);
      wing5 = new ModelRenderer(this, 79, 37);
      wing5.addBox(0F, 0F, 0F, 14, 17, 1);
      wing5.setRotationPoint(17F, -5F, -9F);
      wing5.setTextureSize(128, 128);
      wing5.mirror = true;
      setRotation(wing5, 0.8179294F, 0.0743572F, 0.5205006F);
      wing6 = new ModelRenderer(this, 110, 36);
      wing6.addBox(0F, 0F, 0F, 6, 15, 1);
      wing6.setRotationPoint(10F, -3F, -5F);
      wing6.setTextureSize(128, 128);
      wing6.mirror = true;
      setRotation(wing6, 0.9294653F, -0.1487144F, 0.1115358F);
      wing7 = new ModelRenderer(this, 7, 29);
      wing7.addBox(0F, 0F, 0F, 4, 4, 1);
      wing7.setRotationPoint(13F, -4F, -8F);
      wing7.setTextureSize(128, 128);
      wing7.mirror = true;
      setRotation(wing7, 0.9294653F, -0.1487144F, 0.1115358F);
      wing8 = new ModelRenderer(this, 26, 100);
      wing8.addBox(0F, 0F, 0F, 20, 15, 1);
      wing8.setRotationPoint(28F, 2F, -11F);
      wing8.setTextureSize(128, 128);
      wing8.mirror = true;
      setRotation(wing8, 0.676754F, 0.414335F, 0.8458134F);
      wing9 = new ModelRenderer(this, 0, 1);
      wing9.addBox(-15F, 0F, 0F, 15, 2, 3);
      wing9.setRotationPoint(-2F, -1F, -1F);
      wing9.setTextureSize(128, 128);
      wing9.mirror = true;
      setRotation(wing9, -0.6692116F, -0.4833166F, 0.3346145F);
      wing10 = new ModelRenderer(this, 0, 0);
      wing10.addBox(-15F, 0F, 0F, 15, 2, 3);
      wing10.setRotationPoint(-15F, -6F, -7F);
      wing10.setTextureSize(128, 128);
      wing10.mirror = true;
      setRotation(wing10, -0.7435801F, -0.3346145F, -0.2974216F);
      wing11 = new ModelRenderer(this, 0, 0);
      wing11.addBox(-11F, 0F, -2F, 11, 1, 3);
      wing11.setRotationPoint(-27F, 0F, -10F);
      wing11.setTextureSize(128, 128);
      wing11.mirror = true;
      setRotation(wing11, -0.5576792F, -0.2230705F, -0.8922821F);
      wing12 = new ModelRenderer(this, 70, 112);
      wing12.addBox(-6F, 0F, 0F, 6, 14, 1);
      wing12.setRotationPoint(-3F, -1F, -3F);
      wing12.setTextureSize(128, 128);
      wing12.mirror = true;
      setRotation(wing12, 0.9294576F, -0.105732F, -0.0242775F);
      wing13 = new ModelRenderer(this, 76, 92);
      wing13.addBox(-4F, 0F, 0F, 6, 15, 1);
      wing13.setRotationPoint(-12F, -3F, -5F);
      wing13.setTextureSize(128, 128);
      wing13.mirror = true;
      setRotation(wing13, 0.9294576F, 0.1487195F, -0.1289973F);
      wing14 = new ModelRenderer(this, 44, 75);
      wing14.addBox(0F, 0F, 0F, 14, 17, 1);
      wing14.setRotationPoint(-27F, 2F, -9F);
      wing14.setTextureSize(128, 128);
      wing14.mirror = true;
      setRotation(wing14, 0.8179294F, -0.074351F, -0.5204921F);
      wing15 = new ModelRenderer(this, 74, 56);
      wing15.addBox(-20F, 0F, 0F, 20, 15, 1);
      wing15.setRotationPoint(-25F, 0F, -9F);
      wing15.setTextureSize(128, 128);
      wing15.mirror = true;
      setRotation(wing15, 0.676754F, -0.4143412F, -0.8458215F);
      Head = new ModelRenderer(this, 36, 0);
      Head.addBox(0F, 0F, 0F, 8, 8, 8);
      Head.setRotationPoint(-3F, -7F, -13F);
      Head.setTextureSize(128, 128);
      Head.mirror = true;
      setRotation(Head, 0.4363323F, 0F, 0F);
      Right_Arm = new ModelRenderer(this, 0, 39);
      Right_Arm.addBox(0F, 0F, 0F, 4, 12, 4);
      Right_Arm.setRotationPoint(5F, -1F, -7F);
      Right_Arm.setTextureSize(128, 128);
      Right_Arm.mirror = true;
      setRotation(Right_Arm, 0.4363323F, 0F, 0F);
      Left_Arm = new ModelRenderer(this, 0, 39);
      Left_Arm.addBox(0F, 0F, 0F, 4, 12, 4);
      Left_Arm.setRotationPoint(-7F, -1F, -7F);
      Left_Arm.setTextureSize(128, 128);
      Left_Arm.mirror = true;
      setRotation(Left_Arm, 0.4363323F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 55);
      Body.addBox(0F, 0F, 0F, 8, 12, 4);
      Body.setRotationPoint(-3F, -1F, -7F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 0.4363323F, 0F, 0F);
      Right_Leg = new ModelRenderer(this, 0, 71);
      Right_Leg.addBox(0F, 0F, 0F, 4, 12, 4);
      Right_Leg.setRotationPoint(1F, 9.9F, -1.9F);
      Right_Leg.setTextureSize(128, 128);
      Right_Leg.mirror = true;
      setRotation(Right_Leg, 0.4363323F, 0F, 0F);
      Left_Leg = new ModelRenderer(this, 0, 71);
      Left_Leg.addBox(0F, 0F, 0F, 4, 12, 4);
      Left_Leg.setRotationPoint(-3F, 9.9F, -1.9F);
      Left_Leg.setTextureSize(128, 128);
      Left_Leg.mirror = true;
      setRotation(Left_Leg, 0.4363323F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    wing1.render(f5);
    wing2.render(f5);
    wing3.render(f5);
    wing4.render(f5);
    wing5.render(f5);
    wing6.render(f5);
    wing7.render(f5);
    wing8.render(f5);
    wing9.render(f5);
    wing10.render(f5);
    wing11.render(f5);
    wing12.render(f5);
    wing13.render(f5);
    wing14.render(f5);
    wing15.render(f5);
    Head.render(f5);
    Right_Arm.render(f5);
    Left_Arm.render(f5);
    Body.render(f5);
    Right_Leg.render(f5);
    Left_Leg.render(f5);
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