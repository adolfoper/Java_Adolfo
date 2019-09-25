package Ejercicios_T2A3B;

import Ejercicios_T2A3B.Mus;
import Ejercicios_T2A3B.Error_Valida;
import Ejercicios_T2A3B.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

public class Consola_Mus {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		String nombre = null;
		int i = 1;
		boolean error = false;
		
		Jugador jugador = null;

		// Crea la partida
		Mus partida = new Mus();
		
		// Recibe los nombres de jugadores y los añade a la partida
		while (i<5) {
			System.out.println("Introduzca jugador "+i+":");
			nombre = sc.nextLine();
			error = false;
			
			try {
				jugador = new Jugador(nombre);
			}
			catch (Error_Valida err){
				System.out.println(err.getMessage());
				error = true;
			}
			
			if (!error) {
				partida.addJugador(jugador);
				i++;
			}
		}

		// Display de resultado
		System.out.println("----- Partida preparada -----");	
		System.out.println("Baraja:");	
		System.out.println(partida.baraja.cartas);	
		System.out.println("Jugadores:");	
		System.out.println(partida.jugadores.get(0).getNombre());
		System.out.println(partida.jugadores.get(1).getNombre());
		System.out.println(partida.jugadores.get(2).getNombre());
		System.out.println(partida.jugadores.get(3).getNombre());
		sc.close();
	}
}


