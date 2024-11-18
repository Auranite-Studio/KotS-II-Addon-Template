package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraft.world.item.ItemStack;

public class GetRechargeStoneStateProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("rechargeStone") > 0) {
			return 1;
		}
		return 0;
	}
}
