package controller;

import static org.junit.Assert.*;

import org.junit.Test;
import domain.Coordinate;

public class CoordinatesTest {
	
	private Coordinates instancia()
	{
		Coordinates c= new Coordinates();
		c.add(new Coordinate(20.5, 20));
		c.add(new Coordinate(40,40));
		c.add(new Coordinate(60,60));
		c.add(new Coordinate(-34.58, -58.34));
		
		return c;
	}
	
	@Test
	public void addCoordinateTest()
	{
		Coordinates c= instancia();

		assertTrue( c.contains( new Coordinate(20.5, 20) ));
		assertTrue( c.contains( new Coordinate(60,60) ));
		assertTrue( c.contains( new Coordinate(-34.58, -58.34) ));
		
		assertFalse( c.contains( new Coordinate(20,60) ));
		assertFalse( c.contains( new Coordinate(-34.59, -58.35) ));
		
		c.add(new Coordinate(20,60) );
		assertTrue( c.contains( new Coordinate(20,60) ));
	}

	@Test
	public void removeCoordinateTest()
	{
		Coordinates c= instancia();
		
		assertTrue( c.contains( new Coordinate(20.5, 20)) );
		c.remove( new Coordinate(20.5, 20) );
		assertFalse( c.contains( new Coordinate(20.5, 20)) );
	}
	
	@Test
	public void getTest()
	{
		Coordinates c= instancia();
		assertEquals(new Coordinate(-34.58, -58.34),c.get(3));
		assertNotEquals(new Coordinate(60,60),c.get(1));
	}
	
	@Test
	public void getPesoTest()
	{
		assertEquals( 4146.364904306314, Coordinates.getPeso(new Coordinate(-34.52, -58.70), new Coordinate(-70.52, -40.70)), 1e-4 );
	}
	
}
