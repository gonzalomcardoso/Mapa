package controller;

import domain.Coordinate;

public class Cluster 
{
	public static void generar(GrafoCoordinates agm, Integer cantidadClusters)
	{
		for(int i = 1; i < cantidadClusters; i++)
		{
			Arista a = mayorArista(agm);
			agm.removerArista(a.amarillo, a.negro);
		}
	}
	
	private static Arista mayorArista(GrafoCoordinates grafo)
	{
		Arista ret = new Arista(null,null,Double.MIN_VALUE);
		
		for(Coordinate i : grafo.vertices())
		{
			for (Coordinate j: grafo.vecinos(i))
			{
				if(grafo.getPeso(i, j) > ret.peso)
					ret = new Arista(i,j, grafo.getPeso(i, j));
			}
		}
		
		return ret;
	}
}
