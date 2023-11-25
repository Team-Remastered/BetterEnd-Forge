package ru.betterend.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.BetterEndForge;
import ru.betterend.blocks.EndStoneSmelter;
import ru.betterend.blocks.basis.PedestalBlock;
import ru.betterend.blocks.entities.BlockEntityHydrothermalVent;
import ru.betterend.blocks.entities.EndStoneSmelterBlockEntity;
import ru.betterend.blocks.entities.EternalPedestalEntity;
import ru.betterend.blocks.entities.InfusionPedestalEntity;
import ru.betterend.blocks.entities.PedestalBlockEntity;

public class EndBlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus modEventBus) {
		BLOCK_ENTITIES.register(modEventBus);
	}

	public static final RegistryObject<BlockEntityType<EndStoneSmelterBlockEntity>> END_STONE_SMELTER = registerBlockEntity(
			EndStoneSmelter.ID, EndStoneSmelterBlockEntity::new, EndBlocks.END_STONE_SMELTER.get());
	public final static RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL = registerBlockEntity(
		"pedestal", PedestalBlockEntity::new, getPedestals()); //No idea if this works
	public final static RegistryObject<BlockEntityType<EternalPedestalEntity>> ETERNAL_PEDESTAL = registerBlockEntity(
		"eternal_pedestal", EternalPedestalEntity::new, EndBlocks.ETERNAL_PEDESTAL.get());
	public final static RegistryObject<BlockEntityType<InfusionPedestalEntity>> INFUSION_PEDESTAL = registerBlockEntity(
		"infusion_pedestal", InfusionPedestalEntity::new, EndBlocks.INFUSION_PEDESTAL.get());
	public final static RegistryObject<BlockEntityType<BlockEntityHydrothermalVent>> HYDROTHERMAL_VENT = registerBlockEntity(
		"hydrother_malvent", BlockEntityHydrothermalVent::new, EndBlocks.HYDROTHERMAL_VENT.get());
	
	public static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerBlockEntity(String id,  BlockEntityType.BlockEntitySupplier<T> pFactory, Block... blocks) {
		return BLOCK_ENTITIES.register(id, () -> BlockEntityType.Builder.of(pFactory, blocks).build(null));
		
		//return Registry.register(Registry.BLOCK_ENTITY_TYPE, BetterEnd.makeID(id), builder.build(null));
	}
	
	static Block[] getPedestals() {
		return EndBlocks.getModBlocks()
						.stream()
						.filter(block -> block instanceof PedestalBlock && !((PedestalBlock) block).hasUniqueEntity())
						.toArray(Block[]::new);
	}
}
