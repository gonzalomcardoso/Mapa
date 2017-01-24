package controller;

public class FicheroCoordenadas 
{
	private String _nombreArchivo;
	private Coordinates _coords;
	
	public FicheroCoordenadas(String nombreArchivo, Coordinates coords)
	{
		_nombreArchivo = nombreArchivo;
		_coords = coords;
	}
	
	public Coordinates getCoordinates()
	{
		return _coords;
	}
	
	public String getNombreArchivo()
	{
		return _nombreArchivo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_nombreArchivo == null) ? 0 : _nombreArchivo.hashCode());
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
		FicheroCoordenadas other = (FicheroCoordenadas) obj;
		if (_nombreArchivo == null) {
			if (other._nombreArchivo != null)
				return false;
		} else if (!_nombreArchivo.equals(other._nombreArchivo))
			return false;
		return true;
	}
	
	
}
