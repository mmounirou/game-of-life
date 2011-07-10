package com.mmounirou.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class PointTest
{

	@Test
	public void testPoint()
	{
		Point point = new Point(0, 0);
		Assert.assertEquals(0, point.getX());
		Assert.assertEquals(0, point.getY());
	}

	@Test
	public void testEqualsPoint()
	{
		Point point1 = new Point(0, 0);
		Point point2 = new Point(0, 0);
		Assert.assertEquals(point1, point2);
	}

	@Test
	public void testTranslatePoint()
	{
		Point point1 = new Point(0, 0);
		Point point2 = point1.translate(1, 1);

		Assert.assertEquals(new Point(1, 1), point2);
	}

	@Test
	public void testNotEqualsPoint()
	{
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 0);
		Assert.assertNotSame(point1, point2);

		point1 = new Point(0, 0);
		point2 = new Point(0, 1);
		Assert.assertNotSame(point1, point2);
	}

}
