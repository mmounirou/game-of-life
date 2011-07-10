package com.mmounirou.gameoflife;

public class Cell
{

	private boolean isAlive;
	private final Point position;

	public Cell(Point point)
	{
		this.position = point;
		isAlive = false;
	}

	public void evolve(int i)
	{
		if (isAlive())
		{
			if (i < 2)
				kill();
			if (i > 3)
				kill();

		} else
		{
			revive();
		}
	}

	public Cell(Point point, boolean isAlive)
	{
		this(point);
		this.isAlive = isAlive;
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public void kill()
	{
		isAlive = false;
	}

	public void revive()
	{
		isAlive = true;
	}

	public Point getPosition()
	{
		return position;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Cell))
		{
			return false;
		}
		Cell other = (Cell) obj;

		if (position == null)
		{
			if (other.position != null)
			{
				return false;
			}
		} else if (!position.equals(other.position))
		{
			return false;
		}
		return true;
	}

}
