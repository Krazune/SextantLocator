/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2021, Miguel Sousa
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.sextantlocator;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup("sextantlocator")
public interface SextantLocatorConfig extends Config
{
	@ConfigSection(
		position = 0,
		name = "Coordinates Overlay",
		description = "Settings for the coordinates overlay."
	)
	String coordinatesOverlaySection = "coordinatesOverlaySection";

	@ConfigItem(
		position = 1,
		keyName = "displayCoordinatesOverlay",
		name = "Coordinates overlay",
		description = "Display the coordinates overlay.",
		section = coordinatesOverlaySection
	)
	default boolean displayCoordinatesOverlay()
	{
		return true;
	}



	@ConfigSection(
		position = 2,
		name = "Tile Tooltip",
		description = "Settings for the coordinates tile tooltip."
	)
	String tileCoordinatesOverlaySection = "tileCoordinatesOverlaySection";

	@ConfigItem(
		position = 3,
		keyName = "displayTileCoordinatesOverlay",
		name = "Tile tooltip",
		description = "Display the coordinates tooltip of the tile hovered tile.",
		section = tileCoordinatesOverlaySection
	)
	default boolean displayTileCoordinatesOverlay()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 4,
		keyName = "selectedTileFillColor",
		name = "Tile color",
		description = "Color of the tile fill.",
		section = tileCoordinatesOverlaySection
	)
	default Color selectedTileFillColor()
	{
		return new Color(0, 0, 0, 64);
	}

	@Alpha
	@ConfigItem(
		position = 5,
		keyName = "selectedTileBorderColor",
		name = "Border color",
		description = "Color of the tile border.",
		section = tileCoordinatesOverlaySection
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
		name = "Border width",
		description = "Width of the tile border.",
		section = tileCoordinatesOverlaySection
	)
	default int selectedTileBorderWidth()
	{
		return 2;
	}



	@ConfigSection(
		position = 7,
		name = "Map Overlay",
		description = "Settings for the map coordinates overlay."
	)
	String mapCoordinatesOverlaySection = "mapCoordinatesOverlaySection";

	@ConfigItem(
		position = 8,
		keyName = "displayMapCoordinatesOverlay",
		name = "Map coordinates",
		description = "Display the sextant coordinates overlay in the map window.",
		section = mapCoordinatesOverlaySection
	)
	default boolean displayMapCoordinatesOverlay()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
		position = 9,
		keyName = "coordinateMapOverlayBackgroundColor",
		name = "Background color",
		description = "Color of the background of the map overlay.",
		section = mapCoordinatesOverlaySection
	)
	default Color coordinateMapOverlayBackgroundColor()
	{
		return Color.BLACK;
	}

	@Alpha
	@ConfigItem(
		position = 10,
		keyName = "coordinateMapOverlayTextColor",
		name = "Text color",
		description = "Color of the text of the map overlay.",
		section = mapCoordinatesOverlaySection
	)
	default Color coordinateMapOverlayTextColor()
	{
		return Color.WHITE;
	}

	@Alpha
	@ConfigItem(
		position = 11,
		keyName = "coordinateMapOverlayCrosshairColor",
		name = "Crosshair color",
		description = "Color of the crosshair of the map overlay.",
		section = mapCoordinatesOverlaySection
	)
	default Color coordinateMapOverlayCrosshairColor()
	{
		return Color.WHITE;
	}
}
