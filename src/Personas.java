
public class Personas {
	
	protected String nombre;
	protected String apellido;
	protected long dni;
	
	public void setNombre (String n) {nombre = n;}
	public void setApellido (String a) {apellido = a;}
	public void setDni (long d) { dni = d;}
	
	public String getNombre () {return nombre;}
	public String getApellido () {return apellido;}
	public long getDni () {return dni;}
	
	public Personas (String n, String a, long d) {
		nombre = n;
		apellido = a;
		dni = d;
	}
	
	public Personas () {
		
	}

}
