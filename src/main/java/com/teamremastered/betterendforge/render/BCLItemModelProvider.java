package com.teamremastered.betterendforge.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.registry.EndBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class BCLItemModelProvider extends ItemModelProvider {
    public BCLItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    /** For blocks added manually that don't have a BlockItem **/
    private List<RegistryObject<Block>> BlockItemList(List<RegistryObject<Block>> registeredBlockList) {
        List<RegistryObject<Block>> filteredList = new ArrayList<RegistryObject<net.minecraft.world.level.block.Block>>();
        List<RegistryObject<Block>> filteredBlockItemList = new ArrayList<RegistryObject<net.minecraft.world.level.block.Block>>();

        ExistingFileHelper.ResourceType pathToBlockStates = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "blockstates");
        for (RegistryObject<net.minecraft.world.level.block.Block> registeredBlock : registeredBlockList) {
            if (existingFileHelper.exists(registeredBlock.getId(), pathToBlockStates)) {
                filteredList.add(registeredBlock);
            }
        }

        ExistingFileHelper.ResourceType pathToBlockItems = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models/item");
        ExistingFileHelper.ResourceType pathToBlockModels = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "models/block");
        for (RegistryObject<Block> registeredBlock : filteredList) {
            if (!existingFileHelper.exists(registeredBlock.getId(), pathToBlockItems) && existingFileHelper.exists(registeredBlock.getId(), pathToBlockModels)) {
                filteredBlockItemList.add(registeredBlock);
            }
        }

        return filteredBlockItemList;
    }

    @Override
    protected void registerModels() {

        List<RegistryObject<Block>> blockItemList = new ArrayList<>();
        blockItemList.add(EndBlocks.END_LOTUS_FLOWER);
        blockItemList.add(EndBlocks.LACUGROVE.bark);
        blockItemList.add(EndBlocks.LACUGROVE.log);
        blockItemList.add(EndBlocks.DRAGON_TREE.log);
        blockItemList.add(EndBlocks.TENANEA_LEAVES);
        blockItemList.add(EndBlocks.UMBRELLA_TREE_MEMBRANE);
        blockItemList.add(EndBlocks.LUCERNIA.log);
        blockItemList.add(EndBlocks.LUCERNIA.bark);
        blockItemList.add(EndBlocks.BLUE_VINE);
        blockItemList.add(EndBlocks.TERMINITE.block);

        //FIXME: Can't use the filtered list because the blocks are removed from the list the second time the blockItem registry is called
        //FIXME: since they have already been generated somewhere. Thus, I needed to add the blocks manually.
        List<RegistryObject<Block>> filteredBlockItemList = BlockItemList(EndBlocks.registeredBetterEndBlocks);

        /** Register Manually added BlockItems **/

        for (RegistryObject<Block> registeredBlock : blockItemList) {
            withExistingParent(registeredBlock.getId().getPath(), modLoc("block/" + registeredBlock.getId().getPath()));
        }
    }
}