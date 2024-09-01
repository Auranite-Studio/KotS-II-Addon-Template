package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonestwo.configuration.PowerConfigConfiguration;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

public class CustomStoneUseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("power:passing_armor"))) && entity instanceof Player
				|| entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers < 3 && entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers >= 1) && entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false
				&& itemstack.getOrCreateTag().getDouble("rechargeStone") == 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerTemplateModItems.CUSTOM_STONE.get()) {
				itemstack.shrink(1);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerTemplateModMobEffects.CUSTOM_MASTER.get(), (int) ((double) PowerConfigConfiguration.MASTER_EFFECT_DURATION.get() * 20), 0, false, false));
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
					_vars.send_client_package = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
