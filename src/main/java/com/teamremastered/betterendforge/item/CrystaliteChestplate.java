package com.teamremastered.betterendforge.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import com.teamremastered.betterendforge.registry.EndStatusEffects;
import com.teamremastered.betterendforge.interfaces.MobEffectApplier;
import com.teamremastered.betterendforge.registry.EndItems;

import java.util.List;

public class CrystaliteChestplate extends CrystaliteArmor implements MobEffectApplier {
	
	public CrystaliteChestplate() {
		super(EquipmentSlot.CHEST, EndItems.makeEndItemSettings().rarity(Rarity.RARE));
	}
	
	@Override
	public void applyEffect(LivingEntity owner) {
		owner.addEffect(new MobEffectInstance(EndStatusEffects.CRYSTALITE_DIG_SPEED));
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> lines, TooltipFlag tooltip) {
		super.appendHoverText(stack, level, lines, tooltip);
		lines.add(1, TextComponent.EMPTY);
		lines.add(2, CHEST_DESC);
	}
}
