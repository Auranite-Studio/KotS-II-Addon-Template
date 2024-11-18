
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.esmods.keepersofthestonesaddontemplate.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PowerTemplateMod.MODID);
	public static final RegistryObject<MenuType<WheelAbilitiesCustomMenu>> WHEEL_ABILITIES_CUSTOM = REGISTRY.register("wheel_abilities_custom", () -> IForgeMenuType.create(WheelAbilitiesCustomMenu::new));
}
