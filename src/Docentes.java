
public class Docentes extends Personas{
	
	private int horas;
	private double valorHora;
	private double salario;
	
	public void setHoras (int h) {

		horas = h;
	}
	public void setValorH (double v) {
		valorHora = v;
	}
	public void setSalario () {
		salario=horas*valorHora;
	}
	
    public int getHoras () {
		return horas;
	}	
    public double getValorHora() {
    	return valorHora;
    }
    public double getSalario() {
    	return salario;
    }
    
    public Docentes (String n, String a, long d, int h) {
		super (n, a, d);
		horas = h;
	}
	
	public Docentes () {
		
	}
	

}
