package com.mmounirou.gameoflife;

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Seed
{
	Board board = Board.INSTANCE;
	private Set<Cell> cells;

	public Seed(Cell... cells)
	{
		this.cells = new HashSet<Cell>(Arrays.asList(cells));
	}

	public Seed iterate()
	{
		Set<Cell> nextCells = new HashSet<Cell>();

		for (Iterator<Cell> cellIterator = cells.iterator(); cellIterator.hasNext();)
		{
			Cell cell = cellIterator.next();
			Set<Cell> neighbors = board.getNeighbors(cell);
			List<Cell> deadNeighbors = filter(having(!on(Cell.class).isAlive()), neighbors);

			for (Cell deadNeighbor : deadNeighbors)
			{
				Set<Cell> deadNeighborNeighbors = board.getNeighbors(cell);
				List<Cell> deadNeighborAliveNeighbors = filter(having(on(Cell.class).isAlive()), deadNeighborNeighbors);

				deadNeighbor.evolve(deadNeighborAliveNeighbors.size());
				if (deadNeighbor.isAlive())
					nextCells.add(deadNeighbor);
			}
			cell.evolve(neighbors.size() - deadNeighbors.size());
			if (cell.isAlive())
				nextCells.add(cell);
		}

		return new Seed(nextCells.toArray(new Cell[nextCells.size()]));

	}
}
