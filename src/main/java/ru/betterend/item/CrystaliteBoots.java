package ru.betterend.item;

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
import ru.betterend.registry.EndStatusEffects;
import ru.betterend.interfaces.MobEffectApplier;
import ru.betterend.registry.EndItems;

import java.util.List;

public class CrystaliteBoots extends CrystaliteArmor implements MobEffectApplier {
	
	public CrystaliteBoots() {
		super(EquipmentSlot.FEET, EndItems.makeEndItemSettings().rarity(Rarity.RARE));
	}
	
	@Override
	public void applyEffect(LivingEntity owner) {
		if ((owner.tickCount & 63) == 0) {
			owner.addEffect(new MobEffectInstance(EndStatusEffects.CRYSTALITE_MOVE_SPEED));
		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> lines, TooltipFlag tooltip) {
		super.appendHoverText(stack, level, lines, tooltip);
		lines.add(1, TextComponent.EMPTY);
		lines.add(2, BOOTS_DESC);
	}
}
