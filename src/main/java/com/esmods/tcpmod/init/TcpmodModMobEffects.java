
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.esmods.tcpmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import com.esmods.tcpmod.potion.CustomMasterMobEffect;
import com.esmods.tcpmod.TcpmodMod;

public class TcpmodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TcpmodMod.MODID);
	public static final RegistryObject<MobEffect> CUSTOM_MASTER = REGISTRY.register("custom_master", () -> new CustomMasterMobEffect());
}
