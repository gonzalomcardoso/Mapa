package view;

import domain.Coordinate;

import controller.Coordinates;

public class Console 
{
	public static void main(String [] args)
	{
		Coordinates c = new Coordinates();
		c.readFile("instancias/instancia1.json");
		System.out.println(c);
		
		Coordinates c2 = new Coordinates();
		c2.add(new Coordinate(20.5, 20));
		c2.add(new Coordinate(40,40));
		c2.add(new Coordinate(60,60));
		c2.writeFile("prueba.json");
		c2.readFile("prueba.json");
		System.out.println(c2);
	}
}
