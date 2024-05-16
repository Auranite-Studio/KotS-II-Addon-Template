
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.tcpmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import com.esmods.tcpmod.procedures.GetRechargeStoneStateProcedure;
import com.esmods.tcpmod.item.CustomSwordItem;
import com.esmods.tcpmod.item.CustomStoneItem;
import com.esmods.tcpmod.item.CustomArmorItem;
import com.esmods.tcpmod.TcpmodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TcpmodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TcpmodMod.MODID);
	public static final RegistryObject<Item> CUSTOM_STONE = REGISTRY.register("custom_stone", () -> new CustomStoneItem());
	public static final RegistryObject<Item> CUSTOM_ARMOR_HELMET = REGISTRY.register("custom_armor_helmet", () -> new CustomArmorItem.Helmet());
	public static final RegistryObject<Item> CUSTOM_ARMOR_CHESTPLATE = REGISTRY.register("custom_armor_chestplate", () -> new CustomArmorItem.Chestplate());
	public static final RegistryObject<Item> CUSTOM_ARMOR_LEGGINGS = REGISTRY.register("custom_armor_leggings", () -> new CustomArmorItem.Leggings());
	public static final RegistryObject<Item> CUSTOM_ARMOR_BOOTS = REGISTRY.register("custom_armor_boots", () -> new CustomArmorItem.Boots());
	public static final RegistryObject<Item> CUSTOM_SWORD = REGISTRY.register("custom_sword", () -> new CustomSwordItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(CUSTOM_STONE.get(), new ResourceLocation("tcpmod:custom_stone_rechage"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) GetRechargeStoneStateProcedure.execute(itemStackToRender));
		});
	}
}
