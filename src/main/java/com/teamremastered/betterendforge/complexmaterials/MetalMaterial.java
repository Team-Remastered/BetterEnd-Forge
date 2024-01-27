package com.teamremastered.betterendforge.complexmaterials;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.api.tag.NamedBlockTags;
import com.teamremastered.betterendforge.bclib.api.tag.TagAPI;
import com.teamremastered.betterendforge.bclib.blocks.BaseBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseChainBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseDoorBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseMetalBarsBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseOreBlock;
import com.teamremastered.betterendforge.bclib.blocks.BasePressurePlateBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseSlabBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseStairsBlock;
import com.teamremastered.betterendforge.bclib.blocks.BaseTrapdoorBlock;
import com.teamremastered.betterendforge.bclib.blocks.WoodenPressurePlateBlock;
import com.teamremastered.betterendforge.bclib.items.ModelProviderItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseAxeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseHoeItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseShovelItem;
import com.teamremastered.betterendforge.bclib.items.tool.BaseSwordItem;
import com.teamremastered.betterendforge.bclib.recipes.BCLRecipeProvider;
import com.teamremastered.betterendforge.bclib.recipes.RecipeSupplier;
import com.teamremastered.betterendforge.bclib.util.BlocksHelper;
import com.teamremastered.betterendforge.blocks.AeterniumAnvil;
import com.teamremastered.betterendforge.blocks.BulbVineLanternBlock;
import com.teamremastered.betterendforge.blocks.BulbVineLanternColoredBlock;
import com.teamremastered.betterendforge.blocks.ChandelierBlock;
import com.teamremastered.betterendforge.blocks.basis.EndAnvilBlock;
import com.teamremastered.betterendforge.item.EndArmorItem;
import com.teamremastered.betterendforge.item.tool.EndHammerItem;
import com.teamremastered.betterendforge.item.tool.EndPickaxe;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;


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
        BlockBehaviour.Properties lanternProperties = settings
                .destroyTime(1)
                .explosionResistance(1)
                .lightLevel(BlocksHelper.getLightValue(15))
                .sound(SoundType.LANTERN);
        final int level = material.getLevel();

        rawOre = hasOre ? EndItems.registerEndItem(name + "_raw", () -> new ModelProviderItem(itemSettings)) : null;
        ore = hasOre ? EndBlocks.registerBlock(name + "_ore", () -> new BaseOreBlock(() -> rawOre.get(), 1, 3, 1)) : null;
        alloyingOre = hasOre ? TagAPI.makeItemTag(BetterEndForge.MOD_ID, name + "_alloying") : null;

        block = EndBlocks.registerBlock(name + "_block", () -> new BaseBlock(settings));
        tile = EndBlocks.registerBlock(name + "_tile", () -> new BaseBlock(settings));
        stairs = EndBlocks.registerBlock(name + "_stairs", () -> new BaseStairsBlock(tile.get()));
        slab = EndBlocks.registerBlock(name + "_slab", () -> new BaseSlabBlock(tile.get()));
        door = EndBlocks.registerBlock(name + "_door", () -> new BaseDoorBlock(block.get()));
        trapdoor = EndBlocks.registerBlock(name + "_trapdoor", () -> new BaseTrapdoorBlock(block.get()));
        bars = EndBlocks.registerBlock(name + "_bars", () -> new BaseMetalBarsBlock(block.get()));
        chain = EndBlocks.registerBlock(name + "_chain", () -> new BaseChainBlock(block.get().defaultMaterialColor()));
        pressurePlate = EndBlocks.registerBlock(name + "_plate", () -> new BasePressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS ,block.get()));

        chandelier = EndBlocks.registerBlock(name + "_chandelier", () -> new ChandelierBlock(block.get()));
        bulb_lantern = EndBlocks.registerBlock(name + "_bulb_lantern", () -> new BulbVineLanternBlock(lanternProperties));
        bulb_lantern_colored = new ColoredMaterial(bulb_lantern , name + "_bulb_lantern", false);

        nugget = EndItems.registerEndItem(name + "_nugget", () -> new ModelProviderItem(itemSettings));
        ingot = EndItems.registerEndItem(name + "_ingot", () -> new ModelProviderItem(itemSettings));

        shovelHead = EndItems.registerEndItem(name + "_shovel_head");
        pickaxeHead = EndItems.registerEndItem(name + "_pickaxe_head");
        axeHead = EndItems.registerEndItem(name + "_axe_head");
        hoeHead = EndItems.registerEndItem(name + "_hoe_head");
        swordBlade = EndItems.registerEndItem(name + "_sword_blade");
        swordHandle = EndItems.registerEndItem(name + "_sword_handle");

        shovel = EndItems.registerEndTool(name + "_shovel", () -> new BaseShovelItem(material, 1.5F, -3.0F, itemSettings));
        sword = EndItems.registerEndTool(name + "_sword", () -> new BaseSwordItem(material, 3, -2.4F, itemSettings));
        pickaxe = EndItems.registerEndTool(name + "_pickaxe", () -> new EndPickaxe(material, 1, -2.8F, itemSettings));
        axe = EndItems.registerEndTool(name + "_axe", () -> new BaseAxeItem(material, 6.0F, -3.0F, itemSettings));
        hoe = EndItems.registerEndTool(name + "_hoe", () -> new BaseHoeItem(material, -3, 0.0F, itemSettings));
        hammer = EndItems.registerEndTool(
                name + "_hammer",
                () -> new EndHammerItem(material, 5.0F, -3.2F, 0.3D, itemSettings)
        );

        forgedPlate = EndItems.registerEndItem(name + "_forged_plate");
        helmet = EndItems.registerEndItem(name + "_helmet", () -> new EndArmorItem(armor, EquipmentSlot.HEAD, itemSettings));
        chestplate = EndItems.registerEndItem(
                name + "_chestplate",
                () -> new EndArmorItem(armor, EquipmentSlot.CHEST, itemSettings)
        );
        leggings = EndItems.registerEndItem(
                name + "_leggings",
                () -> new EndArmorItem(armor, EquipmentSlot.LEGS, itemSettings)
        );
        boots = EndItems.registerEndItem(name + "_boots", () -> new EndArmorItem(armor, EquipmentSlot.FEET, itemSettings));

        anvilBlock = EndBlocks.registerBlock(
                name + "_anvil",
                () -> new EndAnvilBlock(this, block.get().defaultMaterialColor(), level)
        );

