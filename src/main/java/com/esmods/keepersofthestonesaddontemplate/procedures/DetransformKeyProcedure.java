package com.esmods.keepersofthestonesaddontemplate.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.esmods.keepersofthestonestwo.network.PowerModVariables;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModMobEffects;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

@Mod.EventBusSubscriber
public class DetransformKeyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PowerModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PowerModVariables.PlayerVariables())).detransf_key_var) {
			PowerTemplateMod.queueServerWork(1, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(PowerTemplateModMobEffects.CUSTOM_MASTER.get());
			});
		}
	}
}
