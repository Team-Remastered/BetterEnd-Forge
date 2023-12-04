package com.teamremastered.betterendforge.render;

import com.teamremastered.betterendforge.BetterEndForge;
import com.teamremastered.betterendforge.interfaces.IBCLItemModelProvider;
import com.teamremastered.betterendforge.registry.EndBlocks;
import com.teamremastered.betterendforge.registry.EndItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
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

    /**
     * Removes every item that already have a designed model inside the Resource directory
     * to avoid duplicates and crash the data generation.
     *
     * I created a duplicate folder because the function keeps returning an empty list the second time
     * it runs; we should find a way to fix this issue and just be able to check the model folder directly.
     **/

    private List<RegistryObject<Item>> filteredItemList(List<RegistryObject<Item>> registeredItemList) {

        List<RegistryObject<Item>> filteredList = new ArrayList<>();
        ExistingFileHelper.ResourceType pathToitemModels = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".json", "duplicates/item");

        for (RegistryObject<Item> registeredItem : registeredItemList) {
            if (!existingFileHelper.exists(registeredItem.getId(), pathToitemModels)) {
                filteredList.add(registeredItem);
            }
        }

        return filteredList;
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

        for (RegistryObject<Item> registeredItem : filteredItemList(EndItems.ITEMS.getEntries().stream().toList())) {
            if (registeredItem.get() instanceof IBCLItemModelProvider item) {
                item.createGeneratedData(this, registeredItem.get());
            } else if (registeredItem.get() instanceof ForgeSpawnEggItem) {
                withExistingParent(registeredItem.getId().getPath(), new ResourceLocation("minecraft", "template_spawn_egg"));
            }
            else  {
            basicItem(registeredItem.get());
            }
            BetterEndForge.LOGGER.info("Registered items are: " + registeredItem.getId().getPath());
        }
    }
}