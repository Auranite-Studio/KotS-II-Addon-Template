package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import com.esmods.keepersofthestonestwo.procedures.SendClientPackageActivationStoneVFXProcedure;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class CustomStoneUseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("power:passing_armor")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("power:passing_armor"))) && entity instanceof Player
				&& entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers < 3 && entity.getData(PowerModVariables.PLAYER_VARIABLES).mergers >= 0 && entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false
				&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rechargeStone") == 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PowerTemplateModItems.CUSTOM_STONE.get()) {
				PowerTemplateMod.queueServerWork(1, () -> {
					itemstack.shrink(1);
				});
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PowerTemplateModMobEffects.CUSTOM_MASTER, (int) (entity.getData(PowerModVariables.PLAYER_VARIABLES).master_effect_duration * 20), 0, false, false));
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
				SendClientPackageActivationStoneVFXProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
