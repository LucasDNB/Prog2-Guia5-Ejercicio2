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
		case (1) : ingOConsulAlumnos(al); break;
		case (2) : ingOConsulDocentes(doc);break;
		case (3) : ingOConsulEmpleados (emp); break;
		case (4) : break;
		}
	    if (menu < 1 && menu > 4) System.out.println("Error, reingrese una opcion valida:");
		
		seguir = ingresarBooleano("Ingrese SI para seguir en el menu actual\nIngrese NO para volver al principal");
		
	} while (seguir);
	
	
} //Completar

public static void ingOConsulAlumnos (Alumnos al[]) {
	Scanner sc = new Scanner(System.in);
	boolean seguir = true;
	int pos = -1;
	
	do {	   
	  int opcion = enteroValido("ALUMNOS\nINGRESE LA OPCION DESEADA\n1 - Ver informacion de alumno\n2 - Modificar informacion de alumno", 1, 2);

	  long dniAux = (long)enteroValido("Ingrese el DNI del alumno a modificar", 10000000, 99999999);
      for (int i=0; i<al.length; i++) {
    	  if (dniAux == al[i].getDni())
    		  pos = i;
      }
	  
	   if (opcion == 1 && pos != -1) {//Solo muestra los datos solicitados
			seguir = false;			
			System.out.println("Nombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nCuota abonada: $"+al[pos].getCuota());
			break;
		  }
	
	   else if (opcion == 2 && pos != -1) {//Muestra los datos solicitados, los cambia y los vuelve a mostrar modificados
		   String nombre, apellido;
		   long dni;
		   double cuota;
		   System.out.println("DATOS A MODIFICAR:\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nCuota abonada: $"+al[pos].getCuota());

		    System.out.println("Ingrese el nuevo nombre del alumno: ");
		    nombre = sc.nextLine();
		    al[pos].setNombre(nombre);
		    System.out.println("Ingrese el nuevo apellido del alumno: ");
		    apellido = sc.nextLine();
		    al[pos].setApellido(apellido);
		    dni = (long)enteroValido("Ingrese el nuevo DNI del alumno: ", 10000000, 99999999);
		    al[pos].setDni(dni);
		    cuota = doubleValido("Ingrese el valor de la cuota a abonar: ", 0);	    		   		   
		    al[pos].setCuota(cuota);
		    System.out.println("DATOS ACTUALIZADOS:\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nCuota abonada: $"+al[pos].getCuota());
            seguir = false;
	   }		  
		  
	} while (seguir);	 
		
		}
		
public static void ingOConsulEmpleados (EmpleadosAdm al[]) {
	Scanner sc = new Scanner(System.in);
	boolean seguir = true;
	int pos = -1;
	
	do {	   
	  int opcion = enteroValido("EMPLEADOS\nINGRESE LA OPCION DESEADA\n1 - Ver informacion de empleado\n2 - Modificar informacion de empleado", 1, 2);

	  long dniAux = (long)enteroValido("Ingrese el DNI del empleado a modificar", 10000000, 99999999);
      for (int i=0; i<al.length; i++) {
    	  if (dniAux == al[i].getDni())
    		  pos = i;
      }
	  
	   if (opcion == 1 && pos != -1) {//Solo muestra los datos solicitados
			seguir = false;			
			System.out.println("Nombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nSalario: $"+al[pos].getSalario());
			break;
		  }
	
	   else if (opcion == 2 && pos != -1) {//Muestra los datos solicitados, los cambia y los vuelve a mostrar modificados
		   String nombre, apellido;
		   long dni;
		   double salario;
		   System.out.println("DATOS A MODIFICAR:\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nSalario: $"+al[pos].getSalario());

		    System.out.println("Ingrese el nuevo nombre del empleado: ");
		    nombre = sc.nextLine();
		    al[pos].setNombre(nombre);
		    System.out.println("Ingrese el nuevo apellido del empleado: ");
		    apellido = sc.nextLine();
		    al[pos].setApellido(apellido);
		    dni = (long)enteroValido("Ingrese el nuevo DNI del empleado: ", 10000000, 99999999);
		    al[pos].setDni(dni);
		    salario = doubleValido("Ingrese el valor de salario a cobrar: ", 0);	    		   		   
		    al[pos].setSalario(salario);
		    System.out.println("DATOS ACTUALIZADOS:\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nSalario: $"+al[pos].getSalario());
            seguir = false;
	     }	
       
       } while(seguir);

}

public static void ingOConsulDocentes (Docentes al[]) {
	Scanner sc = new Scanner(System.in);
	boolean seguir = true;
	int pos = -1;
	
	do {	   
	  int opcion = enteroValido("DOCENTES\nINGRESE LA OPCION DESEADA\n1 - Ver informacion de docente\n2 - Modificar informacion de docente", 1, 2);

	  long dniAux = (long)enteroValido("Ingrese el DNI del docente a modificar", 10000000, 99999999);
      for (int i=0; i<al.length; i++) {
    	  if (dniAux == al[i].getDni())
    		  pos = i;
      }
	  
	   if (opcion == 1 && pos != -1) {//Solo muestra los datos solicitados
			seguir = false;			
			System.out.println("Nombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nRemuneracion por hora: $"+al[pos].getValorHora()+"\nTotal de horas de catedra: "+al[pos].getHoras()+"\nSalario: "+al[pos].getSalario());
			break;
		  }
	
	   else if (opcion == 2 && pos != -1) {//Muestra los datos solicitados, los cambia y los vuelve a mostrar modificados
		   String nombre, apellido;
		   long dni;
		   double vHora;
		   int horas;
			System.out.println("DATOS A MODIFICAR\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nRemuneracion por hora: $"+al[pos].getValorHora()+"\nTotal de horas de catedra: "+al[pos].getHoras()+"\nSalario: "+al[pos].getSalario());

		    System.out.println("Ingrese el nuevo nombre del docente: ");
		    nombre = sc.nextLine();
		    al[pos].setNombre(nombre);
		    System.out.println("Ingrese el nuevo apellido del docente: ");
		    apellido = sc.nextLine();
		    al[pos].setApellido(apellido);
		    dni = (long)enteroValido("Ingrese el nuevo DNI del docente: ", 10000000, 99999999);
		    al[pos].setDni(dni);
		    vHora = doubleValido("Ingrese por hora a cobrar: ", 0);
		    al[pos].setValorH(vHora);
		    horas = enteroValido("Ingrese la cantidad de horas trabajadas por mes", 0, 100);
		    al[pos].setHoras(horas);
		    al[pos].setSalario();
			System.out.println("DATOS ACTUALIZADOS\nNombre completo: "+al[pos].getNombre()+" "+al[pos].getApellido()+"\nDNI: "+al[pos].getDni()+"\nRemuneracion por hora: $"+al[pos].getValorHora()+"\nTotal de horas de catedra: "+al[pos].getHoras()+"\nSalario: "+al[pos].getSalario());
            seguir = false;
	     }	
       
       } while(seguir);

}
}

