package com.teamremastered.betterendforge.item.model;

import com.google.common.collect.Lists;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.item.CrystaliteArmor;
import com.teamremastered.betterendforge.registry.EndItems;
import shadow.fabric.api.client.rendering.v1.ArmorRenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class CrystaliteArmorProvider implements ArmorRenderingRegistry.ModelProvider, ArmorRenderingRegistry.TextureProvider {
	//TODO: find new registry
	private final static ResourceLocation FIRST_LAYER = new ResourceLocation(
		"textures/models/armor/crystalite_layer_1.png");
	private final static ResourceLocation SECOND_LAYER = new ResourceLocation(
		"textures/models/armor/crystalite_layer_2.png");
	private final static CrystaliteHelmetModel HELMET_MODEL = CrystaliteHelmetModel.createModel(null);
	private final static CrystaliteChestplateModel CHEST_MODEL = CrystaliteChestplateModel.createRegularModel(null);
	private final static CrystaliteChestplateModel CHEST_MODEL_SLIM = CrystaliteChestplateModel.createThinModel(null);
	private final static CrystaliteLeggingsModel LEGGINGS_MODEL = CrystaliteLeggingsModel.createModel(null);
	private final static CrystaliteBootsModel BOOTS_MODEL = CrystaliteBootsModel.createModel(null);
	
	//@Override
	public @NotNull ResourceLocation getArmorTexture(LivingEntity entity, ItemStack stack, EquipmentSlot slot, boolean secondLayer, @Nullable String suffix, ResourceLocation defaultTexture) {
		if (!isStackValid(stack)) return defaultTexture;
		if (secondLayer) return SECOND_LAYER;
		return FIRST_LAYER;
	}
	
	//@Override
	public @NotNull HumanoidModel<LivingEntity> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<LivingEntity> defaultModel) {
		if (!isStackValid(stack)) return defaultModel;
		switch (slot) {
			case HEAD: {
				return HELMET_MODEL;
			}
			case CHEST: {
				if (entity instanceof AbstractClientPlayer && ((AbstractClientPlayer) entity).getModelName()
																							 .equals("slim")) {
					CHEST_MODEL_SLIM.copyPropertiesTo(defaultModel);
					return CHEST_MODEL_SLIM;
				}
				CHEST_MODEL.copyPropertiesTo(defaultModel);
				return CHEST_MODEL;
			}
			case LEGS: {
				return LEGGINGS_MODEL;
			}
			case FEET: {
				BOOTS_MODEL.copyPropertiesTo(defaultModel);
				return BOOTS_MODEL;
			}
			default: {
				return defaultModel;
			}
		}
	}
	
	public Iterable<Item> getRenderedItems() {
		return Lists.newArrayList(
			EndItems.CRYSTALITE_HELMET.get(),
			EndItems.CRYSTALITE_CHESTPLATE.get(),
			EndItems.CRYSTALITE_ELYTRA.get(),
			EndItems.CRYSTALITE_LEGGINGS.get(),
			EndItems.CRYSTALITE_BOOTS.get()
		);
	}
	
	private boolean isStackValid(ItemStack stack) {
		return stack.getItem() instanceof CrystaliteArmor;
	}
}
