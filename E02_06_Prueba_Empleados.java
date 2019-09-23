package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.Error_Valida;
import Ejercicios_T2.E02_06_Administracion;
import Ejercicios_T2.E02_06_Gerente;
import Ejercicios_T2.E02_06_Direccion;
import Ejercicios_T2.E02_06_Clientes;

public class E02_06_Prueba_Empleados {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		E02_06_Administracion javier = null;
		E02_06_Gerente manuel = null;
		E02_06_Direccion antonio = null;
		E02_06_Empleado becario = null;
		E02_06_Clientes alberto = null;

		boolean error = false;
		
		try{
			javier = new E02_06_Administracion("Javier", "51224221K", 1000, "Contabilidad");
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			manuel = new E02_06_Gerente("Manuel", "111111111K", 2000, "Progress derivation enhancement",4000);
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			antonio = new E02_06_Direccion("Antonio", "222222222K", 6000, 900000);
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			becario = new E02_06_Empleado("Becario", "3333333333K", 900);

		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			alberto = new E02_06_Clientes("Alberto", "alberto@hotmail.com", "normalito");
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			alberto.setNombre("Alberto 2");
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			alberto.setEmail("alberto2@gmail.com");
		}
		catch (Error_Valida err){	
			System.out.println(err.getMessage());
			error = true;
		}
		
		try{
			alberto.setTipo("Advanced");
		}
		catch (Error_Valida err)
		{	
			System.out.println(err.getMessage());
			error = true;
		}
		
		if (!error)
		{			
			System.out.println("Nombre:"+alberto.getNombre());
			System.out.println("Email:"+alberto.getEmail());
			System.out.println("Tipo:"+alberto.getTipo());
			
			javier.saludo();
			antonio.saludo();
			manuel.saludo();
			becario.saludo();
			alberto.saludo();
		}
		
		sc.close();
	}

}


