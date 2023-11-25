package ru.betterend.mixin.common.fabric;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Function;
import java.util.function.ToIntFunction;

@Mixin(BlockBehaviour.Properties.class)
public interface AbstractBlockSettingsAccessor {
    /* GETTERS */
    @Accessor
    Material getMaterial();

    @Accessor
    float getHardness();

    @Accessor
    float getResistance();

    @Accessor
    boolean getCollidable();

    @Accessor
    boolean getRandomTicks();

    @Accessor("luminance")
    ToIntFunction<BlockState> getLuminance();

    @Accessor
    Function<BlockState, MaterialColor> getMapColorProvider();

    @Accessor
    SoundType getSoundGroup();

    @Accessor
    float getSlipperiness();

    @Accessor
    float getVelocityMultiplier();

    @Accessor
    boolean getDynamicBounds();

    @Accessor
    boolean getOpaque();

    @Accessor
    boolean getIsAir();

    @Accessor
    boolean isToolRequired();

    /* SETTERS */
    @Accessor
    void setMaterial(Material material);

    @Accessor
    void setHardness(float hardness);

    @Accessor
    void setResistance(float resistance);

    @Accessor
    void setCollidable(boolean collidable);

    @Accessor
    void setRandomTicks(boolean ticksRandomly);

    @Accessor
    void setMapColorProvider(Function<BlockState, MaterialColor> mapColorProvider);

    @Accessor
    void setDynamicBounds(boolean dynamicBounds);

    @Accessor
    void setOpaque(boolean opaque);

    @Accessor
    void setIsAir(boolean isAir);

    @Accessor
    void setLootTableId(ResourceLocation lootTableId);

    @Accessor
    void setToolRequired(boolean toolRequired);

    // Cannot be an invoker due to conflicts in mixin: method_9631(Ljava/util/function/ToIntFunction;)Lnet/minecraft/class_4970$class_2251; for target net.minecraft.block.AbstractBlock$Settings conflicts with existing mapping field_10663:Ljava/util/function/ToIntFunction;
    @Accessor("luminance")
    void setLuminanceFunction(ToIntFunction<BlockState> luminanceFunction);

}
