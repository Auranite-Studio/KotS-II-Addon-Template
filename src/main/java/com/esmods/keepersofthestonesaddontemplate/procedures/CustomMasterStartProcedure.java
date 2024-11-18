package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

public class CustomMasterStartProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.active_power = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).mergers == 0) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_HELMET.get()));
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_CHESTPLATE.get()));
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_BOOTS.get()));
				}
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			{
				String _setval = "custom";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_first = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).mergers == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
				}
			}
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_BOOTS.get()));
				}
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			{
				String _setval = "custom";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_second = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).mergers == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PowerTemplateModItems.CUSTOM_ARMOR_LEGGINGS.get()));
				}
			}
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.BINDING_CURSE, 1);
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
			{
				String _setval = "custom";
				entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.element_name_third = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(PowerTemplateModItems.CUSTOM_SWORD.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Enchantments.VANISHING_CURSE, 1);
	}
}
