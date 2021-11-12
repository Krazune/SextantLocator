package com.sextantlocator;

public class SextantPoint
{
	private SextantCoordinate x;
	private SextantCoordinate y;

	public SextantPoint(SextantCoordinate x, SextantCoordinate y)
	{
		if (x == null)
		{
			this.x = new SextantCoordinate(0, SextantAxis.HORIZONTAL);
		}
		else
		{
			this.x = x;
		}

		if (y == null)
		{
			this.y = new SextantCoordinate(0, SextantAxis.VERTICAL);
		}
		else
		{
			this.y = y;
		}
	}

	public SextantPoint(float worldX, float worldY)
	{
		x = new SextantCoordinate(worldX, SextantAxis.HORIZONTAL);
		y = new SextantCoordinate(worldY, SextantAxis.VERTICAL);
	}

	public void setXCoordinate(SextantCoordinate newX)
	{
		if (newX == null)
		{
			this.x = new SextantCoordinate(0, SextantAxis.HORIZONTAL);
		}
		else
		{
			this.x = newX;
		}
	}

	public void setYCoordinate(SextantCoordinate newY)
	{
		if (newY == null)
		{
			this.y = new SextantCoordinate(0, SextantAxis.VERTICAL);
		}
		else
		{
			this.y = newY;
		}
	}

	public SextantCoordinate getXCoordinate()
	{
		return x;
	}

	public SextantCoordinate getYCoordinate()
	{
		return y;
	}

	@Override
	public String toString()
	{
		if (x == null || y == null)
		{
			return "";
		}

		return y.toString() + " | " + x.toString();
	}
}
