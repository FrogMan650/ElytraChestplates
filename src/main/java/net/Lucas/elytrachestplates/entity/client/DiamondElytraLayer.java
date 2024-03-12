package net.Lucas.elytrachestplates.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.Lucas.elytrachestplates.ElytraChestplates;
import net.Lucas.elytrachestplates.item.ModItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DiamondElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
   private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(ElytraChestplates.MOD_ID ,"textures/entity/diamond_elytra.png");
   private final DiamondElytraModel<T> elytraModel;

   public DiamondElytraLayer(RenderLayerParent<T, M> pRenderer, EntityModelSet pModelSet) {
      super(pRenderer);
      this.elytraModel = new DiamondElytraModel<>(pModelSet.bakeLayer(DiamondElytraModel.WINGS_LAYER_LOCATION));
   }

   @Override
   public void render(@NotNull PoseStack pMatrixStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
      ItemStack itemstack = pLivingEntity.getItemBySlot(EquipmentSlot.CHEST);
      if (shouldRender(itemstack)) {
         ResourceLocation resourcelocation;
         if (pLivingEntity instanceof AbstractClientPlayer abstractclientplayer) {
            PlayerSkin playerskin = abstractclientplayer.getSkin();
            if (playerskin.elytraTexture() != null) {
               resourcelocation = playerskin.elytraTexture();
            } else if (playerskin.capeTexture() != null && abstractclientplayer.isModelPartShown(PlayerModelPart.CAPE)) {
               resourcelocation = playerskin.capeTexture();
            } else {
               resourcelocation = getElytraTexture();
            }
         } else {
            resourcelocation = getElytraTexture();
         }

         pMatrixStack.pushPose();
         pMatrixStack.translate(0.0F, 0.0F, 0.125F);
         this.getParentModel().copyPropertiesTo(this.elytraModel);
         this.elytraModel.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
         VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(pBuffer, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil());
         this.elytraModel.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
         pMatrixStack.popPose();
      }
   }

   public boolean shouldRender(ItemStack stack) { return stack.getItem() == ModItems.DIAMOND_ELYTRA_CHESTPLATE.get(); }

   public ResourceLocation getElytraTexture() {
      return WINGS_LOCATION;
   }
}
