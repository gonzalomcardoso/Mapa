package controller;

import domain.Coordinate;

public class Arista 
{
	public Coordinate amarillo;
	public Coordinate negro;
	public double peso;
	public Arista(Coordinate verticeAmarillo, Coordinate verticeNegro, double pesoArista)
	{
		amarillo = verticeAmarillo;
		negro = verticeNegro;
		peso = pesoArista;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;
		
		Arista otra = (Arista) obj;
		return amarillo == otra.amarillo && negro == otra.negro;
	}
	
	@Override
	public String toString()
	{
		return amarillo + " " + negro + " " + peso;
	}
	// Retorna la arista de menor peso entre un vertice amarillo y uno no amarillo
	
}
