
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.esmods.keepersofthestonesaddontemplate.client.gui.WheelAbilitiesCustomScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PowerTemplateModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PowerTemplateModMenus.WHEEL_ABILITIES_CUSTOM.get(), WheelAbilitiesCustomScreen::new);
		});
	}
}
