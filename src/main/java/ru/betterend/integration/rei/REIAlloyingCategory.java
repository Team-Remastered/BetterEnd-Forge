package ru.betterend.integration.rei;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import org.jetbrains.annotations.NotNull;
import ru.betterend.registry.EndBlocks;

import java.text.DecimalFormat;
import java.util.List;

public class REIAlloyingCategory implements DisplayCategory<REIAlloyingDisplay> {
	private final EntryStack ICON;
	
	REIAlloyingCategory(EntryStack icon) {
		ICON = icon;
	}
	
	@Override
	public @NotNull CategoryIdentifier getCategoryIdentifier() {
		return REIPlugin.ALLOYING;
	}
	
	@Override
	public @NotNull Component getTitle() {
		return new TranslatableComponent(EndBlocks.END_STONE_SMELTER.get().getDescriptionId());
	}
	
	@Override
	public @NotNull EntryStack getIcon() {
		return ICON;
	}
	
	@Override
	public @NotNull List<Widget> setupDisplay(REIAlloyingDisplay display, Rectangle bounds) {
		Point startPoint = new Point(bounds.getCenterX() - 41, bounds.y + 10);
		double smeltTime = display.getSmeltTime();
		DecimalFormat df = new DecimalFormat("###.##");
		List<Widget> widgets = Lists.newArrayList();
		widgets.add(Widgets.createRecipeBase(bounds));
		widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 9)));
		widgets.add(Widgets.createBurningFire(new Point(startPoint.x - 9, startPoint.y + 20))
						   .animationDurationMS(10000));
		widgets.add(Widgets.createLabel(
			new Point(bounds.x + bounds.width - 5, bounds.y + 5),
			new TranslatableComponent("category.rei.cooking.time&xp",
				df.format(display.getXp()),
				df.format(smeltTime / 20D)
			)
		).noShadow().rightAligned().color(0xFF404040, 0xFFBBBBBB));
		widgets.add(Widgets.createArrow(new Point(startPoint.x + 24, startPoint.y + 8))
						   .animationDurationTicks(smeltTime));
		List<EntryIngredient> inputEntries = display.getInputEntries();
		widgets.add(Widgets.createSlot(new Point(startPoint.x - 20, startPoint.y + 1))
						   .entries(inputEntries.get(0))
						   .markInput());
		if (inputEntries.size() > 1) {
			widgets.add(Widgets.createSlot(new Point(startPoint.x + 1, startPoint.y + 1))
							   .entries(inputEntries.get(1))
							   .markInput());
		}
		else {
			widgets.add(Widgets.createSlot(new Point(startPoint.x + 1, startPoint.y + 1))
							   .entries(Lists.newArrayList())
							   .markInput());
		}
		widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 9))
						   .entries(display.getOutputEntries().get(0))
						   .disableBackground()
						   .markOutput());
		return widgets;
	}

	//TODO: 1.18 REI find replacement
	//@Override
	public void renderRedSlots(PoseStack matrices, List<Widget> widgets, Rectangle bounds, REIAlloyingDisplay display, IntList redSlots) {
		Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 27);
		matrices.pushPose();
		matrices.translate(0, 0, 400);
		if (redSlots.contains(0)) {
			GuiComponent.fill(
				matrices,
				startPoint.x - 20,
				startPoint.y + 1,
				startPoint.x - 20 + 16,
				startPoint.y + 1 + 16,
				1090453504
			);
			GuiComponent.fill(
				matrices,
				startPoint.x + 1,
				startPoint.y + 1,
				startPoint.x + 1 + 16,
				startPoint.y + 1 + 16,
				1090453504
			);
		}
		matrices.popPose();
	}
	
	@Override
	public int getDisplayHeight() {
		return 49;
	}
}
