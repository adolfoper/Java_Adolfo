package Ejercicios_T2A3;

import java.util.ArrayList;

import Ejercicios_T2A3.Error_Valida;
import Ejercicios_T2A3.Espanyola;
import Ejercicios_T2A3.Jugador;

public class Mus {
	
	Espanyola baraja = null;
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	//
	//	Constructor 
	//
	public Mus() {
		baraja = new Espanyola();	
	}

	//
	// añade un jugador
	//
	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);	
	}
	
}
