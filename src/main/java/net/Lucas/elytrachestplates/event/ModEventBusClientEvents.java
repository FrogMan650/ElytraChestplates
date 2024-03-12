package net.Lucas.elytrachestplates.event;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.Lucas.elytrachestplates.entity.client.DiamondElytraLayer;
import net.Lucas.elytrachestplates.entity.client.DiamondElytraModel;
import net.Lucas.elytrachestplates.entity.client.NetheriteElytraLayer;
import net.Lucas.elytrachestplates.entity.client.NetheriteElytraModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElytraChestplates.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DiamondElytraModel.WINGS_LAYER_LOCATION, DiamondElytraModel::createLayer);
        event.registerLayerDefinition(NetheriteElytraModel.WINGS_LAYER_LOCATION, NetheriteElytraModel::createLayer);
    }

    @SubscribeEvent @SuppressWarnings({"unchecked", "rawtypes"})
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerSkin.Model skin : event.getSkins()) {

            LivingEntityRenderer renderer = event.getPlayerSkin(skin);

            if (renderer != null) {
                renderer.addLayer(new DiamondElytraLayer(renderer, event.getEntityModels()));
                renderer.addLayer(new NetheriteElytraLayer(renderer, event.getEntityModels()));
            }
        }
        EntityRenderer renderer = event.getEntityRenderer(EntityType.ARMOR_STAND);
        if (renderer != null) {
            ((LivingEntityRenderer)renderer).addLayer(new DiamondElytraLayer(((LivingEntityRenderer)renderer), event.getEntityModels()));
            ((LivingEntityRenderer)renderer).addLayer(new NetheriteElytraLayer(((LivingEntityRenderer)renderer), event.getEntityModels()));
        }
    }

}
