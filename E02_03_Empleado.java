package Ejercicios_T2;

import Ejercicios_T2.Error_Valida;

public class E02_03_Empleado {

	//creamos los atributos publicos
	public String nombre;
	public String dni;
	public int sueldo;
	
	//
	//	Constructor con todos los parametros
	//
	E02_03_Empleado(String nombre, String dni, int sueldo) throws Error_Valida {
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = sueldo;
	}

//
//	Constructor solo con nombre y Dni
//
	E02_03_Empleado(String nombre, String dni) throws Error_Valida {
	   if (nombre.equals(""))
	       throw new Error_Valida("Nombre incorrecto");
	   if (dni.equals(""))
	       throw new Error_Valida("Dni incorrecto");
	
	   this.nombre = nombre;
	   this.dni = dni;
	   this.sueldo = 0;
	}
	
	// Clase privada que retorna el reductor de sueldo neto
	private double getIRPF () {
	
		if (this.sueldo < 3000)
			return (0.85);
		else
			return (0.75);
	}

	//
	//  Class Sueldo neto
	//	Retorna sueldo * reductor de sueldo neto
	//
	public int sueldo_Neto() {
		double reductor =  getIRPF ();
		return ((int) Math.round(this.sueldo*reductor));
	}

}