package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.items.BaseArmorItem;
import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseAxeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseHoeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseShovelItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseSwordItem;
import com.teamremastered.betterendforge.bclib.registry.ItemRegistry;
import com.teamremastered.betterendforge.item.ArmoredElytra;
import com.teamremastered.betterendforge.item.CrystaliteBoots;
import com.teamremastered.betterendforge.item.CrystaliteChestplate;
import com.teamremastered.betterendforge.item.CrystaliteElytra;
import com.teamremastered.betterendforge.item.CrystaliteHelmet;
import com.teamremastered.betterendforge.item.CrystaliteLeggings;
import com.teamremastered.betterendforge.item.EnchantedItem;
import com.teamremastered.betterendforge.item.EndBucketItem;
import com.teamremastered.betterendforge.item.EternalCrystalItem;
import com.teamremastered.betterendforge.item.material.EndArmorMaterial;
import com.teamremastered.betterendforge.item.material.EndToolMaterial;
import com.teamremastered.betterendforge.item.tool.EndHammerItem;
import com.teamremastered.betterendforge.item.tool.EndPickaxe;
import com.teamremastered.betterendforge.tab.CreativeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class EndItems {
	private static final ItemRegistry REGISTRY = new ItemRegistry(CreativeTabs.TAB_ITEMS);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	// Materials //
	public final static RegistryObject<Item> ENDER_DUST = registerEndItem("ender_dust");
	public final static RegistryObject<Item> ENDER_SHARD = registerEndItem("ender_shard");
	public final static RegistryObject<Item> AETERNIUM_INGOT = registerEndItem("aeternium_ingot", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_FORGED_PLATE = registerEndItem("aeternium_forged_plate", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> END_LILY_LEAF = registerEndItem("end_lily_leaf");
	public final static RegistryObject<Item> END_LILY_LEAF_DRIED = registerEndItem("end_lily_leaf_dried");
	public final static RegistryObject<Item> CRYSTAL_SHARDS = registerEndItem("crystal_shards");
	public final static RegistryObject<Item> RAW_AMBER = registerEndItem("raw_amber");
	public final static RegistryObject<Item> AMBER_GEM = registerEndItem("amber_gem");
	public final static RegistryObject<Item> GLOWING_BULB = registerEndItem("glowing_bulb");
	public final static RegistryObject<Item> CRYSTALLINE_SULPHUR = registerEndItem("crystalline_sulphur");
	public final static RegistryObject<Item> HYDRALUX_PETAL = registerEndItem("hydralux_petal");
	public final static RegistryObject<Item> GELATINE = registerEndItem("gelatine");
	public static final RegistryObject<Item> ETERNAL_CRYSTAL = registerEndItem("eternal_crystal", () -> new EternalCrystalItem());
	public final static RegistryObject<Item> ENCHANTED_PETAL = registerEndItem("enchanted_petal", () -> new EnchantedItem(HYDRALUX_PETAL.get()));
	public final static RegistryObject<Item> LEATHER_STRIPE = registerEndItem("leather_stripe");
	public final static RegistryObject<Item> LEATHER_WRAPPED_STICK = registerEndItem("leather_wrapped_stick");
	public final static RegistryObject<Item> SILK_FIBER = registerEndItem("silk_fiber");
	public final static RegistryObject<Item> LUMECORN_ROD = registerEndItem("lumecorn_rod");
	public final static RegistryObject<Item> SILK_MOTH_MATRIX = registerEndItem("silk_moth_matrix");
	public final static RegistryObject<Item> ENCHANTED_MEMBRANE = registerEndItem(
		"enchanted_membrane", () -> new EnchantedItem(Items.PHANTOM_MEMBRANE));
	
	// Music Discs
	public final static RegistryObject<Item> MUSIC_DISC_STRANGE_AND_ALIEN = registerEndDisc(
		"music_disc_strange_and_alien",
		0,
		EndSounds.RECORD_STRANGE_AND_ALIEN
	);
	public final static RegistryObject<Item> MUSIC_DISC_GRASPING_AT_STARS = registerEndDisc(
		"music_disc_grasping_at_stars",
		0,
		EndSounds.RECORD_GRASPING_AT_STARS
	);
	public final static RegistryObject<Item> MUSIC_DISC_ENDSEEKER = registerEndDisc(
		"music_disc_endseeker",
		0,
		EndSounds.RECORD_ENDSEEKER
	);
	public final static RegistryObject<Item> MUSIC_DISC_EO_DRACONA = registerEndDisc(
		"music_disc_eo_dracona",
		0,
		EndSounds.RECORD_EO_DRACONA
	);
	
	// Armor //
	public static final RegistryObject<Item> AETERNIUM_HELMET = registerEndItem("aeternium_helmet", () -> new BaseArmorItem(EndArmorMaterial.AETERNIUM, EquipmentSlot.HEAD, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<Item> AETERNIUM_CHESTPLATE = registerEndItem("aeternium_chestplate", () -> new BaseArmorItem(EndArmorMaterial.AETERNIUM, EquipmentSlot.CHEST, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<Item> AETERNIUM_LEGGINGS = registerEndItem("aeternium_leggings", () -> new BaseArmorItem(EndArmorMaterial.AETERNIUM, EquipmentSlot.LEGS, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<Item> AETERNIUM_BOOTS = registerEndItem("aeternium_boots", () -> new BaseArmorItem(EndArmorMaterial.AETERNIUM, EquipmentSlot.FEET, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<Item> CRYSTALITE_HELMET = registerEndItem("crystalite_helmet", () -> new CrystaliteHelmet());
	public static final RegistryObject<Item> CRYSTALITE_CHESTPLATE = registerEndItem("crystalite_chestplate", () -> new CrystaliteChestplate());
	public static final RegistryObject<Item> CRYSTALITE_LEGGINGS = registerEndItem("crystalite_leggings", () -> new CrystaliteLeggings());
	public static final RegistryObject<Item> CRYSTALITE_BOOTS = registerEndItem("crystalite_boots", () -> new CrystaliteBoots());
	public static final RegistryObject<Item> ARMORED_ELYTRA = registerEndItem("elytra_armored", () -> new ArmoredElytra("elytra_armored", EndArmorMaterial.AETERNIUM, Items.PHANTOM_MEMBRANE, 900, 0.975D, true));
	public static final RegistryObject<Item> CRYSTALITE_ELYTRA = registerEndItem("elytra_crystalite", () -> new CrystaliteElytra(650, 0.99D));
	
	// Tools //
	public static final RegistryObject<BaseShovelItem> AETERNIUM_SHOVEL = registerEndTool("aeternium_shovel", () -> new BaseShovelItem(EndToolMaterial.AETERNIUM, 1.5F, -3.0F, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<BaseSwordItem> AETERNIUM_SWORD = registerEndTool("aeternium_sword", () -> new BaseSwordItem(EndToolMaterial.AETERNIUM, 3, -2.4F, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<EndPickaxe> AETERNIUM_PICKAXE = registerEndTool("aeternium_pickaxe", () -> new EndPickaxe(EndToolMaterial.AETERNIUM, 1, -2.8F, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<BaseAxeItem> AETERNIUM_AXE = registerEndTool("aeternium_axe", () -> new BaseAxeItem(EndToolMaterial.AETERNIUM, 5.0F, -3.0F, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<BaseHoeItem> AETERNIUM_HOE = registerEndTool("aeternium_hoe", () -> new BaseHoeItem(EndToolMaterial.AETERNIUM, -3, 0.0F, makeEndItemSettings().fireResistant()));
	public static final RegistryObject<EndHammerItem> AETERNIUM_HAMMER = registerEndTool("aeternium_hammer", () -> new EndHammerItem(EndToolMaterial.AETERNIUM, 6.0F, -3.0F, 0.3D, makeEndItemSettings().fireResistant()));
	
	// Toolparts //
	public final static RegistryObject<Item> AETERNIUM_SHOVEL_HEAD = registerEndItem("aeternium_shovel_head", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_PICKAXE_HEAD = registerEndItem("aeternium_pickaxe_head", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_AXE_HEAD = registerEndItem("aeternium_axe_head", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_HOE_HEAD = registerEndItem("aeternium_hoe_head", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_HAMMER_HEAD = registerEndItem("aeternium_hammer_head", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_SWORD_BLADE = registerEndItem("aeternium_sword_blade", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	public final static RegistryObject<Item> AETERNIUM_SWORD_HANDLE = registerEndItem("aeternium_sword_handle", () -> new ModelProviderItem(makeEndItemSettings().fireResistant()));
	
	// ITEM_HAMMERS //
	public static final RegistryObject<EndHammerItem> IRON_HAMMER = registerEndTool("iron_hammer", () -> new EndHammerItem(Tiers.IRON, 5.0F, -3.2F, 0.2D, makeEndItemSettings()));
	public static final RegistryObject<EndHammerItem> GOLDEN_HAMMER = registerEndTool("golden_hammer", () -> new EndHammerItem(Tiers.GOLD, 4.5F, -3.4F, 0.3D, makeEndItemSettings()));
	public static final RegistryObject<EndHammerItem> DIAMOND_HAMMER = registerEndTool("diamond_hammer", () -> new EndHammerItem(Tiers.DIAMOND, 5.5F, -3.1F, 0.2D, makeEndItemSettings()));
	public static final RegistryObject<EndHammerItem> NETHERITE_HAMMER = registerEndTool("netherite_hammer", () -> new EndHammerItem(Tiers.NETHERITE, 5.0F, -3.0F, 0.2D, makeEndItemSettings().fireResistant()));
	
	// Food //
	public final static RegistryObject<Item> SHADOW_BERRY_RAW = registerEndFood("shadow_berry_raw", 4, 0.5F);
	public final static RegistryObject<Item> SHADOW_BERRY_COOKED = registerEndFood("shadow_berry_cooked", 6, 0.7F);
	public final static RegistryObject<Item> END_FISH_RAW = registerEndFood("end_fish_raw", Foods.SALMON);
	public final static RegistryObject<Item> END_FISH_COOKED = registerEndFood("end_fish_cooked", Foods.COOKED_SALMON);
	public final static RegistryObject<Item> BUCKET_END_FISH = registerEndItem("bucket_end_fish", () -> new EndBucketItem(EndEntities.END_FISH));
	public final static RegistryObject<Item> BUCKET_CUBOZOA = registerEndItem("bucket_cubozoa", () -> new EndBucketItem(EndEntities.CUBOZOA));
	public final static RegistryObject<Item> SWEET_BERRY_JELLY = registerEndFood("sweet_berry_jelly", 8, 0.7F);
	public final static RegistryObject<Item> SHADOW_BERRY_JELLY = registerEndFood("shadow_berry_jelly", 6, 0.8F, new MobEffectInstance(MobEffects.NIGHT_VISION, 400));
	public final static RegistryObject<Item> BLOSSOM_BERRY_JELLY = registerEndFood("blossom_berry_jelly", 8, 0.7F);
	public final static RegistryObject<Item> BLOSSOM_BERRY = registerEndFood("blossom_berry", Foods.APPLE);
	public final static RegistryObject<Item> AMBER_ROOT_RAW = registerEndFood("amber_root_raw", 2, 0.8F);
	public final static RegistryObject<Item> CHORUS_MUSHROOM_RAW = registerEndFood("chorus_mushroom_raw", 3, 0.5F);
	public final static RegistryObject<Item> CHORUS_MUSHROOM_COOKED = registerEndFood("chorus_mushroom_cooked", Foods.MUSHROOM_STEW);
	public final static RegistryObject<Item> BOLUX_MUSHROOM_COOKED = registerEndFood("bolux_mushroom_cooked", Foods.MUSHROOM_STEW);
	public final static RegistryObject<Item> CAVE_PUMPKIN_PIE = registerEndFood("cave_pumpkin_pie", Foods.PUMPKIN_PIE);
	
	// Drinks //
	public final static RegistryObject<Item> UMBRELLA_CLUSTER_JUICE = registerEndDrink("umbrella_cluster_juice", 5, 0.7F);
	
	public static List<Item> getModItems() {
		return REGISTRY.getModItems(BetterEndForge.MOD_ID);
	}

	public static RegistryObject<Item> registerEndDisc(String name, int power, java.util.function.Supplier<SoundEvent> sound) {
	//	getItemRegistry().registerDisc(BetterEndForge.makeID(name), power, sound);
		return ITEMS.register(name, () -> new RecordItem(power, sound, makeEndItemSettings()));
	}

	public static RegistryObject<Item> registerEndItem(String name) {

		return ITEMS.register(name, () -> new Item(makeEndItemSettings()));
	}

	public static <I extends Item> RegistryObject<I> registerEndItem(String name, final Supplier<? extends I> item) {

		return ITEMS.register(name, item);
	}

	public static <T extends TieredItem> RegistryObject<T> registerEndTool(String name, final Supplier<? extends T> item) {

		return ITEMS.register(name, item);
	}
	
	public static Item registerEndEgg(String name, EntityType<? extends Mob> type, int background, int dots) {
		return getItemRegistry().registerEgg(BetterEndForge.makeID(name), type, background, dots);
	}

	public static RegistryObject<Item> registerEndFood(String name, int hunger, float saturation, MobEffectInstance... effects) {
		FoodProperties.Builder foodProperties = new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation);
		for (MobEffectInstance effect : effects) {
			foodProperties.effect(effect, 1F);
		}
		return ITEMS.register(name, () -> new Item(makeEndItemSettings().food(foodProperties.build())));
	}

	public static RegistryObject<Item> registerEndFood(String name, FoodProperties foodComponent) {
		return ITEMS.register(name, () -> new Item(makeEndItemSettings().food(foodComponent)));
	}

	public static RegistryObject<Item> registerEndDrink(String name, int hunger, float saturation) {
		return ITEMS.register(name, () -> new Item(getItemRegistry().makeItemSettings().food(new FoodProperties.Builder().nutrition(hunger).saturationMod(saturation).build())));
	}
	
	public static Item.Properties makeEndItemSettings() {
		return getItemRegistry().makeItemSettings();
	}
	
	@NotNull
	public static ItemRegistry getItemRegistry() {
		return REGISTRY;
	}
}
