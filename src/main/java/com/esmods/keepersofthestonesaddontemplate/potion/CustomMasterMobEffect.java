
package com.esmods.keepersofthestonesaddontemplate.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.esmods.keepersofthestonesaddontemplate.procedures.EnhancedAbilitiesProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomMasterStartProcedure;

public class CustomMasterMobEffect extends MobEffect {
	public CustomMasterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16764109);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		CustomMasterStartProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		EnhancedAbilitiesProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
