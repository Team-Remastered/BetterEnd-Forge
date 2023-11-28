package com.teamremastered.betterendforge.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;
import com.teamremastered.betterendforge.registry.EndItems;

import java.util.UUID;

public class CrystaliteHelmet extends CrystaliteArmor {
	
	public CrystaliteHelmet() {
		super(EquipmentSlot.HEAD, EndItems.makeEndItemSettings().rarity(Rarity.RARE));
		UUID uuid = ARMOR_MODIFIER_UUID_PER_SLOT[EquipmentSlot.HEAD.getIndex()];
//		addAttributeModifier(
//			EndAttributes.BLINDNESS_RESISTANCE.get(),
//			new AttributeModifier(uuid, "Helmet blindness resistance", 1.0, AttributeModifier.Operation.ADDITION)
//		); //FIXME: The attribute must be applied after it is registered
	}
}
