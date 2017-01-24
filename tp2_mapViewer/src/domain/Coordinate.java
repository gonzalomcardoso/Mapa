package domain;

import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class Coordinate implements ICoordinate
{
	private double latitud;
	private double longitud;
	
	public Coordinate (double latitude, double longitude)
	{
		latitud = latitude;
		longitud = longitude;
	}
	
	@Override
	public double getLat()
	{
		return latitud;
	}
	
	@Override
	public double getLon()
	{
		return longitud;
	}
	
	@Override
	public void setLat(double latitude) {
		latitud = latitude;
	}

	@Override
	public void setLon(double longitude) {
		longitud = longitude;
	}
	
	@Override
	public String toString()
	{
		return "Latitud: " + latitud + ", Longitud: " + longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (Double.doubleToLongBits(this.getLat()) != Double.doubleToLongBits(other.getLat()))
			return false;
		if (Double.doubleToLongBits(this.getLon()) != Double.doubleToLongBits(other.getLon()))
			return false;
		
		return true;
	}

}
