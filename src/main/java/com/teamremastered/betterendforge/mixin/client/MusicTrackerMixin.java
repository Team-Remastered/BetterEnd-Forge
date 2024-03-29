package com.teamremastered.betterendforge.mixin.client;

import com.teamremastered.betterendforge.client.ClientOptions;
import com.teamremastered.betterendforge.registry.world.EndBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(MusicManager.class)
public abstract class MusicTrackerMixin {
	@Final
	@Shadow
	private Minecraft minecraft;
	
	@Final
	@Shadow
	private Random random;
	
	@Shadow
	private SoundInstance currentMusic;
	
	@Shadow
	private int nextSongDelay;
	
	private static float volume = 1;
	private static float srcVolume = 0;
	private static long time;
	
	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	public void be_onTick(CallbackInfo info) {
		if (ClientOptions.blendBiomeMusic()) {
			Music musicSound = minecraft.getSituationalMusic();
			if (be_checkNullSound(musicSound) && volume > 0 && be_shouldChangeSound(musicSound) && be_isCorrectBiome()) {
				if (volume > 0) {
					if (srcVolume < 0) {
						srcVolume = currentMusic.getVolume();
					}
					if (currentMusic instanceof AbstractSoundInstance) {
						((AbstractSoundInstanceAccessor) currentMusic).setVolume(volume);
					}
					minecraft.getSoundManager()
							 .updateSourceVolume(currentMusic.getSource(), currentMusic.getVolume() * volume);
					long t = System.currentTimeMillis();
					if (volume == 1 && time == 0) {
						time = t;
					}
					float delta = (t - time) * 0.0005F;
					time = t;
					volume -= delta;
					if (volume < 0) {
						volume = 0;
					}
				}
				if (volume == 0) {
					volume = 1;
					time = 0;
					srcVolume = -1;
					this.minecraft.getSoundManager().stop(this.currentMusic);
					this.nextSongDelay = Mth.nextInt(this.random, 0, musicSound.getMinDelay() / 2);
					this.currentMusic = null;
				}
				if (this.currentMusic == null && this.nextSongDelay-- <= 0) {
					this.startPlaying(musicSound);
				}
				info.cancel();
			}
			else {
				volume = 1;
			}
		}
	}
	
//	private boolean be_isCorrectBiome() {
//		if (minecraft.level == null) {
//			return false;
//		}
//		return BiomeAPI.getRenderBiome(minecraft.level.getBiome(minecraft.player.blockPosition()).value()) instanceof EndBiome;
//	}

	private boolean be_isCorrectBiome() {
		if (minecraft.level == null) {
			return false;
		}
		for(RegistryObject<Biome> biome : EndBiomes.BIOMES.getEntries().stream().toList()) {
			if (minecraft.level.getBiome(minecraft.player.blockPosition()).value() == biome.get()) {
				return true;
			}
		}
		return false;
	}
	
	private boolean be_shouldChangeSound(Music musicSound) {
		return currentMusic != null && !musicSound
			.getEvent()
			.getLocation()
			.equals(this.currentMusic.getLocation()) && musicSound.replaceCurrentMusic();
	}
	
	private boolean be_checkNullSound(Music musicSound) {
		return musicSound != null && musicSound.getEvent() != null;
	}
	
	@Shadow
	public abstract void startPlaying(Music type);
}
