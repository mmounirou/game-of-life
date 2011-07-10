package com.mmounirou.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class CellTest
{

	@Test
	public void testCell()
	{
		Cell cell = new Cell(new Point());
		Assert.assertFalse(cell.isAlive());
		Assert.assertEquals(cell.getPosition(), new Point());
	}

	@Test
	public void testAliveCell()
	{
		Cell cell = new Cell(new Point(), true);
		Assert.assertTrue(cell.isAlive());
	}

	@Test
	public void testDeadCell()
	{
		Cell cell = new Cell(new Point(), false);
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void testKillCell()
	{
		Cell cell = new Cell(new Point(), true);
		cell.kill();
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void testReviveCell()
	{
		Cell cell = new Cell(new Point(), false);
		cell.revive();
		Assert.assertTrue(cell.isAlive());
	}

	@Test
	public void testCellUnderPopulation()
	{
		Cell cell = new Cell(new Point(), true);
		cell.evolve(1);

		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void testCellNextGeneration()
	{
		Cell cell = new Cell(new Point(), true);

		cell.evolve(2);
		Assert.assertTrue(cell.isAlive());

		cell.evolve(3);
		Assert.assertTrue(cell.isAlive());

	}

	@Test
	public void testCellOvercrowding()
	{
		Cell cell = new Cell(new Point(), true);

		cell.evolve(4);
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void testCellReproduction()
	{
		Cell cell = new Cell(new Point());

		cell.evolve(3);
		Assert.assertTrue(cell.isAlive());
	}
}
