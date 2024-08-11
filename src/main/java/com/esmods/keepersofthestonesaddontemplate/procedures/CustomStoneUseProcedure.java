package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

public class CustomStoneUseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) == 0 && entity instanceof Player || entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers < 3 && entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers >= 1)
				&& entity.getData(PowerModVariables.PLAYER_VARIABLES).battery == false && itemstack.getOrCreateTag().getDouble("rechargeStone") == 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerTemplateModItems.CUSTOM_STONE.get()) {
				itemstack.shrink(1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerTemplateModMobEffects.CUSTOM_MASTER.get(), (int) ((double) PowerConfigConfiguration.THE_DURATION_OF_THE_STONE_POWER.get() * 20), 0, false, false));
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.mergers = (entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers + 1);
					_vars.syncPlayerVariables(entity);
				}
				{
					PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
					_vars.power = entity.getData(PowerModVariables.PLAYER_VARIABLES).max_power;
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
