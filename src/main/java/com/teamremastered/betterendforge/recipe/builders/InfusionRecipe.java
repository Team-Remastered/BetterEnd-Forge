package com.teamremastered.betterendforge.recipe.builders;

import com.google.gson.JsonObject;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.bclib.interfaces.UnknownReceipBookCategory;
import com.teamremastered.betterendforge.bclib.recipes.BCLRecipeManager;
import com.teamremastered.betterendforge.bclib.util.ItemUtil;
import com.teamremastered.betterendforge.rituals.InfusionRitual;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class InfusionRecipe implements Recipe<InfusionRitual>, UnknownReceipBookCategory {
	public final static String GROUP = "infusion";
	public final static RecipeType<InfusionRecipe> TYPE = BCLRecipeManager.registerType(BetterEndForge.MOD_ID, GROUP);
	public final static RegistryObject<Serializer> SERIALIZER = BCLRecipeManager.registerSerializer(
		BetterEndForge.MOD_ID,
		GROUP,
		Serializer::new
	);
	
	private final ResourceLocation id;
	private final Ingredient[] catalysts;
	private Ingredient input;
	private ItemStack output;
	private int time = 1;
	private String group;
	
	private InfusionRecipe(ResourceLocation id) {
		this(id, null, null);
	}
	
	private InfusionRecipe(ResourceLocation id, Ingredient input, ItemStack output) {
		this.id = id;
		this.input = input;
		this.output = output;
		this.catalysts = new Ingredient[8];
		Arrays.fill(catalysts, Ingredient.EMPTY);
	}
	
	public int getInfusionTime() {
		return this.time;
	}
	
	@Override
	public boolean matches(InfusionRitual inv, Level world) {
		boolean valid = this.input.test(inv.getItem(0));
		if (!valid) return false;
		for (int i = 0; i < 8; i++) {
			valid &= this.catalysts[i].test(inv.getItem(i + 1));
		}
		return valid;
	}
	
	@Override
	public ItemStack assemble(InfusionRitual ritual) {
		return output.copy();
	}
	
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> defaultedList = NonNullList.create();
		defaultedList.add(input);
		defaultedList.addAll(Arrays.asList(catalysts));
		return defaultedList;
	}
	
	@Override
	public ItemStack getResultItem() {
		return this.output;
	}
	
	@Override
	public ResourceLocation getId() {
		return this.id;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public String getGroup() {
		return this.group;
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER.get();
	}
	
	@Override
	public RecipeType<?> getType() {
		return TYPE;
	}
	
	public static class Builder {
		private final static Builder INSTANCE = new Builder();
		private static boolean exist;
		
		public static Builder create(String id) {
			return create(BetterEndForge.makeID(id));
		}
		
		public static Builder create(ResourceLocation id) {
			INSTANCE.id = id;
			INSTANCE.input = null;
			INSTANCE.output = null;
			INSTANCE.time = 1;
			exist = true; //FIXME: Config
			
			Arrays.fill(INSTANCE.catalysts, Ingredient.EMPTY);
			
			return INSTANCE;
		}
		
		private final Ingredient[] catalysts = new Ingredient[8];
		private ResourceLocation id;
		private Ingredient input;
		private ItemStack output;
		private String group;
		private int time = 1;
		
		private Builder() {
			Arrays.fill(catalysts, Ingredient.EMPTY);
		}
		
		public Builder setGroup(String group) {
			this.group = group;
			return this;
		}
		
		public Builder setInput(ItemLike input) {
			this.input = Ingredient.of(input);
			return this;
		}
		
		public Builder setOutput(ItemLike output) {
			this.output = new ItemStack(output);
			this.output.setCount(1);
			return this;
		}
		
		public Builder setOutput(ItemStack output) {
			this.output = output;
			this.output.setCount(1);
			return this;
		}
		
		public Builder setTime(int time) {
			this.time = time;
			return this;
		}
		
		public Builder addCatalyst(int slot, ItemLike... items) {
			if (slot > 7) return this;
			this.catalysts[slot] = Ingredient.of(items);
			return this;
		}
		
		public void build() {
			if (exist) {
				if (input == null) {
					BetterEndForge.LOGGER.warning(
						"Input for Infusion recipe can't be 'null', recipe {} will be ignored!",
						id
					);
					return;
				}
				if (output == null) {
					BetterEndForge.LOGGER.warning(
						"Output for Infusion recipe can't be 'null', recipe {} will be ignored!",
						id
					);
					return;
				}
				InfusionRecipe recipe = new InfusionRecipe(id, input, output);
				recipe.group = group != null ? group : GROUP;
				recipe.time = time;
				int empty = 0;
				for (int i = 0; i < catalysts.length; i++) {
					if (catalysts[i].isEmpty()) empty++;
					else recipe.catalysts[i] = catalysts[i];
				}
				if (empty == catalysts.length) {
					BetterEndForge.LOGGER.warning("At least one catalyst must be non empty, recipe {} will be ignored!", id);
					return;
				}
				BCLRecipeManager.addRecipe(TYPE, recipe);
			}
		}
	}
	
	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<InfusionRecipe> {
		@Override
		public InfusionRecipe fromJson(ResourceLocation id, JsonObject json) {
			InfusionRecipe recipe = new InfusionRecipe(id);
			recipe.input = Ingredient.fromJson(json.get("input"));
			JsonObject result = GsonHelper.getAsJsonObject(json, "result");
			recipe.output = ItemUtil.fromJsonRecipe(result);
			if (recipe.output == null) {
				throw new IllegalStateException("Output item does not exists!");
			}
			if (result.has("nbt")) {
				try {
					String nbtData = GsonHelper.getAsString(result, "nbt");
					CompoundTag nbt = TagParser.parseTag(nbtData);
					recipe.output.setTag(nbt);
				}
				catch (CommandSyntaxException ex) {
					BetterEndForge.LOGGER.warning("Error parse nbt data for output.", ex);
				}
			}
			recipe.group = GsonHelper.getAsString(json, "group", GROUP);
			recipe.time = GsonHelper.getAsInt(json, "time", 1);
			
			JsonObject catalysts = GsonHelper.getAsJsonObject(json, "catalysts");
			ItemStack catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "north", ""));
			recipe.catalysts[0] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "north_east", ""));
			recipe.catalysts[1] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "east", ""));
			recipe.catalysts[2] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "south_east", ""));
			recipe.catalysts[3] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "south", ""));
			recipe.catalysts[4] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "south_west", ""));
			recipe.catalysts[5] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "west", ""));
			recipe.catalysts[6] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			catalyst = ItemUtil.fromStackString(GsonHelper.getAsString(catalysts, "north_west", ""));
			recipe.catalysts[7] = (catalyst != null && !catalyst.isEmpty()) ? Ingredient.of(catalyst.getItem()) : Ingredient.EMPTY;
			
			return recipe;
		}
		
		@Override
		public InfusionRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
			InfusionRecipe recipe = new InfusionRecipe(id);
			recipe.input = Ingredient.fromNetwork(buffer);
			recipe.output = buffer.readItem();
			recipe.group = buffer.readUtf();
			recipe.time = buffer.readVarInt();
			for (int i = 0; i < 8; i++) {
				recipe.catalysts[i] = Ingredient.fromNetwork(buffer);
			}
			return recipe;
		}
		
		@Override
		public void toNetwork(FriendlyByteBuf buffer, InfusionRecipe recipe) {
			recipe.input.toNetwork(buffer);
			buffer.writeItem(recipe.output);
			buffer.writeUtf(recipe.group);
			buffer.writeVarInt(recipe.time);
			for (int i = 0; i < 8; i++) {
				recipe.catalysts[i].toNetwork(buffer);
			}
		}
	}
}
