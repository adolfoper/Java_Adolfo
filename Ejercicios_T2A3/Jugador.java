package Ejercicios_T2A3;

import java.util.ArrayList;
import Ejercicios_T2A3.Carta;
import Ejercicios_T2A3.Error_Valida;

public class Jugador {
	
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
	private ArrayList<Carta> cartas = null;
	
	//
	//	Constructor
	//
	Jugador(String nombre) throws Error_Valida {   
		
		 if (nombre.equals(""))
		   throw new Error_Valida("Nombre obligatorio");
		
		this.nombre = nombre;
		cartas = new  ArrayList<Carta>();
		
	}

	//
	// Da una carta al jugador
	//
	public void darCarta (Carta carta) {
		cartas.add(carta);
	}
	
	//
	// Retira una carta del jugador
	//
	public String retirarCarta (int indice){
		
		Carta carta = null;
		
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
		
		Carta carta = null;
		
		String mano = "[";
		
		for (int i=0;i<cartas.size();i++) {
			
			carta = cartas.get(i);

			if (i < cartas.size()-1)
				mano = mano + carta.toString() + ", ";
			else
				mano = mano + carta.toString() + "]";
		}
		return mano;
	}

}