package com.teamremastered.betterendforge.interfaces;

import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public interface IBCLItemModelProvider {

    void createGeneratedData(ItemModelProvider modelProvider, Item item);

}
