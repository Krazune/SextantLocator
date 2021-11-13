package com.sextantlocator;

import net.runelite.api.coords.Direction;

import static java.lang.Math.abs;

public class SextantCoordinate
{
	private final float minutes;
	private final SextantAxis axis;

	private final float observatoryX = 2440f;
	private final float observatoryY = 3161f;
	private final float minutePerTile = 15f / 8f;

	public SextantCoordinate(float degrees, float minutes, Direction direction)
	{
		if (direction == Direction.NORTH || direction == Direction.SOUTH)
		{
			axis = SextantAxis.VERTICAL;
		}
		else
		{
			axis = SextantAxis.HORIZONTAL;
		}

		this.minutes = degrees * 60 + minutes;
	}

	public SextantCoordinate(float worldCoordinate, SextantAxis axis)
	{
		this.axis = axis;
		this.minutes = worldCoordinateToMinutes(worldCoordinate, axis);
	}

	public int getDegrees()
	{
		return (int) abs(minutes / 60);
	}

	public float getMinutes()
	{
		return abs(minutes % 60);
	}

	public int getMinutesInteger()
	{
		return (int) abs(minutes % 60);
	}

	public Direction getDirection()
	{
		if (minutes >= 0)
		{
			if (axis == SextantAxis.HORIZONTAL)
			{
				return Direction.EAST;
			}

			return Direction.NORTH;
		}

		if (axis == SextantAxis.HORIZONTAL)
		{
			return Direction.WEST;
		}

		return Direction.SOUTH;
	}

	private float worldCoordinateToMinutes(float worldCoordinate, SextantAxis axis)
	{
		if (axis == SextantAxis.HORIZONTAL)
		{
			worldCoordinate -= observatoryX;
		}
		else
		{
			worldCoordinate -= observatoryY;
		}

		return worldCoordinate * minutePerTile;
	}

	@Override
	public String toString()
	{
		return getDegrees() + " deg. " + getMinutesInteger() + " min. " + getDirection().toString().charAt(0);
	}
}
