package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Coordinate;

public class NeighborsCoordinateTest {

	private NeighborsCoordinate instancia()
	{
		NeighborsCoordinate n = new NeighborsCoordinate(new Coordinate(50,50));
		n.add(new Coordinate(60,60));
		n.add(new Coordinate(-70.012,-70.09283));
		return n;
	}
	
	@Test
	public void addTest() 
	{
		NeighborsCoordinate n = instancia();
		
		assertTrue(n.contains(new Coordinate(60,60)));
		assertTrue(n.contains(new Coordinate(-70.012,-70.09283)));
		
		assertFalse(n.contains(new Coordinate(20,20)));
		assertFalse(n.contains(new Coordinate(30,30)));
		
	}
	
	@Test
	public void removeTest()
	{
		NeighborsCoordinate n = instancia();
		
		n.remove(new Coordinate(60,60));
		n.remove(new Coordinate(-70.012,-70.09283));
		
		assertFalse(n.contains(new Coordinate(60,60)));
		assertFalse(n.contains(new Coordinate(-70.012,-70.09283)));
		
	}
	
	

}
