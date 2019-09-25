package Ejercicios_T2A3;

import Ejercicios_T2A3.Mus;
import Ejercicios_T2A3.Jugador;
import java.util.ArrayList;

public class Prueba_Cartas {
	
	public static void main (String args[]){
		
		// Crea los jugadores
		Jugador jugador1 = null;
		Jugador jugador2 = null;
		Jugador jugador3 = null;
		Jugador jugador4 = null;
		
		try {
			jugador1 = new Jugador("Manolo");
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
		}
			
		try {
			jugador2 = new Jugador("Antonio");
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
		}
		
		try {
			jugador3 = new Jugador("Jose");
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
		}
		
		try {
			jugador4 = new Jugador("Benito");
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
		}

		//
		// Prueba clase Mus
		//
		Mus partidaMus = new Mus();
		partidaMus.addJugador(jugador1);
		System.out.println("----- MUS -----");	
		System.out.println(partidaMus.baraja.cartas);		
		System.out.println(partidaMus.jugadores.get(0).getNombre());
		
		//
		// Prueba clase Poker
		//
		ArrayList<Jugador> lista_Jugadores = new ArrayList<Jugador>();
		lista_Jugadores.add(jugador1);
		lista_Jugadores.add(jugador2);
		lista_Jugadores.add(jugador3);
		
		Poker partidaPoker = null;
		
		try {
			partidaPoker = new Poker(lista_Jugadores);
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
		}
		
		partidaPoker.addJugador(jugador4);
		
		System.out.println("---- POKER ----");	
		System.out.println(partidaPoker.baraja.cartas);		
		System.out.println(partidaPoker.jugadores.get(0).getNombre());
		System.out.println(partidaPoker.jugadores.get(1).getNombre());
		System.out.println(partidaPoker.jugadores.get(2).getNombre());
		System.out.println(partidaPoker.jugadores.get(3).getNombre());
	}

}


