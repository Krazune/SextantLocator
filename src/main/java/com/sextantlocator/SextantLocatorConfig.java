package com.sextantlocator;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("sextantlocator")
public interface SextantLocatorConfig extends Config
{
	@ConfigItem(
		keyName = "displayCoordinatesOverlay",
		name = "Display coordinates overlay",
		description = "Display the coordinates overlay when on Runescape's surface."
	)
	default boolean displayCoordinatesOverlay()
	{
		return true;
	}
}
