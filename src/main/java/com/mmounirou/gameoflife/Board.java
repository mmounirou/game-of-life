package com.mmounirou.gameoflife;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum Board
{

	INSTANCE;

	private Map<Point, Cell> allCells = new HashMap<Point, Cell>();

	public Cell getCell(Point point)
	{
		Cell cell = allCells.get(point);
		if (cell == null)
		{
			cell = new Cell(point);
			allCells.put(point, cell);
		}
		return cell;
	}

	public Set<Cell> getNeighbors(Cell cell)
	{
		Point position = cell.getPosition();

		Set<Cell> neighbors = new HashSet<Cell>();
		neighbors.add(getCell(position.translate(0, 1)));
		neighbors.add(getCell(position.translate(1, 0)));
		neighbors.add(getCell(position.translate(1, 1)));
		neighbors.add(getCell(position.translate(0, -1)));
		neighbors.add(getCell(position.translate(-1, 0)));
		neighbors.add(getCell(position.translate(-1, -1)));
		neighbors.add(getCell(position.translate(1, -1)));
		neighbors.add(getCell(position.translate(1, -1)));
		neighbors.add(getCell(position.translate(-1, 1)));

		return neighbors;
	}
}
