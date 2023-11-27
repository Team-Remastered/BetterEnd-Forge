package ru.betterend.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.betterend.bclib.api.spawning.SpawnRuleBuilder;
import ru.betterend.bclib.util.ColorUtil;
import ru.betterend.BetterEndForge;
import ru.betterend.entity.CubozoaEntity;
import ru.betterend.entity.DragonflyEntity;
import ru.betterend.entity.EndFishEntity;
import ru.betterend.entity.EndSlimeEntity;
import ru.betterend.entity.ShadowWalkerEntity;
import ru.betterend.entity.SilkMothEntity;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = BetterEndForge.MOD_ID, value = Dist.DEDICATED_SERVER)
public class EndEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BetterEndForge.MOD_ID);

	public static void initRegister(IEventBus eventBus) {
		ENTITIES.register(eventBus);
	}

	public static final RegistryObject<EntityType<DragonflyEntity>> DRAGONFLY = register(
		"dragonfly",
		MobCategory.AMBIENT,
		0.6F,
		0.5F,
		DragonflyEntity::new,
		true,
		ColorUtil.color(32, 42, 176),
		ColorUtil.color(115, 225, 249)
	);
	public static final RegistryObject<EntityType<EndSlimeEntity>> END_SLIME = register(
		"end_slime",
		MobCategory.MONSTER,
		2F,
		2F,
		EndSlimeEntity::new,
		false,
		ColorUtil.color(28, 28, 28),
		ColorUtil.color(99, 11, 99)
	);
	public static final RegistryObject<EntityType<EndFishEntity>> END_FISH = register(
		"end_fish",
		MobCategory.WATER_AMBIENT,
		0.5F,
		0.5F,
		EndFishEntity::new,
		true,
		ColorUtil.color(3, 50, 76),
		ColorUtil.color(120, 206, 255)
	);
	public static final RegistryObject<EntityType<ShadowWalkerEntity>> SHADOW_WALKER = register(
		"shadow_walker",
		MobCategory.MONSTER,
		0.6F,
		1.95F,
		ShadowWalkerEntity::new,
		true,
		ColorUtil.color(30, 30, 30),
		ColorUtil.color(5, 5, 5)
	);
	public static final RegistryObject<EntityType<CubozoaEntity>> CUBOZOA = register(
		"cubozoa",
		MobCategory.WATER_AMBIENT,
		0.6F,
		1F,
		CubozoaEntity::new,
		true,
		ColorUtil.color(151, 77, 181),
		ColorUtil.color(93, 176, 238)
	);
	public static final RegistryObject<EntityType<SilkMothEntity>> SILK_MOTH = register(
		"silk_moth",
		MobCategory.AMBIENT,
		0.6F,
		0.6F,
		SilkMothEntity::new,
		true,
		ColorUtil.color(198, 138, 204),
		ColorUtil.color(242, 220, 236)
	);
	
	public static void registerSpawnPlacement() {
		//TODO: review the spawn placement to match the one form BetterEnd Fabric

		// Air //
		SpawnPlacements.register(DRAGONFLY.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Types.MOTION_BLOCKING, DragonflyEntity::checkAnimalSpawnRules);
		SpawnPlacements.register(SILK_MOTH.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Types.MOTION_BLOCKING, SilkMothEntity::checkAnimalSpawnRules);
		
		// Land //
		SpawnPlacements.register(END_SLIME.get(), SpawnPlacements.Type.ON_GROUND, Types.MOTION_BLOCKING, EndSlimeEntity::checkMobSpawnRules);
		SpawnPlacements.register(SHADOW_WALKER.get(), SpawnPlacements.Type.ON_GROUND, Types.MOTION_BLOCKING, ShadowWalkerEntity::checkMonsterSpawnRules);

		// Water //
		SpawnPlacements.register(END_FISH.get(), SpawnPlacements.Type.IN_WATER, Types.MOTION_BLOCKING, EndFishEntity::checkSurfaceWaterAnimalSpawnRules);
		SpawnPlacements.register(CUBOZOA.get(), SpawnPlacements.Type.IN_WATER, Types.MOTION_BLOCKING, CubozoaEntity::checkSurfaceWaterAnimalSpawnRules);
	}
	
//	protected static <T extends Entity> EntityType<T> register(String name, MobCategory group, float width, float height, EntityFactory<T> entity) {
//		ResourceLocation id = BetterEndForge.makeID(name);
//		EntityType<T> type = FabricEntityTypeBuilder
//			.<T>create(group, entity)
//			.dimensions(EntityDimensions.fixed(width, height))
//			.build();
//		if (Configs.ENTITY_CONFIG.getBooleanRoot(id.getPath(), true)) {
//			return Registry.register(Registry.ENTITY_TYPE, id, type);
//		}
//		return type;
//	}
	
//	private static <T extends Mob> EntityType<T> register(String name, MobCategory group, float width, float height, EntityFactory<T> entity, Builder attributes, boolean fixedSize, int eggColor, int dotsColor) {
//		ResourceLocation id = BetterEndForge.makeID(name);
//		EntityType<T> type = FabricEntityTypeBuilder
//			.<T>create(group, entity)
//			.dimensions(fixedSize ? EntityDimensions.fixed(width, height) : EntityDimensions.scalable(width, height))
//			.build();
//		if (Configs.ENTITY_CONFIG.getBooleanRoot(id.getPath(), true)) {
//			FabricDefaultAttributeRegistry.register(type, attributes);
//			EndItems.registerEndEgg("spawn_egg_" + name, type, eggColor, dotsColor);
//			return Registry.register(Registry.ENTITY_TYPE, BetterEndForge.makeID(name), type);
//		}
//		return type;
//	}

	public static <T extends Mob> RegistryObject<EntityType<T>> register(String id, Supplier<? extends EntityType<T>> sup){
		return ENTITIES.register(id, sup);
	}

	public static <T extends Mob> RegistryObject<EntityType<T>> register(String name, MobCategory group, float width, float height, EntityFactory<T> entity, boolean fixedSize, int eggColor, int dotsColor) {
		var reg = register(name, () -> EntityType.Builder.of(entity, group).sized(width, height).build(BetterEndForge.makeID(name).toString()));
		EndItems.ITEMS.register("spawn_egg_" + name, () -> new ForgeSpawnEggItem(reg, eggColor, dotsColor, EndItems.makeEndItemSettings()));
		return reg;
	}

	@SubscribeEvent
	public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(DRAGONFLY.get(), DragonflyEntity.createMobAttributes().build());
		event.put(END_SLIME.get(), EndSlimeEntity.createMobAttributes().build());
		event.put(END_FISH.get(), EndFishEntity.createMobAttributes().build());
		event.put(SHADOW_WALKER.get(), ShadowWalkerEntity.createMobAttributes().build());
		event.put(CUBOZOA.get(), CubozoaEntity.createMobAttributes().build());
		event.put(SILK_MOTH.get(), SilkMothEntity.createMobAttributes().build());
	}

}