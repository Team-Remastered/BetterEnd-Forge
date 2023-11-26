package ru.betterend.complexmaterials;

//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.material.MaterialColor;
//import net.minecraftforge.registries.RegistryObject;
//import ru.betterend.bclib.complexmaterials.WoodenComplexMaterial;
//import ru.betterend.BetterEndForge;
//import ru.betterend.registry.EndBlocks;
//import ru.betterend.registry.EndItems;
//
//public class EndWoodenComplexMaterial extends WoodenComplexMaterial {
//	private RegistryObject<Block> bark;
//	private  RegistryObject<Block> log;
//
//	public EndWoodenComplexMaterial(String name, MaterialColor woodColor, MaterialColor planksColor) {
//		super(BetterEndForge.MOD_ID, name, name, woodColor, planksColor);
//	}
//
//	public EndWoodenComplexMaterial init() {
//		return (EndWoodenComplexMaterial) super.init(EndBlocks.getBlockRegistry(), EndItems.getItemRegistry());
//	}
//
//	public boolean isTreeLog(Block block) {
//		return block == getLog() || block == getBark();
//	}
//
//	public boolean isTreeLog(BlockState state) {
//		return isTreeLog(state.getBlock());
//	}
//
//	public Block getLog() {
//		if (log == null) {
//			log.get() = getBlock("log");
//		}
//		return log.get();
//	}
//
//	public Block getBark() {
//		if (bark == null) {
//			bark = getBlock("bark");
//		}
//		return bark;
//	}
//}