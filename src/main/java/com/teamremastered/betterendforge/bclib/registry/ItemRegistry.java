package com.teamremastered.betterendforge.bclib.registry;

import com.teamremastered.betterendforge.bclib.api.tag.NamedToolTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.items.BaseDiscItem;
import com.teamremastered.betterendforge.bclib.items.BaseDrinkItem;
import com.teamremastered.betterendforge.bclib.items.BaseSpawnEggItem;
import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseAxeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseHoeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BasePickaxeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseShearsItem;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.DispenserBlock;
import com.teamremastered.betterendforge.bclib.api.tag.NamedCommonItemTags;

public class ItemRegistry extends BaseRegistry<Item> {
	public ItemRegistry(CreativeModeTab creativeTab) {
		super(creativeTab);
	}
	public Item registerDisc(ResourceLocation itemId, int power, SoundEvent sound) {
		BaseDiscItem item = new BaseDiscItem(power, sound, makeItemSettings().stacksTo(1));

		register(itemId, item);
		return item;
	}
	
	public Item register(ResourceLocation itemId) {
		return register(itemId, new ModelProviderItem(makeItemSettings()));
	}
	
	@Override
	public Item register(ResourceLocation itemId, Item item) {
		
		registerItem(itemId, item);
		
		return item;
	}
	
	public Item registerTool(ResourceLocation itemId, Item item) {
		
		registerItem(itemId, item);
		
		if (item instanceof ShovelItem) {
			TagAPI.addItemTag(NamedToolTags.FABRIC_SHOVELS, item);
		}
		else if (item instanceof SwordItem) {
			TagAPI.addItemTag(NamedToolTags.FABRIC_SWORDS, item);
		}
		else if (item instanceof BasePickaxeItem) {
			TagAPI.addItemTag(NamedToolTags.FABRIC_PICKAXES, item);
		}
		else if (item instanceof BaseAxeItem) {
			TagAPI.addItemTag(NamedToolTags.FABRIC_AXES, item);
		}
		else if (item instanceof BaseHoeItem) {
			TagAPI.addItemTag(NamedToolTags.FABRIC_HOES, item);
		}
		else if (item instanceof BaseShearsItem) {
			TagAPI.addItemTags(item, NamedToolTags.FABRIC_SHEARS, NamedCommonItemTags.SHEARS);
			DispenserBlock.registerBehavior(item.asItem(), new ShearsDispenseItemBehavior());
		}
		
		return item;
	}
	
	public Item registerEgg(ResourceLocation itemId, EntityType<? extends Mob> type, int background, int dots) {
		SpawnEggItem item = new BaseSpawnEggItem(type, background, dots, makeItemSettings());
		
		DefaultDispenseItemBehavior behavior = new DefaultDispenseItemBehavior() {
			public ItemStack execute(BlockSource pointer, ItemStack stack) {
				Direction direction = pointer.getBlockState().getValue(DispenserBlock.FACING);
				EntityType<?> entityType = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				entityType.spawn(
					pointer.getLevel(),
					stack,
					null,
					pointer.getPos().relative(direction),
					MobSpawnType.DISPENSER,
					direction != Direction.UP,
					false
				);
				stack.shrink(1);
				return stack;
			}
		};
		DispenserBlock.registerBehavior(item, behavior);
		return register(itemId, item);
	}
	
	public Item registerFood(ResourceLocation itemId, int hunger, float saturation, MobEffectInstance... effects) {
		FoodProperties.Builder builder = new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation);
		for (MobEffectInstance effect : effects) {
			builder.effect(effect, 1F);
		}
		return registerFood(itemId, builder.build());
	}
	
	public Item registerFood(ResourceLocation itemId, FoodProperties foodComponent) {
		return register(itemId, new ModelProviderItem(makeItemSettings().food(foodComponent)));
	}
	
	public Item registerDrink(ResourceLocation itemId, FoodProperties foodComponent) {
		return register(itemId, new BaseDrinkItem(makeItemSettings().stacksTo(1).food(foodComponent)));
	}
	
	public Item registerDrink(ResourceLocation itemId, int hunger, float saturation) {
		FoodProperties.Builder builder = new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation);
		return registerDrink(itemId, builder.build());
	}
	
	@Override
	public void registerItem(ResourceLocation id, Item item) {
		if (item != null && item != Items.AIR) {
			getModItems(id.getNamespace()).add(item); //Adds the item to a list but idk why
		}
	}
	
	public Item register(ResourceLocation itemId, Item item, String category) {
			registerItem(itemId, item);
		return item;
	}
}
