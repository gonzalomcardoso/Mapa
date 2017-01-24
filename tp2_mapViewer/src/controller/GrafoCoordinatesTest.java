package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Coordinate;

public class GrafoCoordinatesTest {

	private Coordinates instanciaCoordenadas()
	{
		Coordinate c0= new Coordinate(-34.52, -58.70);
		Coordinate c1= new Coordinate(-70.52, -40.70);
		Coordinate c2= new Coordinate(-45.52, -15.70);
		Coordinate c3= new Coordinate(-96.52, -25.70);
		Coordinate c4= new Coordinate(-24.52, -35.70);
		
		Coordinates coordenadas = new Coordinates();
		coordenadas.add(c0);
		coordenadas.add(c1);
		coordenadas.add(c2);
		coordenadas.add(c3);
		coordenadas.add(c4);
		
		return coordenadas;
	}
	
	private GrafoCoordinates instanciaSinAristas() 
	{
		GrafoCoordinates grafo = new GrafoCoordinates(instanciaCoordenadas());
	
		return grafo;
	}
	
	private GrafoCoordinates instanciaConAristas()
	{
		
		GrafoCoordinates grafo = instanciaSinAristas();
		Coordinates coordenadas = instanciaCoordenadas();
		grafo.agregarArista(coordenadas.get(0), coordenadas.get(1));
		grafo.agregarArista(coordenadas.get(0), coordenadas.get(2));
		grafo.agregarArista(coordenadas.get(0), coordenadas.get(3));
		grafo.agregarArista(coordenadas.get(1), coordenadas.get(2));
		grafo.agregarArista(coordenadas.get(2), coordenadas.get(3));
		grafo.agregarArista(coordenadas.get(1), coordenadas.get(4));
		grafo.agregarArista(coordenadas.get(2), coordenadas.get(4));
		grafo.agregarArista(coordenadas.get(3), coordenadas.get(4));
		
		return grafo;
	}
	
	@Test
	public void contieneCoordenadaTest()
	{
		GrafoCoordinates grafo = instanciaSinAristas();
		
		assertTrue(grafo.contieneCoordenada(new Coordinate(-34.52, -58.70)));
	}
	
	@Test
	public void contieneAristaTest()
	{
		GrafoCoordinates grafo = instanciaConAristas();
		
		assertTrue( grafo.contieneArista(new Coordinate(-34.52, -58.70), new Coordinate(-70.52, -40.70)));
		assertTrue( grafo.contieneArista(new Coordinate(-70.52, -40.70), new Coordinate(-45.52, -15.70)));
		assertFalse( grafo.contieneArista(new Coordinate(-34.52, -58.70), new Coordinate(-24.52, -35.70)));
		
	}

	@Test
	public void getPesoTest()
	{
		GrafoCoordinates grafo = instanciaConAristas();
		Coordinates coordenadas = instanciaCoordenadas();
		
		assertEquals( 4146.364904306314, grafo.getPeso(new Coordinate(-34.52, -58.70), new Coordinate(-70.52, -40.70)), 1e-4 );
		assertNotEquals( 2872.12105901625, grafo.getPeso(coordenadas.get(1), coordenadas.get(2)), 1e-4 );
		assertEquals( 5660.753834519232, grafo.getPeso(coordenadas.get(2), coordenadas.get(3)), 1e-4 );
	}

}
