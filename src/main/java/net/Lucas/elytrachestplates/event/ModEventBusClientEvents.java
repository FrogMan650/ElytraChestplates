package net.Lucas.elytrachestplates.event;

import net.Lucas.elytrachestplates.ElytraChestplates;
import net.Lucas.elytrachestplates.entity.client.DiamondElytraLayer;
import net.Lucas.elytrachestplates.entity.client.DiamondElytraModel;
import net.Lucas.elytrachestplates.entity.client.NetheriteElytraLayer;
import net.Lucas.elytrachestplates.entity.client.NetheriteElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
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
        for (String skin : event.getSkins()) {
            LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> renderer = event.getSkin(skin);

            if (renderer != null) {
                renderer.addLayer(new DiamondElytraLayer(renderer, event.getEntityModels()));
                renderer.addLayer(new NetheriteElytraLayer(renderer, event.getEntityModels()));
            }
        }
        LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> renderer = event.getRenderer(EntityType.ARMOR_STAND);
        if (renderer != null) {
            renderer.addLayer(new DiamondElytraLayer(renderer, event.getEntityModels()));
            renderer.addLayer(new NetheriteElytraLayer(renderer, event.getEntityModels()));
        }
    }

}
