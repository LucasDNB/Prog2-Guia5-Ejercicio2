import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		EmpleadosAdm [] empleadosAct = new EmpleadosAdm [39];
		cargaEmpleados(empleadosAct);
	    Docentes [] docentesAct = new Docentes [67];
	    cargaDocentes(docentesAct);
	    Alumnos [] alumnosAct = new Alumnos [100];
	    cargaAlumnos(alumnosAct);
	    
	    menu (empleadosAct, docentesAct, alumnosAct);

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

public static void menu (EmpleadosAdm emp[], Docentes doc[], Alumnos al[]) {
	boolean seguir;
	int menu;
	do {
		menu = enteroValido("INGRESE LA OPCION DESEADA\n1 - Ingreso o consulta de informacion\n2 - Consultar cuota de Alumno por nombre\n3 - Ingresos monetarios y porcentajes de sueldos\n4 - Salir", 1, 4);
		switch (menu) {
		case (1) : break;//ingresoOConsulta(EmpleadosAdm emp, Docentes doc, Alumnos al); break;
		case (2) : consultaCuotaAlumno (al); break;
		case (3) : break;//ingresosYporcentajes (Empleados emp, Docentes doc, Alumnos al); break;
		case (4) : seguir = false; break;
		}
	    if (menu != 1 && menu != 2 && menu != 3 && menu != 4) System.out.println("Error, reingrese una opcion valida:");
		
		seguir = ingresarBooleano("Ingrese SI para volver al menu\nIngrese NO para finalizar");
		
	} while (seguir);
}

public static boolean ingresarBooleano (String m) {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner (System.in);
	
	String c =  new String();
	System.out.println(m);
	boolean seguir = true;;
	
	do {
		c = sc.next();
		c = c.toLowerCase();
		if ((c.equals("si")) || (c.equals("no"))) { seguir = false;} 
		else System.out.println("ERROR, opcion invalida. Reintente: ");
	} while (seguir);
	
	if (c.equals("si")) return true;
	else return false;
}


public static int enteroValido (String mensaje, int minimo, int maximo) {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    int numero;
    while (true) {
        System.out.println(mensaje);
        if (sc.hasNextInt()) {
            numero = sc.nextInt();
            if (numero >= minimo && numero <= maximo) {
                return numero;
            } else {
                System.out.println("ERROR: opcion invalida");
            }
        } else {
            sc.next();
        }
    }
  }

public static void consultaCuotaAlumno (Alumnos al[]) {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner (System.in);
	String aux;
	boolean seguir = true;
	
	do {
	System.out.println("Ingrese el nombre del alumno: ");
	aux = sc.next();
	
	for (int i=0; i<al.length; i++) {
	    if (al[i].getNombre().equals(aux)) { 
	    	System.out.println("El Alumno "+aux+" abona una cuota de: $"+al[i].getCuota());
	    	seguir = false;
	    }
	}
	if (seguir == true) System.out.println("ERROR, nombre no encontrado\nREINTENTE:");
	} while (seguir);
}
}