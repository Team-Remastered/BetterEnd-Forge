package com.teamremastered.betterendforge.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import com.teamremastered.betterendforge.BetterEndForge;

public class EndConfig {
    private static final ForgeConfigSpec.Builder CONFIG = new ForgeConfigSpec.Builder();
    private static ForgeConfigSpec COMMON_CONFIG;

    static {
        init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_CONFIG, BetterEndForge.CONFIG_FILE);
    }

    private static void init() {
        CONFIG.push(BetterEndForge.MOD_ID);

        // Add all the custom config values to the config file
        for (EndConfigGenericEntry<?> ccv : EndConfigGenericEntry.endConfigGenericEntries) {
            ccv.setup(CONFIG);
        }

        CONFIG.pop();
        COMMON_CONFIG = CONFIG.build();
    }

    public static void load() {
        final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(BetterEndForge.CONFIG_FILE))
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        COMMON_CONFIG.setConfig(configData);
    }
}