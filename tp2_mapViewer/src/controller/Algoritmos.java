
package controller;

import java.util.ArrayList;

import domain.Coordinate;

public class Algoritmos 
{
	static ArrayList<GrafoCoordinates> listaAGM = new ArrayList<GrafoCoordinates>();
	
	public static GrafoCoordinates AGM(GrafoCoordinates grafo)
	{
		GrafoCoordinates resultado = new GrafoCoordinates(grafo.vertices());
		NeighborsCoordinate amarillos = new NeighborsCoordinate();
		amarillos.add(grafo.vertices().get(0));	// ATENCION!
		
		for(int i = 0; i < grafo.vertices().size()-1; i++) {
			Arista a = menorArista(grafo, amarillos); // De un amarillo a un negro
			resultado.agregarArista(a.amarillo, a.negro);
			amarillos.add(a.negro);
		}
		
		listaAGM.add(resultado);
		
		return resultado;
	}
	
	public static Arista menorArista(GrafoCoordinates grafo, NeighborsCoordinate amarillos)
	{
		Arista ret = new Arista(null, null, Double.MAX_VALUE);
	
		for (Coordinate i : amarillos)
			for (Coordinate j : grafo.vecinos(i))
				if ( !amarillos.contains(j))
					if(grafo.getPeso(i, j)<ret.peso )
						ret = new Arista(i, j, grafo.getPeso(i, j));
		
		return ret;
	}
	
}
