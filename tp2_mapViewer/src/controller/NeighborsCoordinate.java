package controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import domain.Coordinate;

public class NeighborsCoordinate implements Iterable<Coordinate> {
	private Coordinate coord;
	private Set<Coordinate> neighborsCoordinate;
	
	public NeighborsCoordinate(Coordinate coord)
	{
		this.coord = coord;
		neighborsCoordinate = new HashSet<Coordinate>();
	}
	
	public NeighborsCoordinate()
	{
		neighborsCoordinate = new HashSet<Coordinate>();
	}
	
	public void add(Coordinate otherCoord)
	{
		neighborsCoordinate.add(otherCoord);
	}
	
	public void remove(Coordinate otherCoord)
	{
		neighborsCoordinate.remove(otherCoord);
	}
	
	public int size()
	{
		return neighborsCoordinate.size();
	}
	
	public boolean contains(Coordinate coord)
	{
		return neighborsCoordinate.contains(coord);
	}

	public double getPeso(Coordinate coord)
	{
		return Coordinates.getPeso(this.coord, coord);
	}
	
	public Coordinate getCoordinate()
	{
		return coord;
	}
	
	@Override
	public Iterator<Coordinate> iterator()
	{
		return neighborsCoordinate.iterator();
	}
	
	public boolean equals(Coordinate coord)
	{
		return this.coord.equals(coord);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NeighborsCoordinate other = (NeighborsCoordinate) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		String s = "Coordenada: " + coord + "\n";
		for(Coordinate coord : neighborsCoordinate)
		{
			s+= "Vecino: " + coord + " Distancia: " + Coordinates.getPeso(this.coord, coord) + "\n";
		}
		return s;
		
	}
	
	
}
