package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

@Mod.EventBusSubscriber
public class ReturnStoneAfterDeathProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_power) {
			if (!(entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_battery) {
				if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_first).equals("custom")) {
					{
						String _setval = "0";
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.element_name_first = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PowerTemplateModItems.CUSTOM_STONE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_second).equals("custom")) {
					{
						String _setval = "0";
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.element_name_second = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PowerTemplateModItems.CUSTOM_STONE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).element_name_third).equals("custom")) {
					{
						String _setval = "0";
						entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.element_name_third = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PowerTemplateModItems.CUSTOM_STONE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
