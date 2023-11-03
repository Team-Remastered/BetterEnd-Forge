package ru.betterend.bclib.complexmaterials;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import ru.betterend.bclib.BCLib;
import ru.betterend.bclib.api.tag.NamedBlockTags;
import ru.betterend.bclib.api.tag.NamedCommonBlockTags;
import ru.betterend.bclib.api.tag.NamedCommonItemTags;
import ru.betterend.bclib.api.tag.NamedItemTags;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.api.tag.TagAPI.TagLocation;
import ru.betterend.bclib.blocks.*;
import ru.betterend.bclib.complexmaterials.entry.BlockEntry;
import ru.betterend.bclib.complexmaterials.entry.RecipeEntry;
import ru.betterend.bclib.recipes.GridRecipe;

public class WoodenComplexMaterial extends ComplexMaterial {
	public static final ResourceLocation MATERIAL_ID = BCLib.makeID("wooden_material");

	public static final String BLOCK_CRAFTING_TABLE = "crafting_table";
	public static final String BLOCK_STRIPPED_BARK = "stripped_bark";
	public static final String BLOCK_STRIPPED_LOG = "stripped_log";
	public static final String BLOCK_PRESSURE_PLATE = "plate";
	public static final String BLOCK_BOOKSHELF = "bookshelf";
	public static final String BLOCK_COMPOSTER = "composter";
	public static final String BLOCK_TRAPDOOR = "trapdoor";
	public static final String BLOCK_BARREL = "barrel";
	public static final String BLOCK_BUTTON = "button";
	public static final String BLOCK_LADDER = "ladder";
	public static final String BLOCK_PLANKS = "planks";
	public static final String BLOCK_STAIRS = "stairs";
	public static final String BLOCK_CHEST = "chest";
	public static final String BLOCK_FENCE = "fence";
	public static final String BLOCK_BARK = "bark";
	public static final String BLOCK_DOOR = "door";
	public static final String BLOCK_GATE = "gate";
	public static final String BLOCK_SIGN = "sign";
	public static final String BLOCK_SLAB = "slab";
	public static final String BLOCK_LOG = "log";

	public static final String TAG_LOGS = "logs";

	public final MaterialColor planksColor;
	public final MaterialColor woodColor;

	public WoodenComplexMaterial(String modID, String baseName, String receipGroupPrefix, MaterialColor woodColor, MaterialColor planksColor) {
		super(modID, baseName, receipGroupPrefix);
		this.planksColor = planksColor;
		this.woodColor = woodColor;
	}

	@Override
	protected BlockBehaviour.Properties getBlockSettings() {
		return BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
								  .materialColor(planksColor);
	}

	@Override
	public ResourceLocation getMaterialID() {
		return MATERIAL_ID;
	}

	@Override
	protected void initTags() {
		addBlockTag(TagAPI.makeBlockTag(getModID(), getBaseName() + "_logs"));
		addItemTag(TagAPI.makeItemTag(getModID(), getBaseName() + "_logs"));
	}

	@Override
	protected void initDefault(BlockBehaviour.Properties blockSettings, FabricItemSettings itemSettings) {
		initBase(blockSettings, itemSettings);
		initStorage(blockSettings, itemSettings);
		initDecorations(blockSettings, itemSettings);
	}

