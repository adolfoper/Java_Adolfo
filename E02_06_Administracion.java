package Ejercicios_T2;

import Ejercicios_T2.Error_Valida;

import java.util.Scanner;

import Ejercicios_T2.E02_06_Empleado;


public class E02_06_Administracion extends E02_06_Empleado implements E02_06_A_Saludar{
	
	private String seccion;
	  // Getter
	  public String getSeccion() {
	    return seccion;
	  }

	  // Setter
	  public void setSeccion(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Seccion incorrecta");
	    this.seccion = nuevoValor;
	  }
	
	//
	//	Constructor con todos los parametros
	//
	E02_06_Administracion(String nombre, String dni, int sueldo, String seccion) throws Error_Valida {
		
		   super (nombre,dni,sueldo);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		   if (seccion.equals(""))
			   throw new Error_Valida("Seccion incorrecta");
			
		   this.seccion = seccion;

	}

	//
	//	Constructor sin sueldo
	//
	E02_06_Administracion(String nombre, String dni, String seccion) throws Error_Valida {
		
		   super (nombre,dni);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		   if (seccion.equals(""))
			   throw new Error_Valida("Seccion incorrecta");
		   
		   this.seccion = seccion;
	}
	
	public void saludo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Hola, soy la clase Administracion");
		sc.close();
	}

}