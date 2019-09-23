package Ejercicios_T2;

import Ejercicios_T2.Error_Valida;

import java.util.Scanner;

import Ejercicios_T2.E02_06_Empleado;


public class E02_06_Direccion extends E02_06_Empleado implements E02_06_A_Saludar{
	  
	private int stock_opt;
		// Getter
		public int getStock_Opt() {
		    return stock_opt;
		}

		// Setter
	    public void setStock_Opt(int nuevoValor) throws Error_Valida {
		    this.stock_opt = nuevoValor;
		}	  
	
	//
	//	Constructor con todos los parametros
	//
	E02_06_Direccion(String nombre, String dni, int sueldo, int stock_opt) throws Error_Valida {
		
		   super (nombre,dni,sueldo);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");

		   this.stock_opt = stock_opt;
	}
	
	//
	//	Constructor sin sueldo ni stock options
	//
	E02_06_Direccion(String nombre, String dni) throws Error_Valida {
		
		   super (nombre,dni);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		   this.stock_opt = 0;
	}
	
	//
	//  Class Sueldo neto
	//	Retorna sueldo * reductor de sueldo neto + stock optios * 0.1
	//
	public int sueldo_Neto() {
		int sueldo_sin_opciones =  super.sueldo_Neto();
		return ((int) Math.round(sueldo_sin_opciones+this.stock_opt*0.1));
	}

	public void saludo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Hola, soy la clase Direccion");
		sc.close();
	}
}