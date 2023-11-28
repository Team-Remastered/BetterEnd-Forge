package com.teamremastered.betterendforge.bclib.recipes;

import com.google.gson.JsonObject;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.teamremastered.betterendforge.bclib.BCLib;
import com.teamremastered.betterendforge.bclib.api.tag.CommonItemTags;
import com.teamremastered.betterendforge.bclib.interfaces.UnknownReceipBookCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;
import com.teamremastered.betterendforge.bclib.util.ItemUtil;
import com.teamremastered.betterendforge.bclib.util.RecipeHelper;

import java.util.Objects;

public class AnvilRecipe implements Recipe<Container>, UnknownReceipBookCategory {
	public final static String GROUP = "smithing";
	public final static RecipeType<AnvilRecipe> TYPE = BCLRecipeManager.registerType(BCLib.MOD_ID, GROUP);
	public final static Serializer SERIALIZER = BCLRecipeManager.registerSerializer(
			BCLib.MOD_ID,
			GROUP,
			new Serializer()
	);
	public final static ResourceLocation ID = BCLib.makeID(GROUP);

	public static void register(){

	}

	private final ResourceLocation id;
	private final Ingredient input;
	private final ItemStack output;
	private final int damage;
	private final int toolLevel;
	private final int anvilLevel;
	private final int inputCount;

	public AnvilRecipe(ResourceLocation identifier, Ingredient input, ItemStack output, int inputCount, int toolLevel, int anvilLevel, int damage) {
		this.id = identifier;
		this.input = input;
		this.output = output;
		this.toolLevel = toolLevel;
		this.anvilLevel = anvilLevel;
		this.inputCount = inputCount;
		this.damage = damage;
	}

	public static Builder create(String id) {
		return create(BCLib.makeID(id));
	}

	public static Builder create(ResourceLocation id) {
		Builder.INSTANCE.id = id;
		Builder.INSTANCE.input = null;
		Builder.INSTANCE.output = null;
		Builder.INSTANCE.inputCount = 1;
		Builder.INSTANCE.toolLevel = 1;
		Builder.INSTANCE.anvilLevel = 1;
		Builder.INSTANCE.damage = 1;
		Builder.INSTANCE.alright = true;
		Builder.INSTANCE.exist = true;

		return Builder.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}

	@Override
	public ItemStack getResultItem() {
		return this.output;
	}

	@Override
	public boolean matches(Container craftingInventory, Level world) {
		return this.matches(craftingInventory);
	}

	@Override
	public ItemStack assemble(Container craftingInventory) {
		return this.output.copy();
	}

	public ItemStack craft(Container craftingInventory, Player player) {
		if (!player.isCreative()) {
			if (!checkHammerDurability(craftingInventory, player)) return ItemStack.EMPTY;
			ItemStack hammer = craftingInventory.getItem(1);
			hammer.hurtAndBreak(this.damage, player, entity -> entity.broadcastBreakEvent((InteractionHand) null));
		}
		return this.assemble(craftingInventory);
	}

	public boolean checkHammerDurability(Container craftingInventory, Player player) {
		if (player.isCreative()) return true;
		ItemStack hammer = craftingInventory.getItem(1);
		int damage = hammer.getDamageValue() + this.damage;
		return damage < hammer.getMaxDamage();
	}

