package net.hexcodemagenta.ordnance.entity;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.hexcodemagenta.ordnance.Ordnance;
import net.hexcodemagenta.ordnance.entity.custom.AngelRodsProjectileEntity;
import net.hexcodemagenta.ordnance.item.ModItems;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hexcodemagenta.ordnance.Ordnance.MOD_ID;

public class ModEntities {
    public static final EntityType<AngelRodsProjectileEntity> ANGEL_RODS_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Ordnance.MOD_ID, "angel_rods_projectile"),
            FabricEntityTypeBuilder.<AngelRodsProjectileEntity>create(SpawnGroup.MISC, AngelRodsProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());


    public static void registerModEntities() {
        Ordnance.LOGGER.info("Registering Mod Entities for " + MOD_ID);
    }
}
