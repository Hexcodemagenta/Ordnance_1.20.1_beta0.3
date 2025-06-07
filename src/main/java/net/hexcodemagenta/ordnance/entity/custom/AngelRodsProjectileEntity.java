package net.hexcodemagenta.ordnance.entity.custom;

import net.hexcodemagenta.ordnance.entity.ModEntities;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class AngelRodsProjectileEntity extends ThrownItemEntity {
    public AngelRodsProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public AngelRodsProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.ANGEL_RODS_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ANGEL_RODS;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 10.0F);
        entityHitResult.getEntity().setFireTicks(100);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte) 3);
            this.getWorld().setBlockState(getBlockPos(), Blocks.FIRE.getDefaultState());

            this.discard();
            super.onEntityHit(entityHitResult);
        }
    }
}