package Ejercicios_T2A2;

import java.util.Scanner;

public class Carta {

	//creamos los atributos privados
	private String palo;					          // Palo
	  // Getter
	  public String getPalo() {
	    return this.palo;
	  }

	  // Setter
	  public void setPalo(String nuevoValor){		
	    this.palo = nuevoValor;
	  }
	  
	  private String nombre;					    // Nombre
	  // Getter
	  public String getNombre() {
	    return this.nombre;
	  }

	  // Setter
	  public void setNombre(String nuevoValor){
	    nombre = nuevoValor;
	  }
	  
	private int valor;					    		// Valor
	  // Getter
	  public int getValor() {	
	    return this.valor;
	  }

	  // Setter
	  public void setValor(int nuevoValor) {
	    this.valor = nuevoValor;
	  }
	
	//
	//	Constructor con todos los parametros
	//
	public Carta(String palo, String nombre, int valor) {	
		this.palo = palo;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	// Clase pública que retorna el nombre de la carta
	public String toString () {
		return(this.nombre+" de "+this.palo);
	}
}