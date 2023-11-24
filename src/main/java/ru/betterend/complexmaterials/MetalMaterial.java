package ru.betterend.complexmaterials;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedCommonBlockTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.blocks.BaseBlock;
import ru.betterend.bclib.blocks.BaseChainBlock;
import ru.betterend.bclib.blocks.BaseDoorBlock;
import ru.betterend.bclib.blocks.BaseMetalBarsBlock;
import ru.betterend.bclib.blocks.BaseOreBlock;
import ru.betterend.bclib.blocks.BaseSlabBlock;
import ru.betterend.bclib.blocks.BaseStairsBlock;
import ru.betterend.bclib.blocks.BaseTrapdoorBlock;
import ru.betterend.bclib.util.BlocksHelper;
import ru.betterend.bclib.blocks.WoodenPressurePlateBlock;
import ru.betterend.bclib.items.ModelProviderItem;
import ru.betterend.bclib.items.tool.BaseAxeItem;
import ru.betterend.bclib.items.tool.BaseHoeItem;
import ru.betterend.bclib.items.tool.BaseShovelItem;
import ru.betterend.bclib.items.tool.BaseSwordItem;
import ru.betterend.bclib.recipes.AnvilRecipe;
import ru.betterend.bclib.recipes.FurnaceRecipe;
import ru.betterend.bclib.recipes.GridRecipe;
import ru.betterend.bclib.recipes.SmithingTableRecipe;
import ru.betterend.BetterEndForge;
import ru.betterend.blocks.BulbVineLanternBlock;
import ru.betterend.blocks.BulbVineLanternColoredBlock;
import ru.betterend.blocks.ChandelierBlock;
import ru.betterend.blocks.basis.EndAnvilBlock;
import ru.betterend.item.EndArmorItem;
import ru.betterend.item.tool.EndHammerItem;
import ru.betterend.item.tool.EndPickaxe;
import ru.betterend.recipe.builders.AlloyingRecipe;
import ru.betterend.registry.EndBlocks;
import ru.betterend.registry.EndItems;

public class MetalMaterial {
	public final RegistryObject<Block> ore;
	public final RegistryObject<Block> block;
	public final RegistryObject<Block> tile;
	public final RegistryObject<Block> bars;
	public final RegistryObject<Block> pressurePlate;
	public final RegistryObject<Block> door;
	public final RegistryObject<Block> trapdoor;
	public final RegistryObject<Block> chain;
	public final RegistryObject<Block> stairs;
	public final RegistryObject<Block> slab;

	public final RegistryObject<Block> chandelier;
	public final RegistryObject<Block> bulb_lantern;
	public final ColoredMaterial bulb_lantern_colored;

	public final RegistryObject<Block> anvilBlock;

	public final RegistryObject<Item> rawOre;
	public final RegistryObject<Item> nugget;
	public final RegistryObject<Item> ingot;

	public final RegistryObject<Item> shovelHead;
	public final RegistryObject<Item> pickaxeHead;
	public final RegistryObject<Item> axeHead;
	public final RegistryObject<Item> hoeHead;
	public final RegistryObject<Item> swordBlade;
	public final RegistryObject<Item> swordHandle;

	public final RegistryObject<BaseShovelItem> shovel;
	public final RegistryObject<BaseSwordItem> sword;
	public final RegistryObject<EndPickaxe> pickaxe;
	public final RegistryObject<BaseAxeItem> axe;
	public final RegistryObject<BaseHoeItem> hoe;
	public final RegistryObject<EndHammerItem> hammer;

	public final RegistryObject<Item> forgedPlate;
	public final RegistryObject<Item> helmet;
	public final RegistryObject<Item> chestplate;
	public final RegistryObject<Item> leggings;
	public final RegistryObject<Item> boots;

	public final TagKey<Item> alloyingOre;

