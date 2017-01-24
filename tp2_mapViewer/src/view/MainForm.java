package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import controller.Coordinates;
import controller.MapController;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainForm {
	private JFrame frame;
	private JMapViewer mapViewer;
	private MapController mapController;
	List<Coordinates> listCoords;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainForm() {
		initialize();
	}

	private void initialize() {
		// Proxy.autenticar();
		
		frame = new JFrame();
		frame.setBounds(400, 200, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		mapViewer = new JMapViewer();
		mapViewer.setZoomContolsVisible(false);
		mapViewer.setDisplayPositionByLatLon(-34.521, -58.7008, 11);

		frame.setContentPane(mapViewer);

		JButton btnCargarInstancias = new JButton("Cargar Instancias");
		btnCargarInstancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarInstancias();
			}
		});

		btnCargarInstancias.setBounds(790, 11, 190, 23);
		mapViewer.add(btnCargarInstancias);

		JButton btnBorrarInstancias = new JButton("Borrar Instancias");
		btnBorrarInstancias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarInstancias();
			}
		});

		btnBorrarInstancias.setBounds(790, 45, 190, 23);
		mapViewer.add(btnBorrarInstancias);

		JButton btnAllClusters = new JButton("Generar todos los Clusters");
		btnAllClusters.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				mapController.generarAllClusters();
			}
		});

		btnAllClusters.setBounds(790, 79, 190, 23);
		mapViewer.add(btnAllClusters);
		
		mapController = new MapController(mapViewer);
	}
	
	private void cargarInstancias() 
	{
		mapController.cargarInstancias();
	}
	
	private void borrarInstancias() 
	{
		mapController.borrarInstancias();
	}
	
}
