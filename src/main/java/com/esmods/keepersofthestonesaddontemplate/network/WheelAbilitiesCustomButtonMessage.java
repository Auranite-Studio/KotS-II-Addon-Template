
package com.esmods.keepersofthestonesaddontemplate.network;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record WheelAbilitiesCustomButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(PowerTemplateMod.MODID, "wheel_abilities_custom_buttons");
	public WheelAbilitiesCustomButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(buttonID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final WheelAbilitiesCustomButtonMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				Player entity = context.player().get();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
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
		PowerTemplateMod.addNetworkMessage(WheelAbilitiesCustomButtonMessage.ID, WheelAbilitiesCustomButtonMessage::new, WheelAbilitiesCustomButtonMessage::handleData);
	}
}
