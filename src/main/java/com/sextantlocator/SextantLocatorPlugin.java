package com.sextantlocator;

import com.google.inject.Provides;
import com.sextantlocator.ui.CoordinatesMapOverlay;
import com.sextantlocator.ui.CoordinatesOverlay;
import com.sextantlocator.ui.CoordinatesTooltipOverlay;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Sextant Locator",
	description = "Sextant's coordinates helper.",
	tags = {
		"sextant",
		"coordinates",
		"world",
		"location",
		"locator",
		"clues"
	}
)
public class SextantLocatorPlugin extends Plugin
{
	@Inject
	private SextantLocatorConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	CoordinatesOverlay coordinatesOverlay;

	@Inject
	CoordinatesTooltipOverlay coordinatesTooltipOverlay;

	@Inject
	CoordinatesMapOverlay coordinatesMapOverlay;

	@Provides
	SextantLocatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SextantLocatorConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addOverlays();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeOverlays();
	}

	private void addOverlays()
	{
		overlayManager.add(coordinatesOverlay);
		overlayManager.add(coordinatesTooltipOverlay);
		overlayManager.add(coordinatesMapOverlay);
	}

	private void removeOverlays()
	{
		overlayManager.remove(coordinatesOverlay);
		overlayManager.remove(coordinatesTooltipOverlay);
		overlayManager.remove(coordinatesMapOverlay);
	}
}