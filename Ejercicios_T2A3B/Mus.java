package Ejercicios_T2A3B;

import java.util.ArrayList;
import Ejercicios_T2A3B.Espanyola;
import Ejercicios_T2A3B.Jugador;

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
