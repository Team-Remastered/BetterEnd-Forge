package ru.betterend.interfaces;

import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import ru.betterend.registry.EndItems;

public interface MultiModelItem {
	@OnlyIn(Dist.CLIENT)
	void registerModelPredicate();
	
	static void register() {
		EndItems.getModItems().forEach(item -> {
			if (item instanceof MultiModelItem) {
				((MultiModelItem) item).registerModelPredicate();
			}
		});
	}
}
