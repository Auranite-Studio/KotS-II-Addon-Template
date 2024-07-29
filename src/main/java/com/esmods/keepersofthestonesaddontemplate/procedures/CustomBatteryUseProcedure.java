package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class CustomBatteryUseProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) == 0 && entity instanceof Player && entity.getData(PowerModVariables.PLAYER_VARIABLES).active == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerTemplateModItems.CUSTOM_BATTERY.get()) {
				PowerTemplateMod.queueServerWork(1, () -> {
					itemstack.shrink(1);
				});
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.battery = true;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerTemplateModMobEffects.CUSTOM_MASTER.get(), 6000, 0, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.mergers = (entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1);
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = 500;
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.check_activating_stone = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
