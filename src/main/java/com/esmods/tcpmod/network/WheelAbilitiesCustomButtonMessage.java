
package com.esmods.tcpmod.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import com.esmods.tcpmod.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.tcpmod.procedures.WheelKeyProcedure;
import com.esmods.tcpmod.procedures.CustomAttack3Procedure;
import com.esmods.tcpmod.procedures.CustomAttack2Procedure;
import com.esmods.tcpmod.procedures.CustomAttack1Procedure;
import com.esmods.tcpmod.TcpmodMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WheelAbilitiesCustomButtonMessage {
	private final int buttonID, x, y, z;

	public WheelAbilitiesCustomButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WheelAbilitiesCustomButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WheelAbilitiesCustomButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WheelAbilitiesCustomButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = WheelAbilitiesCustomMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			WheelKeyProcedure.execute(world, x, y, z, entity);
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
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TcpmodMod.addNetworkMessage(WheelAbilitiesCustomButtonMessage.class, WheelAbilitiesCustomButtonMessage::buffer, WheelAbilitiesCustomButtonMessage::new, WheelAbilitiesCustomButtonMessage::handler);
	}
}
