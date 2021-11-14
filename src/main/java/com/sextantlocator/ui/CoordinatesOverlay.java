package com.sextantlocator.ui;

import com.sextantlocator.SextantLocatorConfig;
import com.sextantlocator.SextantPoint;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;

public class CoordinatesOverlay extends OverlayPanel
{
	private final Client client;
	private final SextantLocatorConfig sextantLocatorConfig;

	@Inject
	public CoordinatesOverlay(Client client, SextantLocatorConfig sextantLocatorConfig)
	{
		this.client = client;
		this.sextantLocatorConfig = sextantLocatorConfig;

		setPosition(OverlayPosition.TOP_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!sextantLocatorConfig.displayCoordinatesOverlay())
		{
			return null;
		}

		addOverlayComponents();

		return super.render(graphics);
	}

	private void addOverlayComponents()
	{
		if (client.getLocalPlayer() == null)
		{
			return;
		}

		int playerX = client.getLocalPlayer().getWorldLocation().getX();
		int playerY = client.getLocalPlayer().getWorldLocation().getY();
		SextantPoint playerSextantPoint = new SextantPoint(playerX, playerY);

		LineComponent titleLine = LineComponent.builder().left("Sextant coordinates:").build();
		LineComponent xCoordinateLine = LineComponent.builder().right(playerSextantPoint.getXCoordinate().toString()).build();
		LineComponent yCoordinateLine = LineComponent.builder().right(playerSextantPoint.getYCoordinate().toString()).build();

		panelComponent.getChildren().add(titleLine);
		panelComponent.getChildren().add(yCoordinateLine);
		panelComponent.getChildren().add(xCoordinateLine);
	}
}
