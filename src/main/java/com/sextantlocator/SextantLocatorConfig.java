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

	@ConfigItem(
		position = 2,
		keyName = "displayMapCoordinatesOverlay",
		name = "Display map coordinates",
		description = "Display the sextant coordinates in the map window."
	)
	default boolean displayMapCoordinatesOverlay()
	{
		return true;
	}

	@ConfigSection(
		position = 3,
		name = "Settings",
		description = "Extra settings.",
		closedByDefault = true
	)
	String settingsSection = "settingsSection";

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "selectedTileFillColor",
		name = "Selected tile color",
		description = "Selected tile fill color.",
		section = settingsSection
	)
	default Color selectedTileFillColor()
	{
		return new Color(0, 0, 0, 64);
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "selectedTileBorderColor",
		name = "Selected tile border color",
		description = "Selected tile border color.",
		section = settingsSection
	)
	default Color selectedTileBorderColor()
	{
		return Color.YELLOW;
	}

	@Range(
		min = 1
	)
	@ConfigItem(
		position = 6,
		keyName = "selectedTileBorderWidth",
		name = "Selected tile border width",
		description = "Selected tile border width.",
		section = settingsSection
	)
	default int selectedTileBorderWidth()
	{
		return 2;
	}

	@Alpha
	@ConfigItem(
		position = 7,
		keyName = "coordinateMapOverlayBackgroundColor",
		name = "Map overlay background color",
		description = "Color of the map overlay background.",
		section = settingsSection
	)
	default Color coordinateMapOverlayBackgroundColor()
	{
		return Color.BLACK;
	}

	@Alpha
	@ConfigItem(
		position = 8,
		keyName = "coordinateMapOverlayTextColor",
		name = "Map overlay text color",
		description = "Color of the map overlay text.",
		section = settingsSection
	)
	default Color coordinateMapOverlayTextColor()
	{
		return Color.WHITE;
	}

	@Alpha
	@ConfigItem(
		position = 9,
		keyName = "coordinateMapOverlayCrosshairColor",
		name = "Map overlay crosshair color",
		description = "Color of the map overlay crosshair.",
		section = settingsSection
	)
	default Color coordinateMapOverlayCrosshairColor()
	{
		return Color.WHITE;
	}
}
