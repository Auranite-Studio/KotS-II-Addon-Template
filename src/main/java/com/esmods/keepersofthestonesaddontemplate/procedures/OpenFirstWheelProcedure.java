package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.entity.Entity;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class OpenFirstWheelProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.wheel_open_key_var = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}