	public boolean matches(Container craftingInventory) {
		ItemStack hammer = craftingInventory.getItem(1);
		//TODO: 1.18.2 Test if hammer still works
		if (hammer.isEmpty() || !hammer.is(CommonItemTags.HAMMERS)) {
			return false;
		}
		ItemStack material = craftingInventory.getItem(0);
		int materialCount = material.getCount();
		int level = ((TieredItem) hammer.getItem()).getTier().getLevel();
		return this.input.test(craftingInventory.getItem(0)) && materialCount >= this.inputCount && level >= this.toolLevel;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getInputCount() {
		return this.inputCount;
	}

	public int getAnvilLevel() {
		return this.anvilLevel;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		;
		NonNullList<Ingredient> defaultedList = NonNullList.create();
		defaultedList.add(Ingredient.of(Registry.ITEM.stream()
				.filter(item->item.builtInRegistryHolder().is(CommonItemTags.HAMMERS))
				.filter(hammer -> ((TieredItem) hammer).getTier().getLevel() >= toolLevel)
				.map(ItemStack::new))
		);
		defaultedList.add(input);
		return defaultedList;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeType<?> getType() {
		return TYPE;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnvilRecipe that = (AnvilRecipe) o;
		return damage == that.damage && toolLevel == that.toolLevel && id.equals(that.id) && input.equals(that.input) && output.equals(that.output);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, input, output, damage, toolLevel);
	}

	@Override
	public String toString() {
		return "AnvilRecipe [" + id + "]";
	}

	public static class Builder {
		private final static Builder INSTANCE = new Builder();

		private ResourceLocation id;
		private Ingredient input;
		private ItemStack output;
		private int inputCount = 1;
		private int toolLevel = 1;
		private int anvilLevel = 1;
		private int damage = 1;
		private boolean alright;
		private boolean exist;

		private Builder() {}

		public Builder setInput(ItemLike... inputItems) {
			this.alright &= RecipeHelper.exists(inputItems);
			this.setInput(Ingredient.of(inputItems));
			return this;
		}

		public Builder setInput(TagKey<Item> inputTag) {
			this.setInput(Ingredient.of(inputTag));
			return this;
		}

		public Builder setInput(Ingredient ingredient) {
			this.input = ingredient;
			return this;
		}

		public Builder setInputCount(int count) {
			this.inputCount = count;
			return this;
		}

		public Builder setOutput(ItemLike output) {
			return this.setOutput(output, 1);
		}

		public Builder setOutput(ItemLike output, int amount) {
			this.alright &= RecipeHelper.exists(output);
			this.output = new ItemStack(output, amount);
			return this;
		}

		public Builder setToolLevel(int level) {
			this.toolLevel = level;
			return this;
		}

		public Builder setAnvilLevel(int level) {
			this.anvilLevel = level;
			return this;
		}

		public Builder setDamage(int damage) {
			this.damage = damage;
			return this;
		}

		public void build() {
			if (!exist) {
				return;
			}
			
			if (input == null) {
				BCLib.LOGGER.warning("Input for Anvil recipe can't be 'null', recipe {} will be ignored!", id);
				return;
			}
			if (output == null) {
				BCLib.LOGGER.warning("Output for Anvil recipe can't be 'null', recipe {} will be ignored!", id);
				return;
			}
			if (BCLRecipeManager.getRecipe(TYPE, id) != null) {
				BCLib.LOGGER.warning("Can't add Anvil recipe! Id {} already exists!", id);
				return;
			}
			if (!alright) {
				BCLib.LOGGER.debug("Can't add Anvil recipe {}! Ingeredient or output not exists.", id);
				return;
			}
			BCLRecipeManager.addRecipe(TYPE, new AnvilRecipe(id, input, output, inputCount, toolLevel, anvilLevel, damage));
		}
	}

	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<AnvilRecipe> {
		@Override
		public AnvilRecipe fromJson(ResourceLocation id, JsonObject json) {
			Ingredient input = Ingredient.fromJson(json.get("input"));
			JsonObject result = GsonHelper.getAsJsonObject(json, "result");
			ItemStack output = ItemUtil.fromJsonRecipe(result);
			if (output == null) {
				throw new IllegalStateException("Output item does not exists!");
			}
			if (result.has("nbt")) {
				try {
					String nbtData = GsonHelper.getAsString(result, "nbt");
					CompoundTag nbt = TagParser.parseTag(nbtData);
					output.setTag(nbt);
				}
				catch (CommandSyntaxException ex) {
					BCLib.LOGGER.warning("Error parse nbt data for output.", ex);
				}
			}
			int inputCount = GsonHelper.getAsInt(json, "inputCount", 1);
			int toolLevel = GsonHelper.getAsInt(json, "toolLevel", 1);
			int anvilLevel = GsonHelper.getAsInt(json, "anvilLevel", 1);
			int damage = GsonHelper.getAsInt(json, "damage", 1);

			return new AnvilRecipe(id, input, output, inputCount, toolLevel, anvilLevel, damage);
		}

		@Override
		public AnvilRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf packetBuffer) {
			Ingredient input = Ingredient.fromNetwork(packetBuffer);
			ItemStack output = packetBuffer.readItem();
			int inputCount = packetBuffer.readVarInt();
			int toolLevel = packetBuffer.readVarInt();
			int anvilLevel = packetBuffer.readVarInt();
			int damage = packetBuffer.readVarInt();

			return new AnvilRecipe(id, input, output, inputCount, toolLevel, anvilLevel, damage);
		}

		@Override
		public void toNetwork(FriendlyByteBuf packetBuffer, AnvilRecipe recipe) {
			recipe.input.toNetwork(packetBuffer);
			packetBuffer.writeItem(recipe.output);
			packetBuffer.writeVarInt(recipe.inputCount);
			packetBuffer.writeVarInt(recipe.toolLevel);
			packetBuffer.writeVarInt(recipe.anvilLevel);
			packetBuffer.writeVarInt(recipe.damage);
		}
	}
}
