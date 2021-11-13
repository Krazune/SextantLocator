package com.sextantlocator;

import net.runelite.api.coords.Direction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SextantCoordinateTest
{
	private final float observatoryX = 2440f;
	private final float observatoryY = 3161f;
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

	@Test
	public void positiveCoordinatesRoundingTest()
	{
		SextantCoordinate coordinate;

		// Good...
		coordinate = new SextantCoordinate(3069f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 19f);
		assertTrue(coordinate.getMinutesInteger() == 39f);
		assertTrue(coordinate.getDirection() == Direction.EAST);

		coordinate = new SextantCoordinate(3225f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 24f);
		assertTrue(coordinate.getMinutesInteger() == 31f);
		assertTrue(coordinate.getDirection() == Direction.EAST);

		coordinate = new SextantCoordinate(3178f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 23f);
		assertTrue(coordinate.getMinutesInteger() == 3f);
		assertTrue(coordinate.getDirection() == Direction.EAST);

		// ... luck
		coordinate = new SextantCoordinate(3517f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 11f);
		assertTrue(coordinate.getMinutesInteger() == 7f);
		assertTrue(coordinate.getDirection() == Direction.NORTH);

		coordinate = new SextantCoordinate(3219f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 1f);
		assertTrue(coordinate.getMinutesInteger() == 48f);
		assertTrue(coordinate.getDirection() == Direction.NORTH);

		coordinate = new SextantCoordinate(3475f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 9f);
		assertTrue(coordinate.getMinutesInteger() == 48f);
		assertTrue(coordinate.getDirection() == Direction.NORTH);
	}

	@Test
	public void negativeCoordinatesRoundingTest()
	{
		SextantCoordinate coordinate;

		coordinate = new SextantCoordinate(2210f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 7f);
		assertTrue(coordinate.getMinutesInteger() == 11f);
		assertTrue(coordinate.getDirection() == Direction.WEST);

		coordinate = new SextantCoordinate(2152f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 9f);
		assertTrue(coordinate.getMinutesInteger() == 0f);
		assertTrue(coordinate.getDirection() == Direction.WEST);

		coordinate = new SextantCoordinate(2377f, SextantAxis.HORIZONTAL);

		assertTrue(coordinate.getDegrees() == 1f);
		assertTrue(coordinate.getMinutesInteger() == 58f);
		assertTrue(coordinate.getDirection() == Direction.WEST);

		coordinate = new SextantCoordinate(2855f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 9f);
		assertTrue(coordinate.getMinutesInteger() == 33f);
		assertTrue(coordinate.getDirection() == Direction.SOUTH);

		coordinate = new SextantCoordinate(3072f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 2f);
		assertTrue(coordinate.getMinutesInteger() == 46f);
		assertTrue(coordinate.getDirection() == Direction.SOUTH);

		coordinate = new SextantCoordinate(3036f, SextantAxis.VERTICAL);

		assertTrue(coordinate.getDegrees() == 3f);
		assertTrue(coordinate.getMinutesInteger() == 54f);
		assertTrue(coordinate.getDirection() == Direction.SOUTH);
	}
}
