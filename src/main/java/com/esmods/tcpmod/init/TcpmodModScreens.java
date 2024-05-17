
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.tcpmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.esmods.tcpmod.client.gui.WheelAbilitiesCustomScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TcpmodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TcpmodModMenus.WHEEL_ABILITIES_CUSTOM.get(), WheelAbilitiesCustomScreen::new);
		});
	}
}
