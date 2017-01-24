package controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import domain.Coordinate;
import view.OpenFilesForm;

public class MapController 
{
	private JMapViewer mapViewer;
	private ArrayList<FicheroCoordenadas> ficherosCoords;
	private ArrayList<GrafoCoordinates> grafos;
	public MapController(JMapViewer mapViewer)
	{
		this.mapViewer = mapViewer;
		ficherosCoords = new ArrayList<FicheroCoordenadas>();
		grafos = new ArrayList<GrafoCoordinates>();
	}
	
	public void cargarInstancias() 
	{
		ArrayList<FicheroCoordenadas> ficheros = OpenFilesForm.getListCoordinates(mapViewer);
		for (FicheroCoordenadas fichero : ficheros) {
			if (!ficherosCoords.contains(fichero)) {
				ficherosCoords.add(fichero);
				marcarCoordenadas(fichero);
				calcularAGM(fichero);
			}
		}
	}
	
	private void marcarCoordenadas(FicheroCoordenadas fichero)
	{
		for (Coordinate c : fichero.getCoordinates())
			mapViewer.addMapMarker(new MapMarkerDot(c.getLat(), c.getLon()));
	}
	
	private void calcularAGM(FicheroCoordenadas fichero) 
	{
		GrafoCoordinates grafo = new GrafoCoordinates(fichero.getCoordinates());
		grafo.agregarTodasAristas();
		GrafoCoordinates agm = Algoritmos.AGM(grafo);
		grafos.add(agm);
		dibujarLineas(agm);
	}
	
	public void borrarInstancias()
	{
		mapViewer.removeAllMapMarkers();
		borrarLineas();
		ficherosCoords = new ArrayList<FicheroCoordenadas>();
		grafos = new ArrayList<GrafoCoordinates>();
	}
	
	private void borrarLineas()
	{
		mapViewer.removeAllMapPolygons();
	}
	
	public void generarAllClusters()
	{
		borrarLineas();
		ArrayList<GrafoCoordinates> agmsCluster = new ArrayList<GrafoCoordinates>();
		for (GrafoCoordinates grafo : grafos) {
			agmsCluster.add(grafo.clone());
		}
		dibujarPoligonos(agmsCluster);
	}
	
	private void dibujarPoligonos(ArrayList<GrafoCoordinates> agmsCluster) 
	{
		for (int i = 0; i < ficherosCoords.size(); i++) {
			GrafoCoordinates grafo = agmsCluster.get(i);
			FicheroCoordenadas fichero = ficherosCoords.get(i);
			Integer cantClusters = escribirCantidadClusters(fichero.getNombreArchivo(), grafo.aristas());
			Cluster.generar(grafo, cantClusters);
			dibujarLineas(grafo);
		}
	}
	
	private void dibujarLineas(GrafoCoordinates grafo)
	{
		for (Coordinate c1 : grafo.vertices()) {
			for (Coordinate c2 : grafo.vecinos(c1)) {
				ArrayList<Coordinate> aristaMapa = new ArrayList<Coordinate>();
				aristaMapa.add(c1);
				aristaMapa.add(c2);
				aristaMapa.add(c2);
				mapViewer.addMapPolygon(new MapPolygonImpl(aristaMapa));
			}
		}
	}
	
	private Integer escribirCantidadClusters(String instancia, int aristas)
	{
		String cantidad = JOptionPane.showInputDialog("Cuantos Clusters quiere generar? (1 a " + (aristas+1) + ") para " + instancia);
		Integer clusters = 0;

		if (!Pattern.matches("[1-9]\\d*", cantidad))
			escribirCantidadClusters(instancia, aristas);

		clusters = Integer.parseInt(cantidad);
		if (clusters > aristas+1)
			clusters = escribirCantidadClusters(instancia, aristas);

		return clusters;
	}
}
