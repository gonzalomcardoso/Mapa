package controller;

import java.util.ArrayList;

import domain.Coordinate;

public class GrafoCoordinates 
{
	private Coordinates vertices;
	private ArrayList<NeighborsCoordinate> vecinos;
	private int aristas;
	
	public GrafoCoordinates(Coordinates coords)
	{
		//if(coords.size() < 2) 
			//throw new IllegalArgumentException("No se puede crear un grafo con menos de 2 elementos");
		vertices = coords;
		vecinos = new ArrayList<NeighborsCoordinate>();
		aristas = 0;
		for(Coordinate coord: coords)
			vecinos.add(new NeighborsCoordinate(coord));
	}
	
	public Coordinates vertices()
	{
		return vertices;
	}
	
	public int aristas()
	{
		return aristas;
	}
	
	public void agregarArista(Coordinate coord1, Coordinate coord2)
	{
		chequearExtremos(coord1,coord2);
		
		if(!contieneArista(coord1, coord2))
			aristas++;
		
		vecinos.get(posCoord(coord1)).add(coord2);
		vecinos.get(posCoord(coord2)).add(coord1);
		
	}
	
	public void removerArista(Coordinate coord1, Coordinate coord2)
	{
		chequearExtremos(coord1, coord2);
		
		if(contieneArista(coord1, coord2))
			aristas--;
		
		vecinos.get(posCoord(coord1)).remove(coord2);
		vecinos.get(posCoord(coord2)).remove(coord1);
		
		
	}
	
	public boolean contieneArista(Coordinate coord1, Coordinate coord2)
	{
		chequearExtremos(coord1, coord2);
		return vecinos.get(posCoord(coord1)).contains(coord2);
	}
	
	private void chequearExtremos(Coordinate coord1, Coordinate coord2)
	{
		if(!contieneCoordenada(coord1) || !contieneCoordenada(coord2))
			throw new IllegalArgumentException("Vertices inexistentes en el grafo: " + coord1 + coord2);
		if(coord1.equals(coord2))
			throw new IllegalArgumentException("No se pueden agregar loops: " + coord1);
	}
	
	public int gradoDelVertice(Coordinate coord)
	{
		int posCoord = posCoord(coord);
		if(posCoord >= 0)
			return vecinos.get(posCoord).size();
		
		return -1;
	}
	
	public double getPeso(Coordinate coord1, Coordinate coord2)
	{
		if(!contieneArista(coord1, coord2))
			throw new IllegalArgumentException("Se consulto el peso de una arista inexistente : " + coord1 + coord2);
		
		return Coordinates.getPeso(coord1, coord2);
	}
	
	public NeighborsCoordinate vecinos(Coordinate coord)
	{
		for(NeighborsCoordinate n : vecinos)
			if(n.equals(coord))
				return n;
		
		return null;
	}
	
	public boolean contieneCoordenada(Coordinate coord)
	{
		return vertices.contains(coord);	
	}
	
	private int posCoord(Coordinate coord)
	{
		return vertices.indexOf(coord);
	}
	
	public void agregarTodasAristas()
	{
		for (int i = 0; i < vertices.size() - 1; i++)
			for (int j = i + 1; j < vertices.size(); j++)
				if (i != j)
					agregarArista(vertices.get(i), vertices.get(j));
	}
	
	@Override
	public GrafoCoordinates clone()
	{
		GrafoCoordinates clon = new GrafoCoordinates(vertices);
		for(Coordinate coord : vertices)
		{
			for(Coordinate vecino : vecinos(coord))
			{
				clon.agregarArista(coord, vecino);
			}
		}
		
		return clon;
	}
	
}
