
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.keepersofthestonesaddontemplate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonesaddontemplate.item.CustomSwordItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomStoneItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomBatteryItem;
import com.esmods.keepersofthestonesaddontemplate.item.CustomArmorItem;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class PowerTemplateModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PowerTemplateMod.MODID);
	public static final DeferredItem<Item> CUSTOM_STONE = REGISTRY.registerItem("custom_stone", CustomStoneItem::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_ARMOR_HELMET = REGISTRY.registerItem("custom_armor_helmet", CustomArmorItem.Helmet::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_ARMOR_CHESTPLATE = REGISTRY.registerItem("custom_armor_chestplate", CustomArmorItem.Chestplate::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_ARMOR_LEGGINGS = REGISTRY.registerItem("custom_armor_leggings", CustomArmorItem.Leggings::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_ARMOR_BOOTS = REGISTRY.registerItem("custom_armor_boots", CustomArmorItem.Boots::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_SWORD = REGISTRY.registerItem("custom_sword", CustomSwordItem::new, new Item.Properties());
	public static final DeferredItem<Item> CUSTOM_BATTERY = REGISTRY.registerItem("custom_battery", CustomBatteryItem::new, new Item.Properties());

	// Start of user code block custom items
	// End of user code block custom items
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(ResourceLocation.parse("power_template:custom_stone/rechage"), CustomStoneItem.RechageProperty.MAP_CODEC);
		}
	}
}
