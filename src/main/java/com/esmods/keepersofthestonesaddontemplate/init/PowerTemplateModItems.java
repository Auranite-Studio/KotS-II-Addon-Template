
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.item.ItemProperties;

import com.esmods.keepersofthestonesaddontemplate.procedures.GetRechargeStoneStateProcedure;
import com.esmods.keepersofthestonesaddontemplate.item.CustomSwordItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomStoneItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomBatteryItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomArmorItem;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, PowerTemplateMod.MODID);
	public static final DeferredHolder<Item, Item> CUSTOM_STONE = REGISTRY.register("custom_stone", () -> new CustomStoneItem());
	public static final DeferredHolder<Item, Item> CUSTOM_ARMOR_HELMET = REGISTRY.register("custom_armor_helmet", () -> new CustomArmorItem.Helmet());
	public static final DeferredHolder<Item, Item> CUSTOM_ARMOR_CHESTPLATE = REGISTRY.register("custom_armor_chestplate", () -> new CustomArmorItem.Chestplate());
	public static final DeferredHolder<Item, Item> CUSTOM_ARMOR_LEGGINGS = REGISTRY.register("custom_armor_leggings", () -> new CustomArmorItem.Leggings());
	public static final DeferredHolder<Item, Item> CUSTOM_ARMOR_BOOTS = REGISTRY.register("custom_armor_boots", () -> new CustomArmorItem.Boots());
	public static final DeferredHolder<Item, Item> CUSTOM_SWORD = REGISTRY.register("custom_sword", () -> new CustomSwordItem());
	public static final DeferredHolder<Item, Item> CUSTOM_BATTERY = REGISTRY.register("custom_battery", () -> new CustomBatteryItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(CUSTOM_STONE.get(), new ResourceLocation("power_template:custom_stone_rechage"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GetRechargeStoneStateProcedure.execute(itemStackToRender));
			});
		}
	}
}
