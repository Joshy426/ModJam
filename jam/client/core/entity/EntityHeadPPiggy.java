package client.core.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCloth;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityHeadPPiggy extends EntityTameable
{
    private float field_70926_e;
    private float field_70924_f;

    /** true is the wolf is wet else false */
    private boolean isShaking;
    private boolean field_70928_h;

    /**
     * This time increases while wolf is shaking and emitting water particles.
     */
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    private final EntityAIControlledByPlayer aiControlledByPlayer;

    public EntityHeadPPiggy(World par1World)
    {
        super(par1World);
        this.texture = "/mods/modjam/textures/mobs/pig.png";
        this.setSize(0.9F, 0.9F);
        this.moveSpeed = 0.3F;
        float f = 0.25F;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.34F));
        this.tasks.addTask(3, new EntityAIMate(this, f));
        this.tasks.addTask(9, this.aiSit);
        this.tasks.addTask(4, new EntityAITempt(this, 0.3F, Item.carrotOnAStick.itemID, false));
        this.tasks.addTask(4, new EntityAITempt(this, 0.3F, Item.carrot.itemID, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 0.28F));
        this.tasks.addTask(6, new EntityAIWander(this, f));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(10, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityZombie.class, 8.0F, 0, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 12.0F, 0, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySlime.class, 8.0F, 0, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 8.0F, 0, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySpider.class, 8.0F, 0, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, 12.0F, 0, true));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    
    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLiving par1EntityLiving)
    {
        super.setAttackTarget(par1EntityLiving);

        if (par1EntityLiving instanceof EntityPlayer)
        {
        }
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
    }

    public int getMaxHealth()
    {
        return this.isTamed() ? 20 : 8;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, new Integer(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
    }

    protected String getLivingSound()
    {
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.pig.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.pig.death";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.pig.step", 0.15F, 1.0F);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Saddle", this.getSaddled());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSaddled(par1NBTTagCompound.getBoolean("Saddle"));
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Item.porkCooked.itemID, 1);
            }
            else
            {
                this.dropItem(Item.porkRaw.itemID, 1);
            }
        }

        if (this.getSaddled())
        {
            this.dropItem(Item.saddle.itemID, 1);
        }
    }
    
    /**
     * Returns true if the pig is saddled.
     */
    public boolean getSaddled()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }
    
    

    /**
     * Set or remove the saddle of the pig.
     */
    public void setSaddled(boolean par1)
    {
        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
        }
    }
    
    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
        super.fall(par1);

        if (par1 > 5.0F && this.riddenByEntity instanceof EntityPlayer)
        {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.worldObj.isRemote && !this.field_70928_h && !this.hasPath() && this.onGround)
        {
            this.field_70928_h = true;
            this.worldObj.setEntityState(this, (byte)8);
        }
    }
    
    /**
     * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
     * by a player and the player is holding a carrot-on-a-stick
     */
    public boolean canBeSteered()
    {
        ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return itemstack != null && itemstack.itemID == Item.carrotOnAStick.itemID;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;

        if (this.func_70922_bv())
        {
            this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
        }
        else
        {
            this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
        }

        if (this.func_70922_bv())
        {
            this.numTicksToChaseTarget = 10;
        }
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float par1)
    {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float)Math.PI;
    }

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }


    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = par1DamageSource.getEntity();
            this.aiSit.setSitting(false);

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                par2 = (par2 + 1) / 2;
            }

            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        int i = this.isTamed() ? 4 : 2;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
    	
    	ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if (this.isTamed())
        {
            if (itemstack != null)
            {
                if (Item.itemsList[itemstack.itemID] instanceof ItemFood)
                {
                    ItemFood itemfood = (ItemFood)Item.itemsList[itemstack.itemID];

                    if (itemfood == itemfood.bread && this.dataWatcher.getWatchableObjectInt(18) < 20)
                    {
                        if (!par1EntityPlayer.capabilities.isCreativeMode)
                        {
                            --itemstack.stackSize;
                        }

                        this.heal(itemfood.getHealAmount());

                        if (itemstack.stackSize <= 0)
                        {
                            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                        }
                    }
                    }
            	}	
            }
        return super.interact(par1EntityPlayer);
        }
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 8)
        {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == Item.carrot.itemID;
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityHeadPPiggy spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        EntityHeadPPiggy entitywolf = new EntityHeadPPiggy(this.worldObj);
        String s = this.getOwnerName();

        if (s != null && s.trim().length() > 0)
        {
            entitywolf.setOwner(s);
            entitywolf.setTamed(true);
        }

        return entitywolf;
    }

    public void func_70918_i(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(19);

        if (par1)
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
        }
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal par1EntityAnimal)
    {
        if (par1EntityAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(par1EntityAnimal instanceof EntityHeadPPiggy))
        {
            return false;
        }
        else
        {
            EntityHeadPPiggy entitywolf = (EntityHeadPPiggy)par1EntityAnimal;
            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
        }
    }

    public boolean func_70922_bv()
    {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}
