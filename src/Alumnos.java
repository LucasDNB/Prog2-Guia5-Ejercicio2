
public class Alumnos extends Personas{
	
	private double cuota;
	
	public void setCuota(double c) {
		cuota = c;
	}
	
	public double getCuota () {
		return cuota;
	}
	
	public Alumnos (String n, String a, long d, double c) {
		super(n, a, d);
		cuota = c;
	}
	
	public Alumnos () {
		
	}

}