	final protected void initBase(BlockBehaviour.Properties blockSettings, FabricItemSettings itemSettings) {
		TagLocation<Block> tagBlockLog = TagLocation.of(getBlockTag(TAG_LOGS));
		TagLocation<Item> tagItemLog = TagLocation.of(getItemTag(TAG_LOGS));

		addBlockEntry(
				new BlockEntry(BLOCK_STRIPPED_LOG, (complexMaterial, settings) -> new BaseRotatedPillarBlock(settings))
					.setBlockTags(NamedBlockTags.LOGS, NamedBlockTags.LOGS_THAT_BURN, tagBlockLog)
					.setItemTags(NamedItemTags.LOGS, NamedItemTags.LOGS_THAT_BURN, tagItemLog)
		);
		addBlockEntry(
				new BlockEntry(BLOCK_STRIPPED_BARK, (complexMaterial, settings) -> new BaseBarkBlock(settings))
					.setBlockTags(NamedBlockTags.LOGS, NamedBlockTags.LOGS_THAT_BURN, tagBlockLog)
					.setItemTags(NamedItemTags.LOGS, NamedItemTags.LOGS_THAT_BURN, tagItemLog)
		);

		addBlockEntry(
				new BlockEntry(BLOCK_LOG, (complexMaterial, settings) -> new BaseStripableLogBlock(woodColor, getBlock(BLOCK_STRIPPED_LOG)))
					.setBlockTags(NamedBlockTags.LOGS, NamedBlockTags.LOGS_THAT_BURN, tagBlockLog)
					.setItemTags(NamedItemTags.LOGS, NamedItemTags.LOGS_THAT_BURN, tagItemLog)
		);
		addBlockEntry(
				new BlockEntry(BLOCK_BARK, (complexMaterial, settings) -> new StripableBarkBlock(woodColor, getBlock(BLOCK_STRIPPED_BARK)))
					.setBlockTags(NamedBlockTags.LOGS, NamedBlockTags.LOGS_THAT_BURN, tagBlockLog)
					.setItemTags(NamedItemTags.LOGS, NamedItemTags.LOGS_THAT_BURN, tagItemLog)
		);
		addBlockEntry(new BlockEntry(BLOCK_PLANKS, (complexMaterial, settings) -> new BaseBlock(settings))
			.setBlockTags(NamedBlockTags.PLANKS)
			.setItemTags(NamedItemTags.PLANKS));

		addBlockEntry(new BlockEntry(BLOCK_STAIRS, (complexMaterial, settings) -> new BaseStairsBlock(getBlock(BLOCK_PLANKS), false))
			.setBlockTags(NamedBlockTags.WOODEN_STAIRS, NamedBlockTags.STAIRS)
			.setItemTags(NamedItemTags.WOODEN_STAIRS, NamedItemTags.STAIRS));
		
		addBlockEntry(new BlockEntry(BLOCK_SLAB, (complexMaterial, settings) -> new BaseSlabBlock(getBlock(BLOCK_PLANKS), false))
			.setBlockTags(NamedBlockTags.WOODEN_SLABS, NamedBlockTags.SLABS)
			.setItemTags(NamedItemTags.WOODEN_SLABS, NamedItemTags.SLABS));
		
		addBlockEntry(new BlockEntry(BLOCK_FENCE, (complexMaterial, settings) -> new BaseFenceBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.FENCES, NamedBlockTags.WOODEN_FENCES)
			.setItemTags(NamedItemTags.FENCES, NamedItemTags.WOODEN_FENCES));
		
		addBlockEntry(new BlockEntry(BLOCK_GATE, (complexMaterial, settings) -> new BaseGateBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.FENCE_GATES));
		
		addBlockEntry(new BlockEntry(BLOCK_BUTTON, (complexMaterial, settings) -> new BaseWoodenButtonBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.BUTTONS, NamedBlockTags.WOODEN_BUTTONS)
			.setItemTags(NamedItemTags.BUTTONS, NamedItemTags.WOODEN_BUTTONS));
		
		addBlockEntry(new BlockEntry(BLOCK_PRESSURE_PLATE, (complexMaterial, settings) -> new WoodenPressurePlateBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.PRESSURE_PLATES, NamedBlockTags.WOODEN_PRESSURE_PLATES)
			.setItemTags(NamedItemTags.WOODEN_PRESSURE_PLATES));
		
		addBlockEntry(new BlockEntry(BLOCK_TRAPDOOR, (complexMaterial, settings) -> new BaseTrapdoorBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.TRAPDOORS, NamedBlockTags.WOODEN_TRAPDOORS)
			.setItemTags(NamedItemTags.TRAPDOORS, NamedItemTags.WOODEN_TRAPDOORS));
		
		addBlockEntry(new BlockEntry(BLOCK_DOOR, (complexMaterial, settings) -> new BaseDoorBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.DOORS, NamedBlockTags.WOODEN_DOORS)
			.setItemTags(NamedItemTags.DOORS, NamedItemTags.WOODEN_DOORS));

		addBlockEntry(new BlockEntry(BLOCK_LADDER, (complexMaterial, settings) -> new BaseLadderBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.CLIMBABLE));
		
		addBlockEntry(new BlockEntry(BLOCK_SIGN, (complexMaterial, settings) -> new BaseSignBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedBlockTags.SIGNS)
			.setItemTags(NamedItemTags.SIGNS));
	}

