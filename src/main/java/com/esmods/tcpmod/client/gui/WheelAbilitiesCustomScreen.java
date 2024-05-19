package com.esmods.tcpmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

import com.esmods.tcpmod.world.inventory.WheelAbilitiesCustomMenu;
import com.esmods.tcpmod.procedures.GetWheelTwoProcedure;
import com.esmods.tcpmod.procedures.GetWheelThreeProcedure;
import com.esmods.tcpmod.network.WheelAbilitiesCustomButtonMessage;
import com.esmods.tcpmod.TcpmodMod;

public class WheelAbilitiesCustomScreen extends AbstractContainerScreen<WheelAbilitiesCustomMenu> {
	private final static HashMap<String, Object> guistate = WheelAbilitiesCustomMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_wheel_button_1;
	ImageButton imagebutton_wheel_button_2;
	ImageButton imagebutton_wheel_button_3;
	ImageButton imagebutton_ability_1;
	ImageButton imagebutton_ability_2;
	ImageButton imagebutton_ability_3;

	public WheelAbilitiesCustomScreen(WheelAbilitiesCustomMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 192;
		this.imageHeight = 192;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 84 && mouseX < leftPos + 108 && mouseY > topPos + 22 && mouseY < topPos + 46)
			guiGraphics.renderTooltip(font, Component.translatable("gui.tcpmod.wheel_abilities_custom.tooltip_custom_attack_1_uses_10"), mouseX, mouseY);
		if (mouseX > leftPos + 144 && mouseX < leftPos + 168 && mouseY > topPos + 84 && mouseY < topPos + 108)
			guiGraphics.renderTooltip(font, Component.translatable("gui.tcpmod.wheel_abilities_custom.tooltip_custom_attack_2_uses_10"), mouseX, mouseY);
		if (mouseX > leftPos + 82 && mouseX < leftPos + 106 && mouseY > topPos + 144 && mouseY < topPos + 168)
			guiGraphics.renderTooltip(font, Component.translatable("gui.tcpmod.wheel_abilities_custom.tooltip_custom_attack_3_uses_10"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("tcpmod:textures/screens/wheel_of_abilities.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 192, 192, 192, 192);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_wheel_button_1 = new ImageButton(this.leftPos + 140, this.topPos + 154, 10, 7, 0, 0, 7, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_wheel_button_1.png"), 10, 14, e -> {
			if (GetWheelTwoProcedure.execute(entity)) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(0, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (GetWheelTwoProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_wheel_button_1", imagebutton_wheel_button_1);
		this.addRenderableWidget(imagebutton_wheel_button_1);
		imagebutton_wheel_button_2 = new ImageButton(this.leftPos + 152, this.topPos + 154, 10, 7, 0, 0, 7, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_wheel_button_2.png"), 10, 14, e -> {
			if (GetWheelTwoProcedure.execute(entity)) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(1, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (GetWheelTwoProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_wheel_button_2", imagebutton_wheel_button_2);
		this.addRenderableWidget(imagebutton_wheel_button_2);
		imagebutton_wheel_button_3 = new ImageButton(this.leftPos + 164, this.topPos + 154, 10, 7, 0, 0, 7, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_wheel_button_3.png"), 10, 14, e -> {
			if (GetWheelThreeProcedure.execute(entity)) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(2, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (GetWheelThreeProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_wheel_button_3", imagebutton_wheel_button_3);
		this.addRenderableWidget(imagebutton_wheel_button_3);
		imagebutton_ability_1 = new ImageButton(this.leftPos + 72, this.topPos + 12, 46, 46, 0, 0, 46, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_ability_1.png"), 46, 92, e -> {
			if (true) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(3, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_ability_1", imagebutton_ability_1);
		this.addRenderableWidget(imagebutton_ability_1);
		imagebutton_ability_2 = new ImageButton(this.leftPos + 133, this.topPos + 73, 46, 46, 0, 0, 46, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_ability_2.png"), 46, 92, e -> {
			if (true) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(4, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_ability_2", imagebutton_ability_2);
		this.addRenderableWidget(imagebutton_ability_2);
		imagebutton_ability_3 = new ImageButton(this.leftPos + 72, this.topPos + 134, 46, 46, 0, 0, 46, new ResourceLocation("tcpmod:textures/screens/atlas/imagebutton_ability_3.png"), 46, 92, e -> {
			if (true) {
				TcpmodMod.PACKET_HANDLER.sendToServer(new WheelAbilitiesCustomButtonMessage(5, x, y, z));
				WheelAbilitiesCustomButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_ability_3", imagebutton_ability_3);
		this.addRenderableWidget(imagebutton_ability_3);
	}
}
