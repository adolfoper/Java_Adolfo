package Ejercicios_T2;

import Ejercicios_T2.Error_Valida;

public class E02_02_Empleado {

	//creamos los atributos publicos
	public String nombre;
	public String dni;
	public int sueldo;
	
	//
	//	Constructor con todos los parametros
	//
	E02_02_Empleado(String nombre, String dni, int sueldo) throws Error_Valida {
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
	E02_02_Empleado(String nombre, String dni) throws Error_Valida {
	   if (nombre.equals(""))
	       throw new Error_Valida("Nombre incorrecto");
	   if (dni.equals(""))
	       throw new Error_Valida("Dni incorrecto");
	
	   this.nombre = nombre;
	   this.dni = dni;
	   this.sueldo = 0;
	}

	//
	//  Class Sueldo neto
	//	Retorna sueldo * 0.85
	//
	public int sueldo_Neto() {
		return ((int) Math.round(this.sueldo*0.85));
	}

}