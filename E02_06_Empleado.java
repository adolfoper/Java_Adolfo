package Ejercicios_T2;

import java.util.Scanner;

import Ejercicios_T2.Error_Valida;

public class E02_06_Empleado implements E02_06_A_Saludar{

	//creamos los atributos privados
	private String nombre;
	  // Getter
	  public String getNombre() {
	    return this.nombre;
	  }

	  // Setter
	  public void setNombre(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Nombre incorrecto");
		
	    nombre = nuevoValor;
	  }
	
	private String dni;
	  // Getter
	  public String getDni() {
	    return dni;
	  }

	  // Setter
	  public void setDni(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Dni incorrecto");
	    this.dni = nuevoValor;
	  }
	
	private int sueldo;
	  // Getter
	  public int getSueldo() {	
	    return this.sueldo;
	  }

	  // Setter
	  public void setSueldo(int nuevoValor) {
	    this.sueldo = nuevoValor;
	  }
	
	//
	//	Constructor con todos los parametros
	//
	public E02_06_Empleado(String nombre, String dni, int sueldo) throws Error_Valida {
		
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
	public E02_06_Empleado(String nombre, String dni) throws Error_Valida {
	
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
	
	public void saludo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Hola, soy la clase Empleado");
		sc.close();
	}

}