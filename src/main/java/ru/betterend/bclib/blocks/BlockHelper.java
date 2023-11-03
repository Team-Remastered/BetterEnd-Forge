package ru.betterend.bclib.blocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.ToIntFunction;

public class BlockHelper {

    public static ToIntFunction<BlockState> getLightValue(int pLightValue) {
        return (state) -> {
            return pLightValue;
        };
    }

}
