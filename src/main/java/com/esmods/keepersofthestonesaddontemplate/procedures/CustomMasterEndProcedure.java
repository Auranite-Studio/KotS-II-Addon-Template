package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import com.esmods.keepersofthestonestwo.procedures.MasterEffectEndControlProcedure;
import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

public class CustomMasterEndProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("power:stone_deactivation")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		MasterEffectEndControlProcedure.execute(world, entity);
		{
			PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
			_vars.detransf_key_var = true;
			_vars.syncPlayerVariables(entity);
		}
		if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_first).equals("custom")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_first = "0";
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_second).equals("custom")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_second = "0";
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity.getData(PowerModVariables.PLAYER_VARIABLES).element_name_third).equals("custom")) {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.element_name_third = "0";
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(PowerModVariables.PLAYER_VARIABLES).active_battery == false) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PowerTemplateModItems.CUSTOM_STONE.get());
				_setstack.setCount(1);
				CustomData.update(DataComponents.CUSTOM_DATA, _setstack,
						tag -> tag.putDouble("rechargeStone", (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) ? entity.getData(PowerModVariables.PLAYER_VARIABLES).recharge_timer * 20 : 0)));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			{
				PowerModVariables.PlayerVariables _vars = entity.getData(PowerModVariables.PLAYER_VARIABLES);
				_vars.active_battery = false;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
