package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.E02_01_Empleado;

public class E02_01_Prueba_Empleados {
	
	public static void main (String args[]){
		
		E02_01_Empleado javier = new E02_01_Empleado("Javier", "51224221K", 24000);
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Sueldo neto:"+ javier.sueldo_Neto());	
		sc.close();
	}

}


