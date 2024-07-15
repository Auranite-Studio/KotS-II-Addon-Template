package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class CustomSpecialAttackProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Scaling = 0;
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).attack).equals("custom_attack_1")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 10);
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).attack).equals("custom_attack_2")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 10);
					_vars.syncPlayerVariables(entity);
				}
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).attack).equals("custom_attack_3")) {
			if (entity.getData(PowerModVariables.PLAYER_VARIABLES).power >= 10) {
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = (entity.getData(PowerModVariables.PLAYER_VARIABLES).power - 10);
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
