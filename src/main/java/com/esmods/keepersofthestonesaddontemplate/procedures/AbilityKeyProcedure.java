package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

@EventBusSubscriber
public class AbilityKeyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).use_ability_key_var) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).ability_block == false) {
				if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("custom") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("custom")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("custom") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_first).equals("custom")
						|| (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_second).equals("custom") || (entity.getData(PowerModVariables.PLAYER_VARIABLES).fake_element_name_third).equals("custom")) {
					CustomSpecialAttackProcedure.execute(entity);
				}
			}
		}
	}
}
