
package com.esmods.keepersofthestonesaddontemplate.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import java.util.Map;

import com.google.common.collect.Iterables;

import com.esmods.keepersofthestonesaddontemplate.procedures.CustomArmorLeggingsRemoveProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomArmorHelmetRemoveProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomArmorChestplateRemoveProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomArmorBootsRemoveProcedure;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class CustomArmorItem extends ArmorItem {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(37, Map.of(ArmorType.BOOTS, 3, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 8, ArmorType.HELMET, 3, ArmorType.BODY, 8), 1,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("power_template:custom_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("power_template:custom_armor")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power_template:textures/models/armor/custom_armor_layer_1.png");
			}
		}, PowerTemplateModItems.CUSTOM_ARMOR_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power_template:textures/models/armor/custom_armor_layer_1.png");
			}
		}, PowerTemplateModItems.CUSTOM_ARMOR_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power_template:textures/models/armor/custom_armor_layer_2.png");
			}
		}, PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("power_template:textures/models/armor/custom_armor_layer_1.png");
			}
		}, PowerTemplateModItems.CUSTOM_ARMOR_BOOTS.get());
	}

	private CustomArmorItem(ArmorType type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends CustomArmorItem {
		public Helmet(Item.Properties properties) {
			super(ArmorType.HELMET, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				CustomArmorHelmetRemoveProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends CustomArmorItem {
		public Chestplate(Item.Properties properties) {
			super(ArmorType.CHESTPLATE, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				CustomArmorChestplateRemoveProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends CustomArmorItem {
		public Leggings(Item.Properties properties) {
			super(ArmorType.LEGGINGS, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				CustomArmorLeggingsRemoveProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends CustomArmorItem {
		public Boots(Item.Properties properties) {
			super(ArmorType.BOOTS, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				CustomArmorBootsRemoveProcedure.execute(entity);
			}
		}
	}
}
