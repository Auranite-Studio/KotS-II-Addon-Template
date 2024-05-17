
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.tcpmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.esmods.tcpmod.TcpmodMod;
import com.esmods.keepersofthestonestwo.init.PowerModItems;

public class TcpmodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TcpmodMod.MODID);
	public static final RegistryObject<CreativeModeTab> CUSTOM_STONES = REGISTRY.register("custom_stones",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tcpmod.custom_stones")).icon(() -> new ItemStack(PowerModItems.TELEPORTATION_STONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TcpmodModItems.CUSTOM_STONE.get());
			})

					.build());
}
