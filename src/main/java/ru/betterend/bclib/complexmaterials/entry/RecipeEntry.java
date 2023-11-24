package ru.betterend.bclib.complexmaterials.entry;

import net.minecraft.resources.ResourceLocation;
import ru.betterend.bclib.complexmaterials.ComplexMaterial;

public class RecipeEntry extends ComplexMaterialEntry {
	final TriConsumer<ComplexMaterial, PathConfig, ResourceLocation> initFunction;

	public RecipeEntry(String suffix, TriConsumer<ComplexMaterial, PathConfig, ResourceLocation> initFunction) {
		super(suffix);
		this.initFunction = initFunction;
	}
	
	public void init(ComplexMaterial material, PathConfig recipeConfig) {
		initFunction.accept(material, recipeConfig, getLocation(material.getModID(), material.getBaseName()));
	}
}
