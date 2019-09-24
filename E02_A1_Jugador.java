package Ejercicios_T2;

import java.util.ArrayList;
import java.util.Scanner;
import Ejercicios_T2.E02_A1_Carta;
import Ejercicios_T2.Error_Valida;

public class E02_A1_Jugador {
	
	private String nombre;					    // Nombre
	  // Getter
	  public String getNombre() {
	    return this.nombre;
	  }

	  // Setter
	  public void setNombre(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Nombre obligaorio");
		
	    nombre = nuevoValor;
	  }
	 
	// mano
	private ArrayList<E02_A1_Carta> cartas = null;
	
	//
	//	Constructor
	//
	E02_A1_Jugador(String nombre) throws Error_Valida {   
		
		 if (nombre.equals(""))
		   throw new Error_Valida("Nombre obligatorio");
		 
		cartas = new  ArrayList<E02_A1_Carta>();
		
	}

	//
	// Da una carta al jugador
	//
	public void darCarta (E02_A1_Carta carta) {
		cartas.add(carta);
	}
	
	//
	// Retira una carta del jugador
	//
	public String retirarCarta (int indice){
		
		E02_A1_Carta carta = null;
		
		if (indice >= cartas.size())
			return null;
		
		carta = cartas.get(indice);
		cartas.remove(indice);
		return (carta.toString());
	}
	
	//
	// Devuelve la mano del jugador
	//
	public String juego () {
		
		Scanner sc = new Scanner(System.in);
		E02_A1_Carta carta = null;
		
		String mano = "[";
		
		for (int i=0;i<cartas.size();i++) {
			
			carta = cartas.get(i);
			
/* ÑÑ			System.out.println("i:"+ i);
			System.out.println("size:"+ cartas.size());
			System.out.println("carta:"+ carta.toString());
			System.out.println("----------------"); */
			if (i < cartas.size()-1)
				mano = mano + carta.toString() + ", ";
			else
				mano = mano + carta.toString() + "]";
		}
		sc.close();
		return mano;
	}

}