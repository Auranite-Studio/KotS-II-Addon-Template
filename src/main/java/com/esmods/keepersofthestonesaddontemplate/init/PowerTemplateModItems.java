
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import com.esmods.keepersofthestonesaddontemplate.procedures.GetRechargeStoneStateProcedure;
import com.esmods.keepersofthestonesaddontemplate.item.CustomSwordItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomStoneItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomBatteryItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomArmorItem;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PowerTemplateMod.MODID);
	public static final DeferredItem<Item> CUSTOM_STONE = REGISTRY.register("custom_stone", CustomStoneItem::new);
	public static final DeferredItem<Item> CUSTOM_ARMOR_HELMET = REGISTRY.register("custom_armor_helmet", CustomArmorItem.Helmet::new);
	public static final DeferredItem<Item> CUSTOM_ARMOR_CHESTPLATE = REGISTRY.register("custom_armor_chestplate", CustomArmorItem.Chestplate::new);
	public static final DeferredItem<Item> CUSTOM_ARMOR_LEGGINGS = REGISTRY.register("custom_armor_leggings", CustomArmorItem.Leggings::new);
	public static final DeferredItem<Item> CUSTOM_ARMOR_BOOTS = REGISTRY.register("custom_armor_boots", CustomArmorItem.Boots::new);
	public static final DeferredItem<Item> CUSTOM_SWORD = REGISTRY.register("custom_sword", CustomSwordItem::new);
	public static final DeferredItem<Item> CUSTOM_BATTERY = REGISTRY.register("custom_battery", CustomBatteryItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(CUSTOM_STONE.get(), ResourceLocation.parse("power_template:custom_stone_rechage"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GetRechargeStoneStateProcedure.execute(itemStackToRender));
			});
		}
	}
}
