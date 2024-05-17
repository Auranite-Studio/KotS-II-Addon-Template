package com.esmods.tcpmod.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CustomAttack1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "custom_attack_1";
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.attack = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
