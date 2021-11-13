package com.sextantlocator;

import net.runelite.api.coords.Direction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SextantCoordinateTest
{
	private final float observatoryX = 2440.5f;
	private final float observatoryY = 3161.5f;
	private final float minutePerTile = 15f / 8f;

	@Test
	public void observatoryXTest()
	{
		SextantCoordinate x = new SextantCoordinate(observatoryX, SextantAxis.HORIZONTAL);

		assertTrue(x.getDegrees() == 0);
		assertTrue(x.getMinutes() == 0);
		assertTrue(x.getDirection() == Direction.EAST);
	}

	@Test
	public void observatoryYTest()
	{
		SextantCoordinate y = new SextantCoordinate(observatoryY, SextantAxis.VERTICAL);

		assertTrue(y.getDegrees() == 0);
		assertTrue(y.getMinutes() == 0);
		assertTrue(y.getDirection() == Direction.NORTH);
	}

	@Test
	public void singleStepTest()
	{
		SextantCoordinate coordinate = new SextantCoordinate(observatoryX + 1f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 0);
		assertTrue(coordinate.getMinutes() == 1.875f);
		assertTrue(coordinate.getDirection() == Direction.EAST);
	}

	@Test
	public void sixtyMinutesTest()
	{
		SextantCoordinate coordinate = new SextantCoordinate(observatoryX + 60 / minutePerTile, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 1f);
		assertTrue(coordinate.getMinutes() == 0f);
		assertTrue(coordinate.getDirection() == Direction.EAST);
	}

	@Test
	public void ninetyMinutesTest()
	{
		SextantCoordinate coordinate = new SextantCoordinate(observatoryX + 90 / minutePerTile, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 1f);
		assertTrue(coordinate.getMinutes() == 30f);
		assertTrue(coordinate.getDirection() == Direction.EAST);
	}
}
