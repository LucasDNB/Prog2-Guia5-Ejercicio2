import java.text.DecimalFormat;
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
		p[i].setSalario();
	}
	
  }
public static void cargaAlumnos(Alumnos [] p) {
	
	for (int i=0; i<p.length; i++) {
		p[i] = new Alumnos();
		p[i].setNombre("Alumno"+i); 
		p[i].setApellido("ApellidoAlu"+i);
		p[i].setDni(10000000+i);
		p[i].setCuota(500*i);
	}
	
  }

public static void menu (EmpleadosAdm emp[], Docentes doc[], Alumnos al[]) {
	boolean seguir;
	int menu;
	do {
		menu = enteroValido("INGRESE LA OPCION DESEADA\n1 - Ingreso o consulta de informacion\n2 - Consultar cuota de Alumno por nombre\n3 - Ingresos monetarios y porcentajes de sueldos\n4 - Ver docentes segun salario\n5 - Salir", 1, 5);
		switch (menu) {
		case (1) : ingresoOConsulta(emp, doc, al); break;
		case (2) : consultaCuotaAlumno (al); break;
		case (3) : ingresosYporcentajes (emp, doc, al); break;
		case (4) : consultaDocentes(doc);
		case (5) : seguir = false; break;
		}
	    if (menu < 0 && menu > 6) System.out.println("Error, reingrese una opcion valida:");
		
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

public static double doubleValido (String mensaje, double minimo) {
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    double numero;
    while (true) {
        System.out.println(mensaje);
        if (sc.hasNextDouble()) {
            numero = sc.nextDouble();
            if (numero >= minimo ) {
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


public static void ingresosYporcentajes (EmpleadosAdm emp[], Docentes doc[], Alumnos al[]) {
	double totalCuotas = 0;
	double totalSalarios = 0;
	double porcentaje;
	DecimalFormat df = new DecimalFormat("#.00");
	
	for (Alumnos a: al) {
		totalCuotas = totalCuotas + a.getCuota();
	}
	
	for (EmpleadosAdm e: emp) {
		totalSalarios = totalSalarios + e.getSalario();	
	}
	
	for (Docentes d:doc) {
		totalSalarios = totalSalarios + d.getSalario();
	}
	porcentaje = (totalSalarios*100)/totalCuotas;
	System.out.println("Total cuotas: "+totalCuotas+"\nTotal salarios: "+totalSalarios);
	System.out.println("Porcentaje cuotas/salarios: %"+df.format(porcentaje));
}

public static void consultaDocentes(Docentes doc[]) {
	@SuppressWarnings({ "unused", "resource" })
	Scanner sc = new Scanner (System.in);
	double aux;
	int pos = -1;
	boolean seguir = true;
	
	do {
		aux = doubleValido("Ingrese el valor de salarios a indexar: ", 0);
	for (Docentes d: doc) {
		if (d.getSalario()>=aux) {
			System.out.println("Nombre: "+d.getNombre()+"\nApellido: "+d.getApellido()+"\nValor horario: "+d.getValorHora()+"\nCantidad de horas: "+d.getHoras()+"\nSalario: "+d.getSalario()+"\n\n");
			seguir = false;
			pos = 0;
		}
	}
	if (pos == -1) System.out.println("Numero fuera de rango, reintente operacion");
	} while (seguir);
	

}

public static void ingresoOConsulta(EmpleadosAdm emp[], Docentes doc[], Alumnos al[]) {
	System.out.println("INGRESO Y CONSULTA DE INFORMACION");
	boolean seguir;
	int menu;
	do {
		menu = enteroValido("INGRESE LA OPCION DESEADA\n1 - Alumnos\n2 - Docentes\n3 - Empleados Admnistrativos\n4 - Salir", 1, 4);
		switch (menu) {
		case (1) : ingresoOConsulta(emp, doc, al); break;
		case (2) : consultaCuotaAlumno (al); break;
		case (3) : ingresosYporcentajes (emp, doc, al); break;
		case (4) : consultaDocentes(doc);
		case (5) : seguir = false; break;
		}
	    if (menu < 0 && menu > 6) System.out.println("Error, reingrese una opcion valida:");
		
		seguir = ingresarBooleano("Ingrese SI para volver al menu\nIngrese NO para finalizar");
		
	} while (seguir);
	
	
} //Completar

public static void verOModificar ()
} //Completa