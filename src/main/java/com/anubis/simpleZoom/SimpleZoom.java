package com.anubis.simpleZoom;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimpleZoom.MODID)
public class SimpleZoom {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "simple_zoom";
	// Directly reference a slf4j logger
	public static final Logger LOGGER = LogUtils.getLogger();

	public static SimpleZoom instance;

	public SimpleZoom() {
		MinecraftForge.EVENT_BUS.register(this);
		instance = this;
	}

}
