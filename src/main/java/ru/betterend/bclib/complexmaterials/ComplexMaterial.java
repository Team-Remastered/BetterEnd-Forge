package ru.betterend.bclib.complexmaterials;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.complexmaterials.entry.BlockEntry;
import ru.betterend.bclib.complexmaterials.entry.ItemEntry;
import ru.betterend.bclib.complexmaterials.entry.RecipeEntry;
import ru.betterend.bclib.config.PathConfig;
import ru.betterend.bclib.registry.BlockRegistry;
import ru.betterend.bclib.registry.ItemRegistry;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class ComplexMaterial {
	private static final Map<ResourceLocation, List<RecipeEntry>> RECIPE_ENTRIES = Maps.newHashMap();
	private static final Map<ResourceLocation, List<BlockEntry>> BLOCK_ENTRIES = Maps.newHashMap();
	private static final Map<ResourceLocation, List<ItemEntry>> ITEM_ENTRIES = Maps.newHashMap();
	private static final List<ComplexMaterial> MATERIALS = Lists.newArrayList();

	private final List<RecipeEntry> defaultRecipeEntries = Lists.newArrayList();
	private final List<BlockEntry> defaultBlockEntries = Lists.newArrayList();
	private final List<ItemEntry> defaultItemEntries = Lists.newArrayList();

	private final Map<String, TagKey<Block>> blockTags = Maps.newHashMap();
	private final Map<String, TagKey<Item>> itemTags = Maps.newHashMap();
	private final Map<String, Block> blocks = Maps.newHashMap();
	private final Map<String, Item> items = Maps.newHashMap();
	
	protected final String baseName;
	protected final String modID;
	protected final String receipGroupPrefix;
	
	public ComplexMaterial(String modID, String baseName, String receipGroupPrefix) {
		this.baseName = baseName;
		this.modID = modID;
		this.receipGroupPrefix = receipGroupPrefix;
		MATERIALS.add(this);
	}
	
	/**
	 * Initialize and registers all content inside material, return material itself.
	 * @param blocksRegistry {@link BlockRegistry} instance to add blocks in;
	 * @param itemsRegistry {@link ItemRegistry} instance to add items in;
	 * @param recipeConfig {@link PathConfig} for recipes check.
	 * @return {@link ComplexMaterial}.
	 */
	public ComplexMaterial init(BlockRegistry blocksRegistry, ItemRegistry itemsRegistry, PathConfig recipeConfig) {
		initTags();
		
		final BlockBehaviour.Properties blockSettings = getBlockSettings();
		final Item.Properties itemSettings = getItemSettings(itemsRegistry);
		initDefault(blockSettings, itemSettings);
		
		getBlockEntries().forEach(entry -> {
			Block block = entry.init(this, blockSettings, blocksRegistry);
			blocks.put(entry.getSuffix(), block);
		});
		
		getItemEntries().forEach(entry -> {
			Item item = entry.init(this, itemSettings, itemsRegistry);
			items.put(entry.getSuffix(), item);
		});

		initDefaultRecipes();
		getRecipeEntries().forEach(entry -> {
			entry.init(this, recipeConfig);
		});

		initFlammable(FlammableBlockRegistry.getDefaultInstance());
		return this;

	}
	
	/**
	 * Init default content for {@link ComplexMaterial} - blocks and items.
	 * @param blockSettings {@link BlockBehaviour.Properties} default block settings for this material;
	 * @param itemSettings {@link Item.Properties} default item settings for this material.
	 */
	protected abstract void initDefault(BlockBehaviour.Properties blockSettings, Item.Properties itemSettings);
	
	/**
	 * Init custom tags for this {@link ComplexMaterial}, not required.
	 */
	protected void initTags() {}
	
	/**
	 * Init default recipes for this {@link ComplexMaterial}, not required.
	 */
	protected void initDefaultRecipes() {}

	//FIXME: We need to rework how flammable blocks work since FlammableBlockRegistry doesn't exist
	/**
	 * Allows to add blocks into Fabric {@link FlammableBlockRegistry} for this {@link ComplexMaterial}, not required.
	 */
	protected void initFlammable(FlammableBlockRegistry registry) {}
	
	/**
	 * Adds custom block tag for this {@link ComplexMaterial}, tag can be created with {@link TagAPI} or you can use one of already created tags.
	 * @param tag {@link TagKey} for {@link Block}
	 */
	protected void addBlockTag(TagKey<Block> tag) {
		String key = tag.location().getPath().replace(getBaseName() + "_", "");
		blockTags.put(key, tag);
	}
	
	/**
	 * Adds custom item tag for this {@link ComplexMaterial}, tag can be created with {@link TagAPI} or you can use one of already created tags.
	 * @param tag {@link TagKey} for {@link Item}
	 */
	protected void addItemTag(TagKey<Item> tag) {
		String key = tag.location().getPath().replace(getBaseName() + "_", "");
		itemTags.put(key, tag);
	}
	
	/**
	 * Get custom {@link Block} {@link TagKey} from this {@link ComplexMaterial}.
	 * @param key {@link String} tag name (path of its {@link ResourceLocation}), for inner tags created inside material its tag suffix.
	 * @return {@link TagKey} for {@link Block} or {@code null} if nothing is stored.
	 */
	@Nullable
	public TagKey<Block> getBlockTag(String key) {
		return blockTags.get(key);
	}
	
	/**
	 * Get custom {@link Item} {@link TagKey} from this {@link ComplexMaterial}.
	 * @param key {@link String} tag name (path of its {@link ResourceLocation}), for inner tags created inside material its tag suffix.
	 * @return {@link TagKey} for {@link Item} or {@code null} if nothing is stored.
	 */
	@Nullable
	public TagKey<Item> getItemTag(String key) {
		return itemTags.get(key);
	}
	
	/**
	 * Get initiated {@link Block} from this {@link ComplexMaterial}.
	 * @param key {@link String} block name suffix (example: "mod:custom_log" will have a "log" suffix if "custom" is a base name of this material)
	 * @return {@link Block} or {@code null} if nothing is stored.
	 */
	@Nullable
	public Block getBlock(String key) {
		return blocks.get(key);
	}
	
	/**
	 * Get initiated {@link Item} from this {@link ComplexMaterial}.
	 * @param key {@link String} block name suffix (example: "mod:custom_apple" will have a "apple" suffix if "custom" is a base name of this material)
	 * @return {@link Item} or {@code null} if nothing is stored.
	 */
	@Nullable
	public Item getItem(String key) {
		return items.get(key);
	}
	
	/**
	 * Get default block settings for this material.
	 * @return {@link BlockBehaviour.Properties}
	 */
	protected abstract BlockBehaviour.Properties getBlockSettings();
	
	/**
	 * Get default item settings for this material.
	 * @return {@link Item.Properties}
	 */
	protected Item.Properties getItemSettings(ItemRegistry registry) {
		return registry.makeItemSettings();
	}
	
	private Collection<BlockEntry> getBlockEntries() {
		List<BlockEntry> result = Lists.newArrayList(defaultBlockEntries);
		List<BlockEntry> entries = BLOCK_ENTRIES.get(this.getMaterialID());
		if (entries != null) {
			result.addAll(entries);
		}
		return result;
	}
	
	private Collection<ItemEntry> getItemEntries() {
		List<ItemEntry> result = Lists.newArrayList(defaultItemEntries);
		List<ItemEntry> entries = ITEM_ENTRIES.get(this.getMaterialID());
		if (entries != null) {
			result.addAll(entries);
		}
		return result;
	}

	private Collection<RecipeEntry> getRecipeEntries() {
		List<RecipeEntry> result = Lists.newArrayList(defaultRecipeEntries);
		List<RecipeEntry> entries = RECIPE_ENTRIES.get(this.getMaterialID());
		if (entries != null) {
			result.addAll(entries);
		}
		return result;
	}
	
	/**
	 * Get base name of this {@link ComplexMaterial}.
	 * @return {@link String} name
	 */
	public String getBaseName() {
		return baseName;
	}
	
	/**
	 * Get mod ID for this {@link ComplexMaterial}.
	 * @return {@link String} mod ID.
	 */
	public String getModID() {
		return modID;
	}
	
	/**
	 * Get a unique {@link ResourceLocation} for each material class.
	 * For example WoodenComplexMaterial will have a "bclib:Wooden_Complex_Material" {@link ResourceLocation}.
	 * This is used to add custom entries before mods init using Fabric "preLaunch" entry point.
	 * @return {@link ResourceLocation} for this material
	 * @see <a href="https://fabricmc.net/wiki/documentation:entrypoint">Fabric Documentation: Entrypoint</a>
	 */
	public abstract ResourceLocation getMaterialID();
	
	/**
	 * Get all initiated block from this {@link ComplexMaterial}.
	 * @return {@link Collection} of {@link Block}.
	 */
	public Collection<Block> getBlocks() {
		return blocks.values();
	}
	
	/**
	 * Get all initiated items from this {@link ComplexMaterial}.
	 * @return {@link Collection} of {@link Item}.
	 */
	public Collection<Item> getItems() {
		return items.values();
	}
	
	/**
	 * Adds a default {@link BlockEntry} to this {@link ComplexMaterial}. Used to initiate blocks later.
	 * @param entry {@link BlockEntry}
	 */
	protected void addBlockEntry(BlockEntry entry) {
		defaultBlockEntries.add(entry);
	}
	
	/**
	 * Replaces or Adds a default {@link BlockEntry} to this {@link ComplexMaterial}. Used to initiate blocks later.
	 * <p>
	 * If this {@link ComplexMaterial} does already contain an entry for the {@link ResourceLocation}, the entry will
	 * be removed first.
	 * @param entry {@link BlockEntry}
	 */
	protected void replaceOrAddBlockEntry(BlockEntry entry) {
		int pos = defaultBlockEntries.indexOf(entry);
		if (pos>=0) defaultBlockEntries.remove(entry);
		
		addBlockEntry(entry);
	}
	
	/**
	 * Adds a default {@link ItemEntry} to this {@link ComplexMaterial}. Used to initiate items later.
	 * @param entry {@link ItemEntry}
	 */
	protected void addItemEntry(ItemEntry entry) {
		defaultItemEntries.add(entry);
	}

	/**
	 * Adds a default {@link RecipeEntry} to this {@link ComplexMaterial}. Used to initiate items later.
	 * @param entry {@link RecipeEntry}
	 */
	protected void addRecipeEntry(RecipeEntry entry) {
		defaultRecipeEntries.add(entry);
	}
	
	/**
	 * Adds a custom {@link BlockEntry} for specified {@link ComplexMaterial} using its {@link ResourceLocation}.
	 * Used to add custom entry for all instances of {@link ComplexMaterial}.
	 * Should be called only using Fabric "preLaunch" entry point.
	 * @param materialName {@link ResourceLocation} id of {@link ComplexMaterial};
	 * @param entry {@link BlockEntry}.
	 * @see <a href="https://fabricmc.net/wiki/documentation:entrypoint">Fabric Documentation: Entrypoint</a>
	 */
	public static void addBlockEntry(ResourceLocation materialName, BlockEntry entry) {
		List<BlockEntry> entries = BLOCK_ENTRIES.get(materialName);
		if (entries == null) {
			entries = Lists.newArrayList();
			BLOCK_ENTRIES.put(materialName, entries);
		}
		entries.add(entry);
	}
	
	/**
	 * Adds a custom {@link ItemEntry} for specified {@link ComplexMaterial} using its {@link ResourceLocation}.
	 * Used to add custom entry for all instances of {@link ComplexMaterial}.
	 * Should be called only using Fabric "preLaunch" entry point.
	 * @param materialName {@link ResourceLocation} id of {@link ComplexMaterial};
	 * @param entry {@link ItemEntry}.
	 * @see <a href="https://fabricmc.net/wiki/documentation:entrypoint">Fabric Documentation: Entrypoint</a>
	 */
	public static void addItemEntry(ResourceLocation materialName, ItemEntry entry) {
		List<ItemEntry> entries = ITEM_ENTRIES.get(materialName);
		if (entries == null) {
			entries = Lists.newArrayList();
			ITEM_ENTRIES.put(materialName, entries);
		}
		entries.add(entry);
	}

	/**
	 * Adds a custom {@link RecipeEntry} for specified {@link ComplexMaterial} using its {@link ResourceLocation}.
	 * Used to add custom entry for all instances of {@link ComplexMaterial}.
	 * Should be called only using Fabric "preLaunch" entry point.
	 * @param materialName {@link ResourceLocation} id of {@link ComplexMaterial};
	 * @param entry {@link RecipeEntry}.
	 * @see <a href="https://fabricmc.net/wiki/documentation:entrypoint">Fabric Documentation: Entrypoint</a>
	 */
	public static void addRecipeEntry(ResourceLocation materialName, RecipeEntry entry) {
		List<RecipeEntry> entries = RECIPE_ENTRIES.get(materialName);
		if (entries == null) {
			entries = Lists.newArrayList();
			RECIPE_ENTRIES.put(materialName, entries);
		}
		entries.add(entry);
	}
	
	/**
	 * Get all instances of all materials.
	 * @return {@link Collection} of {@link ComplexMaterial}.
	 */
	public static Collection<ComplexMaterial> getAllMaterials() {
		return MATERIALS;
	}
}
