
public class Docentes extends Personas{
	
	private int horas;
	private double valorHora;
	
	public void setHoras (int h) {

		horas = h;
	}
	public void setValorH (double v) {
		valorHora = v;
	}
	
    public int getHoras () {
		return horas;
	}	
    public double getValorHora() {
    	return valorHora;
    }
    
	public Docentes (String n, String a, long d, int h) {
		super (n, a, d);
		horas = h;
	}
	
	public Docentes () {
		
	}
	

}