//		if (hasOre) {
//			FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_furnace_ore", ore.get(), ingot.get())
//
//						 .setGroup("end_ingot")
//						 .buildWithBlasting();
//			FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_ingot_furnace_raw", rawOre.get(), ingot.get())
//
//						 .setGroup("end_ingot")
//						 .buildWithBlasting();
//			AlloyingRecipe.Builder.create(name + "_ingot_alloy")
//								  .setInput(alloyingOre, alloyingOre)
//								  .setOutput(ingot.get(), 3)
//								  .setExpiriense(2.1F)
//								  .build();
//		}

        // Basic recipes


        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_ingot_from_nuggets")
                .setOutput(ingot::get)
                .setShape("###", "###", "###")
                .addInput('#', nugget::get)
                .setGroup("end_metal_ingots_nug")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_nuggets_from_ingot")
                .setOutput(nugget::get, 9)
                .setShapeless("#")
                .addInput('#', ingot::get)
                .setGroup("end_metal_nuggets_ing")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_block")
                .setOutput(block::get)
                .setShape("###", "###", "###")
                .addInput('#', ingot::get)
                .setGroup("end_metal_blocks")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_ingot_from_block")
                .setOutput(ingot::get, 9)
                .setShapeless("#")
                .addInput('#', block::get)
                .setGroup("end_metal_ingots")
        );


        // Block recipes
        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_tile")
                .setOutput(tile::get, 4)
                .setShape("##", "##")
                .addInput('#', block::get)
                .setGroup("end_metal_tiles")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_bars")
                .setOutput(bars::get, 16)
                .setShape("###", "###")
                .addInput('#', ingot::get)
                .setGroup("end_metal_bars")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_pressure_plate")
                .setOutput(pressurePlate::get)
                .setShape("##")
                .addInput('#', ingot::get)
                .setGroup("end_metal_plates")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_door")
                .setOutput(door::get, 3)
                .setShape("##", "##", "##")
                .addInput('#', ingot::get)
                .setGroup("end_metal_doors")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_trapdoor")
                .setOutput(trapdoor::get)
                .setShape("##", "##")
                .addInput('#', ingot::get)
                .setGroup("end_metal_trapdoors")
        );

//		BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_stairs")
//				  .setOutput(stairs::get, 4)
//				  .setShape("#  ", "## ", "###")
//				   .addInput('#', block.get(), tile::get)
//				  .setGroup("end_metal_stairs")
//        );
//
//		BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_slab")
//				  .setOutput(slab::get, 6)
//				  .setShape("###")
//				   .addInput('#', block.get(), tile::get)
//				  .setGroup("end_metal_slabs")
//        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_chain")
                .setOutput(chain::get)
                .setShape("N", "#", "N")
                .addInput('#', ingot::get)
                .addInput('N', nugget::get)
                .setGroup("end_metal_chain")
        );

