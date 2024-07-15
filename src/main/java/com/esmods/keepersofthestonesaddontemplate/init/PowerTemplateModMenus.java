
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import com.esmods.keepersofthestonesaddontemplate.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PowerTemplateMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<WheelAbilitiesCustomMenu>> WHEEL_ABILITIES_CUSTOM = REGISTRY.register("wheel_abilities_custom", () -> IMenuTypeExtension.create(WheelAbilitiesCustomMenu::new));
}