	final protected void initStorage(BlockBehaviour.Properties blockSettings, FabricItemSettings itemSettings) {
		addBlockEntry(new BlockEntry(BLOCK_CHEST, (complexMaterial, settings) -> new BaseChestBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedCommonBlockTags.CHEST, NamedCommonBlockTags.WOODEN_CHEST)
			.setItemTags(NamedCommonItemTags.CHEST, NamedCommonItemTags.WOODEN_CHEST));

		addBlockEntry(new BlockEntry(BLOCK_BARREL, (complexMaterial, settings) -> new BaseBarrelBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedCommonBlockTags.BARREL, NamedCommonBlockTags.WOODEN_BARREL)
			.setItemTags(NamedCommonItemTags.BARREL, NamedCommonItemTags.WOODEN_BARREL));
	}

	final protected void initDecorations(BlockBehaviour.Properties blockSettings, FabricItemSettings itemSettings) {
		addBlockEntry(new BlockEntry(BLOCK_CRAFTING_TABLE, (complexMaterial, settings) -> new BaseCraftingTableBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedCommonBlockTags.WORKBENCHES)
			.setItemTags(NamedCommonItemTags.WORKBENCHES));

		addBlockEntry(new BlockEntry(BLOCK_BOOKSHELF, (complexMaterial, settings) -> new BaseBookshelfBlock(getBlock(BLOCK_PLANKS)))
			.setBlockTags(NamedCommonBlockTags.BOOKSHELVES));

		addBlockEntry(new BlockEntry(BLOCK_COMPOSTER, (complexMaterial, settings) -> new BaseComposterBlock(getBlock(BLOCK_PLANKS))));
	}

	@Override
	protected void initFlammable(FlammableBlockRegistry registry) {
		getBlocks().forEach(block -> {
			registry.add(block, 5, 20);
		});

		registry.add(getBlock(BLOCK_LOG), 5, 5);
		registry.add(getBlock(BLOCK_BARK), 5, 5);
		registry.add(getBlock(BLOCK_STRIPPED_LOG), 5, 5);
		registry.add(getBlock(BLOCK_STRIPPED_BARK), 5, 5);
	}

