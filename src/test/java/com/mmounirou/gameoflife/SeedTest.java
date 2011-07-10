package com.mmounirou.gameoflife;

import org.junit.Test;

public class SeedTest
{

	@Test
	public void testIterate()
	{
		Board board = Board.INSTANCE;

		Cell cell1 = board.getCell(new Point());
		Cell cell2 = board.getCell(new Point(1, 1));
		Cell cell3 = board.getCell(new Point(1, 0));

		Seed seed = new Seed(cell1, cell2, cell3);
		seed.iterate();
	}
}
