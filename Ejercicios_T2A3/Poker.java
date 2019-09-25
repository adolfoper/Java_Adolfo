package Ejercicios_T2A3;

import java.util.ArrayList;

import Ejercicios_T2A3.Error_Valida;
import Ejercicios_T2A3.Francesa;
import Ejercicios_T2A3.Jugador;

public class Poker {
	
	Francesa baraja = null;
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	
	//
	//	Constructor 
	//
	public Poker(ArrayList<Jugador> new_Jugadores) throws Error_Valida {
		
		if (new_Jugadores.size()<3)
			throw new Error_Valida("Minimo 3 jugadores");
		
		jugadores.addAll(new_Jugadores);
		
		baraja = new Francesa();	
	}

	//
	// añade un jugador
	//
	public void addJugador(Jugador jugador) {
		jugadores.add(jugador);	
	}
	
}
