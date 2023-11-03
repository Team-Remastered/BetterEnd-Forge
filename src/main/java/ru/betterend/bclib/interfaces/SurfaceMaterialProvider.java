package ru.betterend.bclib.interfaces;

import net.minecraft.world.level.block.state.BlockState;
import ru.betterend.bclib.api.surface.SurfaceRuleBuilder;

public interface SurfaceMaterialProvider {
    BlockState getTopMaterial();
    BlockState getUnderMaterial();
    BlockState getAltTopMaterial();

    boolean generateFloorRule();
    SurfaceRuleBuilder surface();
}
