package domain;

public class AristaPojo 
{
	private Coordinate coord1;
	private Coordinate coord2;
	
	public AristaPojo(Coordinate coord1, Coordinate coord2)
	{
		this.coord1 = coord1;
		this.coord2 = coord2;
	}

	public Coordinate getCoord1() {
		return coord1;
	}

	public void setCoord1(Coordinate coord1) {
		this.coord1 = coord1;
	}

	public Coordinate getCoord2() {
		return coord2;
	}

	public void setCoord2(Coordinate coord2) {
		this.coord2 = coord2;
	}
	
	
}
