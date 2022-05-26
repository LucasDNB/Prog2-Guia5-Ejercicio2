
public class EmpleadosAdm extends Personas{
	
	private double salario;
	
	public void setSalario (double s) {
		salario = s;
	}
	
	public double getSalario () {
		return salario;
	}
	
	public EmpleadosAdm (String n, String a, long d, double s) {
		super(n, a, d);
	    salario = s;
	}
	
	public EmpleadosAdm () {
		
	}
	
	

}
