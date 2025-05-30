package net.hexcodemagenta.ordnance;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hexcodemagenta.ordnance.entity.ModEntities;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class OrdnanceClient implements ClientModInitializer{
     @Override
     public void onInitializeClient(){

          EntityRendererRegistry.register(ModEntities.ANGEL_RODS_PROJECTILE, FlyingItemEntityRenderer::new);

     }
}
