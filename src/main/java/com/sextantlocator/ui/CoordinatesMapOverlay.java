package com.sextantlocator.ui;

import com.sextantlocator.SextantLocatorConfig;
import com.sextantlocator.SextantPoint;
import java.awt.*;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.worldmap.WorldMapOverlay;

public class CoordinatesMapOverlay extends Overlay
{
	private final int TEXT_MARGIN = 5;

	private final Client client;
	private final WorldMapOverlay worldMapOverlay;
	private final SextantLocatorConfig sextantLocatorConfig;

	@Inject
	public CoordinatesMapOverlay(Client client, WorldMapOverlay worldMapOverlay, SextantLocatorConfig sextantLocatorConfig)
	{
		this.client = client;
		this.worldMapOverlay = worldMapOverlay;
		this.sextantLocatorConfig = sextantLocatorConfig;

		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
		setLayer(OverlayLayer.MANUAL);
		drawAfterInterface(WidgetID.WORLD_MAP_GROUP_ID);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!sextantLocatorConfig.displayMapCoordinatesOverlay())
		{
			return null;
		}

		RenderOverview renderOverview = client.getRenderOverview();
		Widget worldMapWidget = client.getWidget(WidgetInfo.WORLD_MAP_VIEW);

		if (renderOverview == null || worldMapWidget == null)
		{
			return null;
		}

		WorldPoint mapCenterPoint = new WorldPoint(renderOverview.getWorldMapPosition().getX(), renderOverview.getWorldMapPosition().getY(), 0);
		Rectangle worldMapBounds = worldMapWidget.getBounds();

		renderCrosshair(graphics, mapCenterPoint, worldMapBounds);

		SextantPoint mapCenterSextantPoint = new SextantPoint(mapCenterPoint.getX(), mapCenterPoint.getY());

		renderCoordinates(graphics, mapCenterSextantPoint, worldMapBounds);

		return null;
	}

	private void renderCrosshair(Graphics graphics, WorldPoint mapCenterPoint, Rectangle worldMapBounds)
	{
		Point middle = worldMapOverlay.mapWorldPointToGraphicsPoint(mapCenterPoint);

		if (middle == null)
		{
			return;
		}

		graphics.setClip(worldMapBounds);
		graphics.setColor(sextantLocatorConfig.coordinateMapOverlayCrosshairColor());
		graphics.drawLine(middle.getX(), worldMapBounds.y, middle.getX(), worldMapBounds.y + worldMapBounds.height);
		graphics.drawLine(worldMapBounds.x, middle.getY(), worldMapBounds.x + worldMapBounds.width, middle.getY());
	}

	private void renderCoordinates(Graphics graphics, SextantPoint mapCenterSextantPoint, Rectangle worldMapBounds)
	{
		String output = mapCenterSextantPoint.toString();
		FontMetrics fontMetrics = graphics.getFontMetrics();
		int textHeight = fontMetrics.getHeight();
		int textWidth = fontMetrics.stringWidth(output);
		int textX = (int) worldMapBounds.getX() + TEXT_MARGIN;
		int textY = (int) worldMapBounds.getY() + TEXT_MARGIN + textHeight;

		int rectangleX = (int) worldMapBounds.getX();
		int rectangleY = (int) worldMapBounds.getY();
		int rectangleWidth = textWidth + TEXT_MARGIN * 2;
		int rectangleHeight = textHeight + TEXT_MARGIN * 2;

		graphics.setColor(sextantLocatorConfig.coordinateMapOverlayBackgroundColor());
		graphics.fillRect(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

		graphics.setColor(sextantLocatorConfig.coordinateMapOverlayTextColor());
		graphics.drawString(output, textX, textY);
	}
}