//		BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_anvil")
//                        .setOutput(anvilBlock::get)
//				  .setShape("###", " I ", "III")
//				   .addInput('#', block.get(), tile::get)
//				   .addInput('I', ingot::get)
//				  .setGroup("end_metal_anvil")
//        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_bulb_lantern")
                .setOutput(bulb_lantern::get)
                .setShape("C", "I", "#")
                .addInput('C', chain::get)
                .addInput('I', ingot::get)
                .addInput('#', EndItems.GLOWING_BULB::get)
        );


        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_chandelier")
                .setOutput(chandelier::get)
                .setShape("I#I", " # ")
                .addInput('#', ingot::get)
                .addInput('I', EndItems.LUMECORN_ROD::get)
                .setGroup("end_metal_chandelier")
        );

//
//		// Tools & armor into nuggets
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_axe_nugget", axe.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_hoe_nugget", hoe.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_pickaxe_nugget", pickaxe.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_sword_nugget", sword.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_hammer_nugget", hammer.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_helmet_nugget", helmet.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_chestplate_nugget", chestplate.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_leggings_nugget", leggings.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//		FurnaceRecipe.make(BetterEndForge.MOD_ID, name + "_boots_nugget", boots.get(), nugget.get())
//
//					 .setGroup("end_nugget")
//					 .buildWithBlasting();
//
//		// Tool parts from ingots
//		AnvilRecipe.create(name + "_shovel_head")
//
//				   .setInput(ingot.get())
//				   .setOutput(shovelHead.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//		AnvilRecipe.create(name + "_pickaxe_head")
//
//				   .setInput(ingot.get())
//				   .setInputCount(3)
//				   .setOutput(pickaxeHead.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//		AnvilRecipe.create(name + "_axe_head")
//
//				   .setInput(ingot.get())
//				   .setInputCount(3)
//				   .setOutput(axeHead.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//		AnvilRecipe.create(name + "_hoe_head")
//
//				   .setInput(ingot.get())
//				   .setInputCount(2)
//				   .setOutput(hoeHead.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//		AnvilRecipe.create(name + "_sword_blade")
//
//				   .setInput(ingot.get())
//				   .setOutput(swordBlade.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//		AnvilRecipe.create(name + "_forged_plate")
//
//				   .setInput(ingot.get())
//				   .setOutput(forgedPlate.get())
//				   .setAnvilLevel(level)
//				   .setToolLevel(level)
//				   .setDamage(level)
//				   .build();
//
//		// Tools from parts
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_hammer")
//
//						   .setResult(hammer.get())
//						   .setBase(block.get())
//						   .setAddition(Items.STICK)
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_axe")
//
//						   .setResult(axe.get())
//						   .setBase(axeHead.get())
//						   .setAddition(Items.STICK)
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_pickaxe")
//
//						   .setResult(pickaxe.get())
//						   .setBase(pickaxeHead.get())
//						   .setAddition(Items.STICK)
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_hoe")
//
//						   .setResult(hoe.get())
//						   .setBase(hoeHead.get())
//						   .setAddition(Items.STICK)
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_sword_handle")
//
//						   .setResult(swordHandle.get())
//						   .setBase(ingot.get())
//						   .setAddition(Items.STICK)
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_sword")
//
//						   .setResult(sword.get())
//						   .setBase(swordBlade.get())
//						   .setAddition(swordHandle.get())
//						   .build();
//		SmithingTableRecipe.create(BetterEndForge.MOD_ID, name + "_shovel")
//
//						   .setResult(shovel.get())
//						   .setBase(shovelHead.get())
//						   .setAddition(Items.STICK)
//						   .build();
//
//		// Armor crafting
        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_helmet")
                .setOutput(helmet::get)
                .setShape("###", "# #")
                .addInput('#', forgedPlate::get)
                .setGroup("end_metal_helmets")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_chestplate")
                .setOutput(chestplate::get)
                .setShape("# #", "###", "###")
                .addInput('#', forgedPlate::get)
                .setGroup("end_metal_chestplates")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_leggings")
                .setOutput(leggings::get)
                .setShape("###", "# #", "# #")
                .addInput('#', forgedPlate::get)
                .setGroup("end_metal_leggings")
        );

        BCLRecipeProvider.addRecipe(new RecipeSupplier(BetterEndForge.MOD_ID, name + "_boots")
                .setOutput(boots::get)
                .setShape("# #", "# #")
                .addInput('#', forgedPlate::get)
                .setGroup("end_metal_boots")
        );


		TagAPI.addBlockTag(NamedBlockTags.ANVIL, anvilBlock.getId());
		TagAPI.addBlockTag(NamedBlockTags.BEACON_BASE_BLOCKS, block.getId());
//		TagAPI.addItemTag(NamedItemTags.BEACON_PAYMENT_ITEMS, ingot.get());
//		TagAPI.addBlockTag(NamedCommonBlockTags.DRAGON_IMMUNE, ore.get(), bars.get());
    } //FIXME: Fix the recipes, they return NPE
}