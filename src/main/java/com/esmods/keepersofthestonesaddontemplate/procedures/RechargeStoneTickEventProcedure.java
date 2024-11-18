package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

public class RechargeStoneTickEventProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		PowerTemplateMod.queueServerWork(1, () -> {
			if (itemstack.getOrCreateTag().getDouble("rechargeStone") > 0) {
				itemstack.getOrCreateTag().putDouble("rechargeStone", (itemstack.getOrCreateTag().getDouble("rechargeStone") - 1));
			}
		});
	}
}
