package com.teamremastered.betterendforge.complexmaterials;

import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.core.Direction;
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

    public RegistryObject<Block> bark;
    public RegistryObject<Block> log;

    public WoodMaterial(String name, MaterialColor topColor, MaterialColor barkColor) {
        makeWood(name, topColor, barkColor);
    }

    private void makeWood(String name, MaterialColor topColor, MaterialColor barkColor) {
        bark = EndBlocks.registerBlock(name + "_bark", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
        log = EndBlocks.registerBlock(name + "_log", () -> createLog(MaterialColor.WOOD, MaterialColor.PODZOL));
    }

    private static RotatedPillarBlock createLog(MaterialColor pTopColor, MaterialColor pBarkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
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
