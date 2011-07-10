package com.mmounirou.gameoflife;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest
{

	@Test
	public void testGetUnexistantCell()
	{
		Board bord = new Board();
		Cell cell = bord.getCell(new Point());

		Assert.assertNotNull(cell);
		Assert.assertEquals(new Point(0, 0), cell.getPosition());
	}

	@Test
	public void testGetExistantCell()
	{
		Board board = new Board();
		Cell expectedCell = board.getCell(new Point());

		Cell cell = board.getCell(new Point());
		Assert.assertEquals(expectedCell, cell);
	}

	@Test
	public void testGetNeighbors()
	{
		Cell cell = new Cell(new Point());

		Board board = new Board();
		Set<Cell> neighbors = board.getNeighbors(cell);
		Assert.assertEquals(neighbors.size(), 8);
		// @formatter:off
		List<Cell> expectedNeighbors = Arrays.asList(new Cell(new Point(0, 1)),
													 new Cell(new Point(1, 0)), 
													 new Cell(new Point(1, 1)), 
													 new Cell(new Point(0, -1)),
													 new Cell(new Point(-1, 0)),
													 new Cell(new Point(-1, -1)),
													 new Cell(new Point(1, -1)),
													 new Cell(new Point(-1, 1)));
		// @formatter:on
		Assert.assertTrue(CollectionUtils.isEqualCollection(neighbors, expectedNeighbors));
	}
}
