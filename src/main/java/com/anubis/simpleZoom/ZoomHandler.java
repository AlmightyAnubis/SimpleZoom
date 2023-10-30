package com.anubis.simpleZoom;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent.Key;
import net.minecraftforge.client.event.InputEvent.MouseScrollingEvent;
import net.minecraftforge.client.event.ViewportEvent.ComputeFov;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(bus = Bus.FORGE, value = Dist.CLIENT)
public class ZoomHandler {

	private Minecraft mc;

	private Integer oldFOV = 90;
	private Float zoomFactor = 10f;
	private boolean isZoom = false;

	@SubscribeEvent
	public void toggleZoom(Key event) {
		mc = Minecraft.getInstance();
		if (mc.screen != null) {
			return;
		}
		if (event.getKey() != 256) {


			int keyValue = ClientSetup.toggleAutoclick.getKey().getValue();

			if (keyValue == event.getKey()) {
				if (event.getAction() == InputConstants.RELEASE) {
					isZoom = false;

				}
				if (event.getAction() == InputConstants.PRESS) {
					isZoom = true;
				}
			}
		}
	}

	@SubscribeEvent
	public void changeZoom(MouseScrollingEvent event) {
		if (ClientSetup.toggleAutoclick.isDown()) {
			zoomFactor = (float) (zoomFactor + event.getScrollDelta() * 5);

			if (oldFOV - zoomFactor < -15) {
				zoomFactor = (float) (oldFOV - (-15));
			}
			if (oldFOV - zoomFactor > 130) {
				zoomFactor = (float) (oldFOV - 130);
			}
			event.setCanceled(true);
		}
		

	}

	@SubscribeEvent
	public void FOVRenderChanger(ComputeFov event) {
		if (isZoom) {
			event.setFOV(event.getFOV() - zoomFactor);
		}

	}

}
