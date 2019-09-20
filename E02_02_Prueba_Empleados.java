package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.Error_Valida;
import Ejercicios_T2.E02_02_Empleado;

public class E02_02_Prueba_Empleados {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		E02_02_Empleado javier = null;
		boolean error = false;
		
		try
		{
//			javier = new E02_02_Empleado("Javier", "51224221K", 24000);
 			javier = new E02_02_Empleado("Javier", "51224221K");
		}
		catch (Error_Valida err)
		{	
			System.out.println(err.getMessage());
			error = true;
		}
		finally
		{
			if (!error) 
				System.out.println("Sueldo neto:"+ javier.sueldo_Neto());
		}
		
		sc.close();
	}

}


