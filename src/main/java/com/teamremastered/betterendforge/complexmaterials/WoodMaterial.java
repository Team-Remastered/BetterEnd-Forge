package com.teamremastered.betterendforge.complexmaterials;

import com.teamremastered.betterendforge.bclib.blocks.*;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;
import com.teamremastered.betterendforge.tab.CreativeTabs;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

//TODO: Automatically create every wooden blocks needed
public class WoodMaterial {

    public RegistryObject<Block> crafting_table;
    public RegistryObject<Block> stripped_bark;
    public RegistryObject<Block> stripped_log;
    public RegistryObject<Block> plate;
    public RegistryObject<Block> bookshelf;
    public RegistryObject<Block> composter;
    public RegistryObject<Block> trapdoor;
    public RegistryObject<Block> barrel;
    public RegistryObject<Block> button;
    public RegistryObject<Block> ladder;
    public RegistryObject<Block> planks;
    public RegistryObject<Block> stairs;
    public RegistryObject<Block> chest;
    public RegistryObject<Block> fence;
    public RegistryObject<Block> bark;
    public RegistryObject<Block> door;
    public RegistryObject<Block> gate;
    public RegistryObject<Block> sign;
    public RegistryObject<Block> slab;
    public RegistryObject<Block> log;

    public WoodMaterial(String name, MaterialColor topColor, MaterialColor barkColor) {
        makeWood(name, topColor, barkColor);
    }

    private void makeWood(String name, MaterialColor topColor, MaterialColor barkColor) {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).color(topColor);
        planks = EndBlocks.registerBlock(name + "_planks", () -> new BaseBlock(settings));
        stripped_bark = EndBlocks.registerBlock(name + "_stripped_bark", () -> new BaseBarkBlock(settings));
        stripped_log = EndBlocks.registerBlock(name + "_stripped_log", () -> new BaseRotatedPillarBlock(settings));
        plate = EndBlocks.registerBlock(name + "_plate", () -> new WoodenPressurePlateBlock(planks.get()));
        bookshelf = EndBlocks.registerBlock(name + "_bookshelf", () -> new BaseBookshelfBlock(planks.get()));
//      composter = EndBlocks.registerBlock(name + "_composter"), () ->
//      crafting_table = EndBlocks.registerBlock(name + "_crafting_table"), () ->
        trapdoor = EndBlocks.registerBlock(name + "_trapdoor", () -> new BaseTrapdoorBlock(settings));
//      barrel = EndBlocks.registerBlock(name + "_barrel"), () ->
        button = EndBlocks.registerBlock(name + "_button", () -> new BaseWoodenButtonBlock(planks.get()));
        ladder = EndBlocks.registerBlock(name + "_ladder", () -> new BaseLadderBlock(planks.get()));
        stairs = EndBlocks.registerBlock(name + "_stairs", () -> new BaseWoodenStairsBlock(planks.get()));
//      chest = EndBlocks.registerBlock(name + "_chest"), () ->
      fence = EndBlocks.registerBlock(name + "_fence", () -> new BaseFenceBlock(planks.get()));
        door = EndBlocks.registerBlock(name + "_door", () -> new BaseDoorBlock(planks.get()));
      gate = EndBlocks.registerBlock(name + "_gate", () -> new BaseGateBlock(planks.get()));
//      sign = EndBlocks.registerBlock(name + "_sign", () ->
        slab = EndBlocks.registerBlock(name + "_slab", () -> new BaseWoodenSlabBlock(planks.get()));
        bark = EndBlocks.registerBlock(name + "_bark", () -> new StripableBarkBlock(barkColor, Blocks.ACACIA_WOOD)); //Temp block until we make the other wood blocks
        log = EndBlocks.registerBlock(name + "_log", () -> createLog(MaterialColor.WOOD, MaterialColor.PODZOL));
    }

    private static BaseRotatedPillarBlock createLog(MaterialColor pTopColor, MaterialColor pBarkColor) {
        return new BaseRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopColor : pBarkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    public boolean isTreeLog(Block block) {
        return block == getLog() || block == getBark();
    }

    public boolean isTreeLog(BlockState state) {
        return isTreeLog(state.getBlock());
    }

    public Block getLog() {
        return log.get();
    }

    public Block getBark() {
        return bark.get();
    }
}