	public static MetalMaterial makeNormal(String name, MaterialColor color, Tier material, ArmorMaterial armor) {
		return new MetalMaterial(
				name,
				true,
				BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).color(color),
				EndItems.makeEndItemSettings(),
				material,
				armor
		);
	}

	public static MetalMaterial makeNormal(String name, MaterialColor color, float hardness, float resistance, Tier material, ArmorMaterial armor) {
		return new MetalMaterial(
				name,
				true,
				BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
								   .color(color)
								   .destroyTime(hardness)
								   .explosionResistance(resistance),
				EndItems.makeEndItemSettings(),
				material,
				armor
		);
	}

	public static MetalMaterial makeOreless(String name, MaterialColor color, Tier material, ArmorMaterial armor) {
		return new MetalMaterial(
				name,
				false,
				BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).color(color),
				EndItems.makeEndItemSettings(),
				material,
				armor
		);
	}

	public static MetalMaterial makeOreless(String name, MaterialColor color, float hardness, float resistance, Tier material, ArmorMaterial armor) {
		return new MetalMaterial(
				name,
				false,
				BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
								   .color(color)
								   .destroyTime(hardness)
								   .explosionResistance(resistance),
				EndItems.makeEndItemSettings(),
				material,
				armor
		);
	}

	private MetalMaterial(String name, boolean hasOre, BlockBehaviour.Properties settings, Properties itemSettings, Tier material, ArmorMaterial armor) {
		BlockBehaviour.Properties lanternProperties = BlockBehaviour.Properties.copy(new BlockBehaviour(settings)) //FIXME: Can't pass settings as a parameter idk why
																		 .destroyTime(1)
																		 .explosionResistance(1)
																		 .lightLevel(BlocksHelper.getLightValue(15))
																		 .sound(SoundType.LANTERN);
		final int level = material.getLevel();

		rawOre = hasOre ? EndItems.registerEndItem(name + "_raw", new ModelProviderItem(itemSettings)) : null;
		ore = hasOre ? EndBlocks.registerBlock(name + "_ore", new BaseOreBlock(()->rawOre.get(), 1, 3, 1)) : null;
		alloyingOre = hasOre ? TagAPI.makeItemTag(BetterEndForge.MOD_ID, name + "_alloying") : null;
		if (hasOre) {
			TagAPI.addItemTag(alloyingOre, ore.get(), rawOre.get());
		}

		block = EndBlocks.registerBlock(name + "_block", new BaseBlock(settings));
		tile = EndBlocks.registerBlock(name + "_tile", new BaseBlock(settings));
		stairs = EndBlocks.registerBlock(name + "_stairs", new BaseStairsBlock(tile.get()));
		slab = EndBlocks.registerBlock(name + "_slab", new BaseSlabBlock(tile.get()));
		door = EndBlocks.registerBlock(name + "_door", new BaseDoorBlock(block.get()));
		trapdoor = EndBlocks.registerBlock(name + "_trapdoor", new BaseTrapdoorBlock(block.get()));
		bars = EndBlocks.registerBlock(name + "_bars", new BaseMetalBarsBlock(block.get()));
		chain = EndBlocks.registerBlock(name + "_chain", new BaseChainBlock(block.get().defaultMaterialColor()));
		pressurePlate = EndBlocks.registerBlock(name + "_plate", new WoodenPressurePlateBlock(block.get()));

		chandelier = EndBlocks.registerBlock(name + "_chandelier", new ChandelierBlock(block.get()));
		bulb_lantern = EndBlocks.registerBlock(name + "_bulb_lantern", new BulbVineLanternBlock(lanternProperties));
		bulb_lantern_colored = new ColoredMaterial(BulbVineLanternColoredBlock::new, bulb_lantern.get(), false);

		nugget = EndItems.registerEndItem(name + "_nugget", new ModelProviderItem(itemSettings));
		ingot = EndItems.registerEndItem(name + "_ingot", new ModelProviderItem(itemSettings));

		shovelHead = EndItems.registerEndItem(name + "_shovel_head");
		pickaxeHead = EndItems.registerEndItem(name + "_pickaxe_head");
		axeHead = EndItems.registerEndItem(name + "_axe_head");
		hoeHead = EndItems.registerEndItem(name + "_hoe_head");
		swordBlade = EndItems.registerEndItem(name + "_sword_blade");
		swordHandle = EndItems.registerEndItem(name + "_sword_handle");

		shovel = EndItems.registerEndTool(name + "_shovel", new BaseShovelItem(material, 1.5F, -3.0F, itemSettings));
		sword = EndItems.registerEndTool(name + "_sword", new BaseSwordItem(material, 3, -2.4F, itemSettings));
		pickaxe = EndItems.registerEndTool(name + "_pickaxe", new EndPickaxe(material, 1, -2.8F, itemSettings));
		axe = EndItems.registerEndTool(name + "_axe", new BaseAxeItem(material, 6.0F, -3.0F, itemSettings));
		hoe = EndItems.registerEndTool(name + "_hoe", new BaseHoeItem(material, -3, 0.0F, itemSettings));
		hammer = EndItems.registerEndTool(
				name + "_hammer",
				new EndHammerItem(material, 5.0F, -3.2F, 0.3D, itemSettings)
		);

		forgedPlate = EndItems.registerEndItem(name + "_forged_plate");
		helmet = EndItems.registerEndItem(name + "_helmet", new EndArmorItem(armor, EquipmentSlot.HEAD, itemSettings));
		chestplate = EndItems.registerEndItem(
				name + "_chestplate",
				new EndArmorItem(armor, EquipmentSlot.CHEST, itemSettings)
		);
		leggings = EndItems.registerEndItem(
				name + "_leggings",
				new EndArmorItem(armor, EquipmentSlot.LEGS, itemSettings)
		);
		boots = EndItems.registerEndItem(name + "_boots", new EndArmorItem(armor, EquipmentSlot.FEET, itemSettings));

		anvilBlock = EndBlocks.registerBlock(
				name + "_anvil",
				new EndAnvilBlock(this, block.get().defaultMaterialColor(), level)
		);

		if (hasOre) {
			FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_furnace_ore", ore.get(), ingot.get())
						 .checkConfig(Configs.RECIPE_CONFIG)
						 .setGroup("end_ingot")
						 .buildWithBlasting();
			FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_furnace_raw", rawOre.get(), ingot.get())
						 .checkConfig(Configs.RECIPE_CONFIG)
						 .setGroup("end_ingot")
						 .buildWithBlasting();
			AlloyingRecipe.Builder.create(name + "_ingot_alloy")
								  .setInput(alloyingOre, alloyingOre)
								  .setOutput(ingot.get(), 3)
								  .setExpiriense(2.1F)
								  .build();
		}

		// Basic recipes
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_from_nuggets", ingot.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("###", "###", "###")
				  .addMaterial('#', nugget.get())
				  .setGroup("end_metal_ingots_nug")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_nuggets_from_ingot", nugget.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(9)
				  .setList("#")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_nuggets_ing")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_block", block.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("###", "###", "###")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_blocks")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_from_block", ingot.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(9)
				  .setList("#")
				  .addMaterial('#', block.get())
				  .setGroup("end_metal_ingots")
				  .build();

		// Block recipes
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_tile", tile.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(4)
				  .setShape("##", "##")
				  .addMaterial('#', block.get())
				  .setGroup("end_metal_tiles")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bars", bars.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(16)
				  .setShape("###", "###")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_bars")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_pressure_plate", pressurePlate.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("##")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_plates")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_door", door.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(3)
				  .setShape("##", "##", "##")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_doors")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_trapdoor", trapdoor.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("##", "##")
				  .addMaterial('#', ingot.get())
				  .setGroup("end_metal_trapdoors")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_stairs", stairs.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(4)
				  .setShape("#  ", "## ", "###")
				  .addMaterial('#', block.get(), tile.get())
				  .setGroup("end_metal_stairs")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_slab", slab.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setOutputCount(6)
				  .setShape("###")
				  .addMaterial('#', block.get(), tile.get())
				  .setGroup("end_metal_slabs")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_chain", chain.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("N", "#", "N")
				  .addMaterial('#', ingot.get())
				  .addMaterial('N', nugget.get())
				  .setGroup("end_metal_chain")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_anvil", anvilBlock.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("###", " I ", "III")
				  .addMaterial('#', block.get(), tile.get())
				  .addMaterial('I', ingot.get())
				  .setGroup("end_metal_anvil")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_bulb_lantern", bulb_lantern.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("C", "I", "#")
				  .addMaterial('C', chain.get())
				  .addMaterial('I', ingot.get())
				  .addMaterial('#', EndItems.GLOWING_BULB.get())
				  .build();

		GridRecipe.make(BetterEndForge.MOD_ID, name + "_chandelier", chandelier.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("I#I", " # ")
				  .addMaterial('#', ingot.get())
				  .addMaterial('I', EndItems.LUMECORN_ROD.get())
				  .setGroup("end_metal_chandelier")
				  .build();

		// Tools & armor into nuggets
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_axe_nugget", axe.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_hoe_nugget", hoe.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_pickaxe_nugget", pickaxe.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_sword_nugget", sword.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_hammer_nugget", hammer.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_helmet_nugget", helmet.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_chestplate_nugget", chestplate.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_leggings_nugget", leggings.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();
		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_boots_nugget", boots.get(), nugget.get())
					 .checkConfig(Configs.RECIPE_CONFIG)
					 .setGroup("end_nugget")
					 .buildWithBlasting();

		// Tool parts from ingots
		AnvilRecipe.create(name + "_shovel_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setOutput(shovelHead.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();
		AnvilRecipe.create(name + "_pickaxe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setInputCount(3)
				   .setOutput(pickaxeHead.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();
		AnvilRecipe.create(name + "_axe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setInputCount(3)
				   .setOutput(axeHead.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();
		AnvilRecipe.create(name + "_hoe_head")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setInputCount(2)
				   .setOutput(hoeHead.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();
		AnvilRecipe.create(name + "_sword_blade")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setOutput(swordBlade.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();
		AnvilRecipe.create(name + "_forged_plate")
				   .checkConfig(Configs.RECIPE_CONFIG)
				   .setInput(ingot.get())
				   .setOutput(forgedPlate.get())
				   .setAnvilLevel(level)
				   .setToolLevel(level)
				   .setDamage(level)
				   .build();

		// Tools from parts
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_hammer")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(hammer.get())
						   .setBase(block.get())
						   .setAddition(Items.STICK)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_axe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(axe.get())
						   .setBase(axeHead.get())
						   .setAddition(Items.STICK)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_pickaxe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(pickaxe.get())
						   .setBase(pickaxeHead.get())
						   .setAddition(Items.STICK)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_hoe")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(hoe.get())
						   .setBase(hoeHead.get())
						   .setAddition(Items.STICK)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_sword_handle")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(swordHandle.get())
						   .setBase(ingot.get())
						   .setAddition(Items.STICK)
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_sword")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(sword.get())
						   .setBase(swordBlade.get())
						   .setAddition(swordHandle.get())
						   .build();
		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_shovel")
						   .checkConfig(Configs.RECIPE_CONFIG)
						   .setResult(shovel.get())
						   .setBase(shovelHead.get())
						   .setAddition(Items.STICK)
						   .build();

		// Armor crafting
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_helmet", helmet.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("###", "# #")
				  .addMaterial('#', forgedPlate.get())
				  .setGroup("end_metal_helmets")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_chestplate", chestplate.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("# #", "###", "###")
				  .addMaterial('#', forgedPlate.get())
				  .setGroup("end_metal_chestplates")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_leggings", leggings.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("###", "# #", "# #")
				  .addMaterial('#', forgedPlate.get())
				  .setGroup("end_metal_leggings")
				  .build();
		GridRecipe.make(BetterEndForge.MOD_ID, name + "_boots", boots.get())
				  .checkConfig(Configs.RECIPE_CONFIG)
				  .setShape("# #", "# #")
				  .addMaterial('#', forgedPlate.get())
				  .setGroup("end_metal_boots")
				  .build();

		TagAPI.addBlockTag(NamedBlockTags.ANVIL, anvilBlock.get());
		TagAPI.addBlockTag(NamedBlockTags.BEACON_BASE_BLOCKS, block.get());
		TagAPI.addItemTag(NamedItemTags.BEACON_PAYMENT_ITEMS, ingot.get());
		TagAPI.addBlockTag(NamedCommonBlockTags.DRAGON_IMMUNE, ore.get(), bars.get());
	}
}