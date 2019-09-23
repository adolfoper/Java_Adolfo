package Ejercicios_T2;

import java.util.Scanner;

import Ejercicios_T2.Error_Valida;

public class E02_06_Clientes implements E02_06_A_Saludar{

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
	
		
	private String email;
		// Getter
		public String getEmail() {
		  return email;
		}

		// Setter
		public void setEmail(String nuevoValor) throws Error_Valida {
		   if (nuevoValor.equals(""))
			   throw new Error_Valida("Email incorrecto");
		   this.email = nuevoValor;
		}
	  
	private String tipo;
	  // Getter
	  public String getTipo() {
	    return tipo;
	  }

	  // Setter
	  public void setTipo(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Tipo incorrecto");
	    this.tipo = nuevoValor;
	  }
	
	
	//
	//	Constructor con todos los parametros
	//
	public E02_06_Clientes(String nombre, String email, String tipo) throws Error_Valida {
		
		if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		if (email.equals(""))
			   throw new Error_Valida("Email incorrecto");
		if (tipo.equals(""))
			   throw new Error_Valida("Tipo incorrecto");
		this.nombre = nombre;
		this.email = email;
		this.tipo = tipo;
	}

	
	public void saludo() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Hola, soy la clase Clientes");
		sc.close();
	}

}