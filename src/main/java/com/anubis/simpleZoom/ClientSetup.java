package com.anubis.simpleZoom;

import java.awt.event.KeyEvent;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SimpleZoom.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

	public static KeyMapping toggleAutoclick;

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		// declare an array of key bindings

		// instantiate the key bindings
		String catagoryString = "key." + SimpleZoom.MODID + ".category";
		String nameString = "key." + SimpleZoom.MODID + ".";

		/* Alte Version
		toggleAutoclick = new KeyBinding(KeyEvent.VK_M, nameString + "toggleautoclick");
		saveTool = new KeyBinding(nameString + "savetool", KeyEvent.VK_P, catagoryString);
		keepHunger = new KeyBinding(nameString + "keephunger", KeyEvent.VK_H, catagoryString);
		range = new KeyBinding(nameString + "miningrange", KeyEvent.VK_PLUS, catagoryString);
		*/

		toggleAutoclick = new KeyMapping(nameString + "zoom", KeyEvent.VK_C, catagoryString);

		// register all the key bindings
		event.register(toggleAutoclick);
		// ClientRegistry.registerKeyBinding(mousePress);

	}

	@SubscribeEvent
	public static void submitZoomHandler(FMLClientSetupEvent event) {

		MinecraftForge.EVENT_BUS.register(new ZoomHandler());
	}

}
