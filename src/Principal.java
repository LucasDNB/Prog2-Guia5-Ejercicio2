
public class Principal {
	public static void main(String[] args) {
		EmpleadosAdm [] empleadosAct = new EmpleadosAdm [39];
		cargaEmpleados(empleadosAct);
	    Docentes [] docentesAct = new Docentes [67];
	    cargaDocentes(docentesAct);
	    Alumnos [] alumnosAct = new Alumnos [100];
	    cargaAlumnos(alumnosAct);

	}
	

	

public static void cargaEmpleados(EmpleadosAdm [] p) {
	
	for (int i=0; i<p.length; i++) {
		p[i] = new EmpleadosAdm();
		p[i].setNombre("Empleado"+i); 
		p[i].setApellido("ApellidoEmp"+i);
		p[i].setDni(10000000+i);
		p[i].setSalario(500*i);
	}
	
  }
public static void cargaDocentes(Docentes [] p) {
	
	for (int i=0; i<p.length; i++) {
		p[i] = new Docentes ();
		p[i].setNombre("Docente"+i); 
		p[i].setApellido("ApellidoDoc"+i);
		p[i].setDni(10000000+i);
		p[i].setHoras(10+i);
		p[i].setValorH(i+1);
	}
	
  }
public static void cargaAlumnos(Alumnos [] p) {
	
	for (int i=0; i<p.length; i++) {
		p[i] = new Alumnos();
		p[i].setNombre("Alumno"+i); 
		p[i].setApellido("ApellidoAlu"+i);
		p[i].setDni(10000000+i);
		p[i].setCuota(500+i);
	}
	
  }

}