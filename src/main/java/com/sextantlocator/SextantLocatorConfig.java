package com.sextantlocator;

import java.awt.*;
import net.runelite.client.config.*;

@ConfigGroup("sextantlocator")
public interface SextantLocatorConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "displayCoordinatesOverlay",
		name = "Display coordinates overlay",
		description = "Display the coordinates overlay when on Runescape's surface."
	)
	default boolean displayCoordinatesOverlay()
	{
		return true;
	}

	@ConfigItem(
		position = 1,
		keyName = "displayTileCoordinatesOverlay",
		name = "Display tile coordinates tooltip",
		description = "Display the coordinates tooltip of the tile being hovered by the mouse."
	)
	default boolean displayTileCoordinatesOverlay()
	{
		return true;
	}

	@ConfigSection(
		position = 2,
		name = "Settings",
		description = "Extra settings.",
		closedByDefault = true
	)
	String settingsSection = "settingsSection";

	@Alpha
	@ConfigItem(
		position = 3,
		keyName = "selectedTileFillColor",
		name = "Selected tile color",
		description = "Selected tile fill color."
	)
	default Color selectedTileFillColor()
	{
		return new Color(0, 0, 0, 64);
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "selectedTileBorderColor",
		name = "Selected tile border color",
		description = "Selected tile border color."
	)
	default Color selectedTileBorderColor()
	{
		return Color.YELLOW;
	}

	@Range(
		min = 1
	)
	@ConfigItem(
		position = 5,
		keyName = "selectedTileBorderWidth",
		name = "Selected tile border width",
		description = "Selected tile border width."
	)
	default int selectedTileBorderWidth()
	{
		return 2;
	}
}
