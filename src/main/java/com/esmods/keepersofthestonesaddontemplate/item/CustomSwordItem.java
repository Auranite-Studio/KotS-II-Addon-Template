
package com.esmods.keepersofthestonesaddontemplate.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import com.esmods.keepersofthestonesaddontemplate.procedures.CustomSwordRemoveProcedure;
import com.esmods.keepersofthestonesaddontemplate.init.PowerTemplateModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CustomSwordItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 0, 4f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("power_template:custom_sword_repair_items")));

	public CustomSwordItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 8f, -2.4f, properties);
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(PowerTemplateModItems.CUSTOM_SWORD.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CustomSwordRemoveProcedure.execute(entity);
	}
}
