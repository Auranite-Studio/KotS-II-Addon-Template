package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CustomAttack1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "custom_attack_1";
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ability = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
