package ru.betterend.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public enum ModEnvironment {
    CLIENT,
    SERVER,
    UNIVERSAL;

    public boolean matches(Dist type) {
        switch (this) {
            case CLIENT:
                return type == Dist.CLIENT;
            case SERVER:
                return type == Dist.DEDICATED_SERVER;
            case UNIVERSAL:
                return true;
            default:
                return false;
        }
    }
}
