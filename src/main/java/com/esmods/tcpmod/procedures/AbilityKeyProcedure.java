package com.esmods.tcpmod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import com.esmods.tcpmod.init.TcpmodModMobEffects;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;

public class AbilityKeyProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).use_ability_key_var) {
			if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).ability_block == false) {
				if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TcpmodModMobEffects.CUSTOM_MASTER.get())) {
					CustomSpecialAttackProcedure.execute(entity);
				}
			}
		}
	}
}
