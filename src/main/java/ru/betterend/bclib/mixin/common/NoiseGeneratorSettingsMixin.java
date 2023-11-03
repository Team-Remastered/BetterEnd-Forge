package ru.betterend.bclib.mixin.common;

import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.SurfaceRules.RuleSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import ru.betterend.bclib.api.biomes.BiomeAPI;
import ru.betterend.bclib.interfaces.SurfaceRuleProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements SurfaceRuleProvider {
	@Mutable
	@Final
	@Shadow
	private RuleSource surfaceRule;
	
	private RuleSource bclib_originalSurfaceRule;
	private Set<BiomeSource> bclib_biomeSources = new HashSet<>();

	private void bclib_updateCustomRules(){
		bclib_setCustomRules(BiomeAPI.getRuleSources(bclib_biomeSources));
	}

	@Override
	public void bclib_addBiomeSource(BiomeSource source) {
		bclib_biomeSources.add(source);
		bclib_updateCustomRules();
	}

	@Override
	public void bclib_clearBiomeSources(){
		bclib_biomeSources.clear();
		bclib_clearCustomRules();
	}

	private void bclib_clearCustomRules() {
		if (bclib_originalSurfaceRule != null){
			this.surfaceRule = bclib_originalSurfaceRule;
			bclib_originalSurfaceRule = null;
		}
	}
	
	private void bclib_setCustomRules(List<RuleSource> rules) {
		if (rules.size()==0){
			bclib_clearCustomRules();
			return;
		}

		RuleSource org = bclib_getOriginalSurfaceRule();
		if (org instanceof SurfaceRules.SequenceRuleSource sequenceRule){
			List<RuleSource> currentSequence = sequenceRule.sequence();
			rules = rules.stream().filter(r -> currentSequence.indexOf(r)<0).collect(Collectors.toList());
			rules.addAll(sequenceRule.sequence());
		} else {
			rules.add(org);
		}

		bclib_setSurfaceRule(SurfaceRules.sequence(rules.toArray(new RuleSource[rules.size()])));
	}
	
	void bclib_setSurfaceRule(RuleSource surfaceRule) {
		if (bclib_originalSurfaceRule == null){
			bclib_originalSurfaceRule = this.surfaceRule;
		}
		this.surfaceRule = surfaceRule;
	}
	
	RuleSource bclib_getOriginalSurfaceRule() {
		if (bclib_originalSurfaceRule ==null) {
			return surfaceRule;
		}
		
		return bclib_originalSurfaceRule;
	}
	
//	@Inject(method = "surfaceRule", at = @At("HEAD"), cancellable = true)
//	private void bclib_surfaceRule(CallbackInfoReturnable<SurfaceRules.RuleSource> info) {
//		if (bclib_surfaceRule != null) {
//			info.setReturnValue(bclib_surfaceRule);
//		}
//	}
}
