
package com.esmods.keepersofthestonesaddontemplate.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.List;

import com.mojang.serialization.MapCodec;

import com.esmods.keepersofthestonesaddontemplate.procedures.RechargeStoneTickEventProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.RechargeInfoGetterProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.GetRechargeStoneStateProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomStoneUseProcedure;

public class CustomStoneItem extends Item {
	public CustomStoneItem(Item.Properties properties) {
		super(properties.rarity(Rarity.COMMON).stacksTo(64));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		String hoverText = RechargeInfoGetterProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				list.add(Component.literal(line));
			}
		}
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		CustomStoneUseProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		RechargeStoneTickEventProcedure.execute(world, itemstack);
	}

	public record RechageProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<RechageProperty> MAP_CODEC = MapCodec.unit(new RechageProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) GetRechargeStoneStateProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<RechageProperty> type() {
			return MAP_CODEC;
		}
	}
}
