package com.sextantlocator.ui;

import com.sextantlocator.SextantLocatorConfig;
import com.sextantlocator.SextantPoint;
import java.awt.*;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.tooltip.Tooltip;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

public class CoordinatesTooltipOverlay extends Overlay
{
	private final Client client;
	private final SextantLocatorConfig sextantLocatorConfig;
	private final TooltipManager tooltipManager;

	@Inject
	public CoordinatesTooltipOverlay(Client client, SextantLocatorConfig sextantLocatorConfig, TooltipManager tooltipManager)
	{
		this.client = client;
		this.sextantLocatorConfig = sextantLocatorConfig;
		this.tooltipManager = tooltipManager;

		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!sextantLocatorConfig.displayTileCoordinatesOverlay())
		{
			return null;
		}

		addTooltip();
		renderSelectedTile(graphics);

		return null;
	}

	private void addTooltip()
	{
		Tile selectedTile = client.getSelectedSceneTile();

		if (selectedTile == null || selectedTile.getWorldLocation() == null)
		{
			return;
		}

		int selectedTileX = selectedTile.getWorldLocation().getX();
		int selectedTileY = selectedTile.getWorldLocation().getY();
		SextantPoint selectedTileSextantCoordinates;

		selectedTileSextantCoordinates = new SextantPoint(selectedTileX, selectedTileY);

		tooltipManager.add(new Tooltip(selectedTileSextantCoordinates.toString()));
	}

	private void renderSelectedTile(Graphics2D graphics)
	{
		Tile selectedTile = client.getSelectedSceneTile();

		if (selectedTile == null || selectedTile.getLocalLocation() == null)
		{
			return;
		}

		final Polygon selectedTilePolygon = Perspective.getCanvasTilePoly(client, selectedTile.getLocalLocation());

		if (selectedTilePolygon == null)
		{
			return;
		}

		OverlayUtil.renderPolygon(graphics, selectedTilePolygon, sextantLocatorConfig.selectedTileBorderColor(), sextantLocatorConfig.selectedTileFillColor(), new BasicStroke(sextantLocatorConfig.selectedTileBorderWidth()));
	}
}
