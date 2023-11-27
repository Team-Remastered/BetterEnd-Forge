package com.teamremastered.betterendforge.mixin.common.bclib;

import com.teamremastered.betterendforge.bclib.api.LifeCycleAPI;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.server.Main;
import net.minecraft.server.dedicated.DedicatedServerSettings;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.teamremastered.betterendforge.bclib.api.datafixer.DataFixerAPI;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Mixin(Main.class)
abstract public class MainMixin {
	@Inject(method="main", at=@At(value="INVOKE", target="Lnet/minecraft/world/level/storage/LevelStorageSource;createDefault(Ljava/nio/file/Path;)Lnet/minecraft/world/level/storage/LevelStorageSource;"))
	private static void bclib_callServerFix(String[] args, CallbackInfo ci){
		OptionParser parser = new OptionParser();
		ArgumentAcceptingOptionSpec<String> optionUniverse = parser.accepts("universe").withRequiredArg().defaultsTo(".", (String[])new String[0]);
		ArgumentAcceptingOptionSpec<String> optionWorld = parser.accepts("world").withRequiredArg();
		
		//this is only for compat reasons, we do not need to read thise options in our mixin, but it seems to cause
		//errors if they are not defined
		parser.accepts("nogui");
		parser.accepts("initSettings", "Initializes 'server.properties' and 'eula.txt', then quits");
		parser.accepts("demo");
		parser.accepts("bonusChest");
		parser.accepts("forceUpgrade");
		parser.accepts("eraseCache");
		parser.accepts("safeMode", "Loads level with vanilla datapack only");
		parser.accepts("help").forHelp();
		parser.accepts("singleplayer").withRequiredArg();
		parser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(-1, (Integer[])new Integer[0]);
		parser.accepts("serverId").withRequiredArg();
		parser.accepts("jfrProfile");
		parser.nonOptions();
		
		OptionSet options = parser.parse(args);

		Path settingPath = Paths.get("server.properties", new String[0]);
		DedicatedServerSettings settings = new DedicatedServerSettings(settingPath);

		File file = new File(options.valueOf(optionUniverse));
		String levelID = Optional.ofNullable(options.valueOf(optionWorld)).orElse(settings.getProperties().levelName);

		LevelStorageSource levelStorageSource = LevelStorageSource.createDefault(file.toPath());
		DataFixerAPI.fixData(levelStorageSource, levelID, false, (didFix)->{/* not called when showUI==false */});

		LifeCycleAPI._runBeforeLevelLoad();
	}
}
