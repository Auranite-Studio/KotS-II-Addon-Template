package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CustomSpecialAttackProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).ability).equals("custom_attack_1")) {
			if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power >= 10) {
				{
					double _setval = ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power - 10);
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).ability).equals("custom_attack_2")) {
			if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power >= 10) {
				{
					double _setval = ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power - 10);
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).ability).equals("custom_attack_3")) {
			if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power >= 10) {
				{
					double _setval = ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).power - 10);
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
