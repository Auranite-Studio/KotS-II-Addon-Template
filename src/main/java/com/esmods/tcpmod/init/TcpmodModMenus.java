
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.tcpmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.esmods.tcpmod.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.tcpmod.TcpmodMod;

public class TcpmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TcpmodMod.MODID);
	public static final RegistryObject<MenuType<WheelAbilitiesCustomMenu>> WHEEL_ABILITIES_CUSTOM = REGISTRY.register("wheel_abilities_custom", () -> IForgeMenuType.create(WheelAbilitiesCustomMenu::new));
}
