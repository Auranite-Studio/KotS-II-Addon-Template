package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.procedures.SendClientPackageActivationStoneVFXProcedure;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class CustomBatteryUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor"))) && entity instanceof Player
				&& (entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).active_power == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerTemplateModItems.CUSTOM_BATTERY.get()) {
				PowerTemplateMod.queueServerWork(1, () -> {
					itemstack.shrink(1);
				});
				{
					boolean _setval = true;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.active_battery = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerTemplateModMobEffects.CUSTOM_MASTER.get(), (int) ((PowerModVariables.master_effect_duration * 20) / 2), 0, false, false));
				{
					double _setval = ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).mergers + 1);
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mergers = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 500;
					entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.power = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				SendClientPackageActivationStoneVFXProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
