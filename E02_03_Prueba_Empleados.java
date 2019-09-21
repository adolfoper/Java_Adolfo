package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.Error_Valida;
import Ejercicios_T2.E02_03_Empleado;

public class E02_03_Prueba_Empleados {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		E02_03_Empleado javier = null;
		boolean error = false;
		
		try
		{
			javier = new E02_03_Empleado("Javier", "51224221K", 1000);
// 			javier = new E02_03_Empleado("Javier", "51224221K");
		}
		catch (Error_Valida err)
		{	
			System.out.println(err.getMessage());
			error = true;
		}
		finally
		{
			if (!error) { 
				System.out.println("Sueldo neto:"+ javier.sueldo_Neto());
				try {
				   javier.setNombre("Jose Javier");
				}
				catch (Error_Valida err) {
					System.out.println("Asignacion fallida");
				}
				
				try {
					javier.setDni("33333333J");
				}
				catch (Error_Valida err) {
					System.out.println("Asignacion fallida");
				}
				
				javier.setSueldo(10000); 
				System.out.println("Nombre:"+ javier.getNombre());
				System.out.println("Dni:"+ javier.getDni());
				System.out.println("Sueldo:"+ javier.getSueldo());
				System.out.println("Sueldo neto:"+ javier.sueldo_Neto());
			}
		}
		
		sc.close();
	}

}


