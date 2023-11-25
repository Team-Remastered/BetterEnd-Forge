package ru.betterend.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import ru.betterend.bclib.api.tag.TagAPI;
import ru.betterend.bclib.world.structures.BCLStructureFeature;
import ru.betterend.BetterEndForge;
import ru.betterend.world.structures.features.EternalPortalStructure;
import ru.betterend.world.structures.features.GiantIceStarStructure;
import ru.betterend.world.structures.features.GiantMossyGlowshroomStructure;
import ru.betterend.world.structures.features.MegaLakeSmallStructure;
import ru.betterend.world.structures.features.MegaLakeStructure;
import ru.betterend.world.structures.features.MountainStructure;
import ru.betterend.world.structures.features.PaintedMountainStructure;
import ru.betterend.world.structures.piece.CavePiece;
import ru.betterend.world.structures.piece.CrystalMountainPiece;
import ru.betterend.world.structures.piece.LakePiece;
import ru.betterend.world.structures.piece.NBTPiece;
import ru.betterend.world.structures.piece.PaintedMountainPiece;
import ru.betterend.world.structures.piece.VoxelPiece;

public class EndStructures {
	public static final StructurePieceType VOXEL_PIECE = register("voxel", VoxelPiece::new);
	public static final StructurePieceType MOUNTAIN_PIECE = register("mountain_piece", CrystalMountainPiece::new);
	public static final StructurePieceType CAVE_PIECE = register("cave_piece", CavePiece::new);
	public static final StructurePieceType LAKE_PIECE = register("lake_piece", LakePiece::new);
	public static final StructurePieceType PAINTED_MOUNTAIN_PIECE = register("painted_mountain_piece", PaintedMountainPiece::new);
	public static final StructurePieceType NBT_PIECE = register("nbt_piece", NBTPiece::new);
	
	public static final BCLStructureFeature GIANT_MOSSY_GLOWSHROOM = new BCLStructureFeature(
		BetterEndForge.makeID("giant_mossy_glowshroom"),
		new GiantMossyGlowshroomStructure(),
		Decoration.SURFACE_STRUCTURES,
		16,
		8
	);
	public static final BCLStructureFeature MEGALAKE = new BCLStructureFeature(
		BetterEndForge.makeID("megalake"),
		new MegaLakeStructure(),
		Decoration.RAW_GENERATION,
		4,
		1
	);
	public static final BCLStructureFeature MEGALAKE_SMALL = new BCLStructureFeature(
		BetterEndForge.makeID("megalake_small"),
		new MegaLakeSmallStructure(),
		Decoration.RAW_GENERATION,
		4,
		1
	);
	public static final BCLStructureFeature MOUNTAIN = new BCLStructureFeature(
		BetterEndForge.makeID("mountain"),
		new MountainStructure(),
		Decoration.RAW_GENERATION,
		3,
		2
	);
	public static final BCLStructureFeature PAINTED_MOUNTAIN = new BCLStructureFeature(
		BetterEndForge.makeID("painted_mountain"),
		new PaintedMountainStructure(),
		Decoration.RAW_GENERATION,
		3,
		2
	);
	public static final BCLStructureFeature ETERNAL_PORTAL = new BCLStructureFeature(
		BetterEndForge.makeID("eternal_portal"),
		new EternalPortalStructure(),
		Decoration.SURFACE_STRUCTURES,
		16,
		6
	);
	public static final BCLStructureFeature GIANT_ICE_STAR = new BCLStructureFeature(
		BetterEndForge.makeID("giant_ice_star"),
		new GiantIceStarStructure(),
		Decoration.SURFACE_STRUCTURES,
		16,
		8
	);
	
	private static StructurePieceType register(String id, StructurePieceType pieceType) {
		return Registry.register(Registry.STRUCTURE_PIECE, BetterEndForge.makeID(id), pieceType);
	}
	
	public static void addBiomeStructures(ResourceLocation biomeID, Holder<Biome> biome) {
		if (!biomeID.getPath().contains("mountain") && !biomeID.getPath().contains("lake")) {
			TagAPI.addBiomeTag(ETERNAL_PORTAL.biomeTag, biome.value());
		}
	}
}
