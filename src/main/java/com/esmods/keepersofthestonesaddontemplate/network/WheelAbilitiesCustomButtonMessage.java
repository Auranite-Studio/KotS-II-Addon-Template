
package com.esmods.keepersofthestonesaddontemplate.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

import com.esmods.keepersofthestonesaddontemplate.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenThirdWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenThirdFakeWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenSecondWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenSecondFakeWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenFirstWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.OpenFirstFakeWheelProcedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomAttack3Procedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomAttack2Procedure;
import com.esmods.keepersofthestonesaddontemplate.procedures.CustomAttack1Procedure;
import com.esmods.keepersofthestonesaddontemplate.PowerTemplateMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesCustomButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<WheelAbilitiesCustomButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PowerTemplateMod.MODID, "wheel_abilities_custom_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, WheelAbilitiesCustomButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, WheelAbilitiesCustomButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new WheelAbilitiesCustomButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<WheelAbilitiesCustomButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final WheelAbilitiesCustomButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = WheelAbilitiesCustomMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenFirstWheelProcedure.execute(entity);
		}
		if (buttonID == 1) {

			OpenSecondWheelProcedure.execute(entity);
		}
		if (buttonID == 2) {

			OpenThirdWheelProcedure.execute(entity);
		}
		if (buttonID == 3) {

			CustomAttack1Procedure.execute(entity);
		}
		if (buttonID == 4) {

			CustomAttack2Procedure.execute(entity);
		}
		if (buttonID == 5) {

			CustomAttack3Procedure.execute(entity);
		}
		if (buttonID == 6) {

			OpenFirstFakeWheelProcedure.execute(entity);
		}
		if (buttonID == 7) {

			OpenSecondFakeWheelProcedure.execute(entity);
		}
		if (buttonID == 8) {

			OpenThirdFakeWheelProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PowerTemplateMod.addNetworkMessage(WheelAbilitiesCustomButtonMessage.TYPE, WheelAbilitiesCustomButtonMessage.STREAM_CODEC, WheelAbilitiesCustomButtonMessage::handleData);
	}
}