	@Override
	public void initDefaultRecipes() {
		Block planks = getBlock(BLOCK_PLANKS);
		addRecipeEntry(new RecipeEntry("planks", (material, config, id) -> {
			Block log_stripped = getBlock(BLOCK_STRIPPED_LOG);
			Block bark_stripped = getBlock(BLOCK_STRIPPED_BARK);
			Block log = getBlock(BLOCK_LOG);
			Block bark = getBlock(BLOCK_BARK);
			GridRecipe.make(id, planks)
					  .checkConfig(config)
					  .setOutputCount(4)
					  .setList("#")
					  .addMaterial('#', log, bark, log_stripped, bark_stripped)
					  .setGroup(receipGroupPrefix + "_planks")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("stairs", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_STAIRS))
					  .checkConfig(config)
					  .setOutputCount(4)
					  .setShape("#  ", "## ", "###")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_planks_stairs")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("slab", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_SLAB))
					  .checkConfig(config)
					  .setOutputCount(6)
					  .setShape("###")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_planks_slabs")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("fence", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_FENCE))
					  .checkConfig(config)
					  .setOutputCount(3)
					  .setShape("#I#", "#I#")
					  .addMaterial('#', planks)
					  .addMaterial('I', Items.STICK)
					  .setGroup(receipGroupPrefix + "_planks_fences")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("gate", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_GATE))
					  .checkConfig(config)
					  .setShape("I#I", "I#I")
					  .addMaterial('#', planks)
					  .addMaterial('I', Items.STICK)
					  .setGroup(receipGroupPrefix + "_planks_gates")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("button", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_BUTTON))
					  .checkConfig(config)
					  .setList("#")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_planks_buttons")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("pressure_plate", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_PRESSURE_PLATE))
					  .checkConfig(config)
					  .setShape("##")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_planks_plates")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("trapdoor", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_TRAPDOOR))
					  .checkConfig(config)
					  .setOutputCount(2)
					  .setShape("###", "###")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_trapdoors")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("door", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_DOOR))
					  .checkConfig(config)
					  .setOutputCount(3)
					  .setShape("##", "##", "##")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_doors")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("crafting_table", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_CRAFTING_TABLE))
					  .checkConfig(config)
					  .setShape("##", "##")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_tables")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("ladder", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_LADDER))
					  .checkConfig(config)
					  .setOutputCount(3)
					  .setShape("I I", "I#I", "I I")
					  .addMaterial('#', planks)
					  .addMaterial('I', Items.STICK)
					  .setGroup(receipGroupPrefix + "_ladders")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("sign", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_SIGN))
					  .checkConfig(config)
					  .setOutputCount(3)
					  .setShape("###", "###", " I ")
					  .addMaterial('#', planks)
					  .addMaterial('I', Items.STICK)
					  .setGroup(receipGroupPrefix + "_signs")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("chest", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_CHEST))
					  .checkConfig(config)
					  .setShape("###", "# #", "###")
					  .addMaterial('#', planks)
					  .setGroup(receipGroupPrefix + "_chests")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("barrel", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_BARREL))
					  .checkConfig(config)
					  .setShape("#S#", "# #", "#S#")
					  .addMaterial('#', planks)
					  .addMaterial('S', getBlock(BLOCK_SLAB))
					  .setGroup(receipGroupPrefix + "_barrels")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("bookshelf", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_BOOKSHELF))
					  .checkConfig(config)
					  .setShape("###", "PPP", "###")
					  .addMaterial('#', planks)
					  .addMaterial('P', Items.BOOK)
					  .setGroup(receipGroupPrefix + "_bookshelves")
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("bark", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_BARK))
					  .checkConfig(config)
					  .setShape("##", "##")
					  .addMaterial('#', getBlock(BLOCK_LOG))
					  .setOutputCount(3)
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("log", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_LOG))
					  .checkConfig(config)
					  .setShape("##", "##")
					  .addMaterial('#', getBlock(BLOCK_BARK))
					  .setOutputCount(3)
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("stripped_bark", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_STRIPPED_BARK))
					  .checkConfig(config)
					  .setShape("##", "##")
					  .addMaterial('#', getBlock(BLOCK_STRIPPED_LOG))
					  .setOutputCount(3)
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("stripped_log", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_STRIPPED_LOG))
					  .checkConfig(config)
					  .setShape("##", "##")
					  .addMaterial('#', getBlock(BLOCK_STRIPPED_BARK))
					  .setOutputCount(3)
					  .build();
		}));
		addRecipeEntry(new RecipeEntry("composter", (material, config, id) -> {
			GridRecipe.make(id, getBlock(BLOCK_COMPOSTER))
					  .checkConfig(config)
					  .setShape("# #", "# #", "###")
					  .addMaterial('#', getBlock(BLOCK_SLAB))
					  .build();
		}));
	}
}