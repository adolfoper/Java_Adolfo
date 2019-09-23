package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.Error_Valida;
import Ejercicios_T2.E02_05_Administracion;
import Ejercicios_T2.E02_05_Gerente;
import Ejercicios_T2.E02_05_Direccion;

public class E02_05_Prueba_Empleados {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		E02_05_Administracion javier = null;
		E02_05_Gerente manuel = null;
		E02_05_Direccion antonio = null;

		boolean error = false;
		
		try
		{
			javier = new E02_05_Administracion("Javier", "51224221K", 1000, "Contabilidad");
			manuel = new E02_05_Gerente("Manuel", "111111111K", 2000, "Progress derivation enhancement",4000);
			antonio = new E02_05_Direccion("Antonio", "222222222K", 6000, 900000);

		}
		catch (Error_Valida err)
		{	
			System.out.println(err.getMessage());
			error = true;
		}
		finally
		{		
				System.out.println("--  Administracion --");
				System.out.println("Nombre:"+ javier.getNombre());
				System.out.println("Dni:"+ javier.getDni());
				System.out.println("Sueldo:"+ javier.getSueldo());
				System.out.println("Seccion:"+ javier.getSeccion());
				
				System.out.println("--  Gerente --");
				System.out.println("Nombre:"+ manuel.getNombre());
				System.out.println("Dni:"+ manuel.getDni());
				System.out.println("Sueldo:"+ manuel.getSueldo());
				System.out.println("Departamento:"+ manuel.getDepartamento());
				System.out.println("Departamento:"+ manuel.getDietas());
				
				System.out.println("--  Direccion --");
				System.out.println("Nombre:"+ antonio.getNombre());
				System.out.println("Dni:"+ antonio.getDni());
				System.out.println("Sueldo:"+ antonio.getSueldo());
				System.out.println("Seccion:"+ antonio.getStock_Opt());
		}
		
		sc.close();
	}

}


