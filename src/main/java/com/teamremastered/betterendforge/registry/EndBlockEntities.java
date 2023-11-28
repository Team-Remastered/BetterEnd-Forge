package com.teamremastered.betterendforge.registry;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.blocks.EndStoneSmelter;
import com.teamremastered.betterendforge.blocks.basis.PedestalBlock;
import com.teamremastered.betterendforge.blocks.entities.BlockEntityHydrothermalVent;
import com.teamremastered.betterendforge.blocks.entities.EndStoneSmelterBlockEntity;
import com.teamremastered.betterendforge.blocks.entities.EternalPedestalEntity;
import com.teamremastered.betterendforge.blocks.entities.InfusionPedestalEntity;
import com.teamremastered.betterendforge.blocks.entities.PedestalBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndBlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus modEventBus) {
		BLOCK_ENTITIES.register(modEventBus);
	}

	public static final RegistryObject<BlockEntityType<EndStoneSmelterBlockEntity>> END_STONE_SMELTER =
			BLOCK_ENTITIES.register(EndStoneSmelter.ID, () -> BlockEntityType.Builder.of(EndStoneSmelterBlockEntity::new, EndBlocks.END_STONE_SMELTER.get()).build(null));

	public final static RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL =
			BLOCK_ENTITIES.register("pedestal", () -> BlockEntityType.Builder.of(PedestalBlockEntity::new, getPedestals()).build(null));


	public final static RegistryObject<BlockEntityType<EternalPedestalEntity>> ETERNAL_PEDESTAL =
			BLOCK_ENTITIES.register("eternal_pedestal", () -> BlockEntityType.Builder.of(EternalPedestalEntity::new, EndBlocks.ETERNAL_PEDESTAL.get()).build(null));


	public final static RegistryObject<BlockEntityType<InfusionPedestalEntity>> INFUSION_PEDESTAL =
			BLOCK_ENTITIES.register("infusion_pedestal", () -> BlockEntityType.Builder.of(InfusionPedestalEntity::new, EndBlocks.INFUSION_PEDESTAL.get()).build(null));


	public final static RegistryObject<BlockEntityType<BlockEntityHydrothermalVent>> HYDROTHERMAL_VENT =
			BLOCK_ENTITIES.register("hydrother_malvent", () -> BlockEntityType.Builder.of(BlockEntityHydrothermalVent::new, EndBlocks.HYDROTHERMAL_VENT.get()).build(null));


	static Block[] getPedestals() {
		return EndBlocks.getModBlocks()
						.stream()
						.filter(block -> block instanceof PedestalBlock && !((PedestalBlock) block).hasUniqueEntity())
						.toArray(Block[]::new);
	}
}
