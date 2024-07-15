
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PowerTemplateMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CUSTOM_STONES = REGISTRY.register("custom_stones",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.power_template.custom_stones")).icon(() -> new ItemStack(PowerTemplateModItems.CUSTOM_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PowerTemplateModItems.CUSTOM_STONE.get());
			})

					.build());
}
