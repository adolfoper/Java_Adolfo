package Ejercicios_T2A3B;

import Ejercicios_T2A3B.Poker;
import Ejercicios_T2A3B.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

public class Consola_Poker {
	
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		String nombre = null;
		boolean error = false;
		int num_jugadores = 0;
		
		Jugador jugador = null;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>(); 
		
		// Recibe el número de jugadores
		do {
			System.out.println("Introduzca número de jugadores (mínimo 3)");
			num_jugadores = sc.nextInt();
			if (num_jugadores < 3)
				System.out.println("Numero de jugadores incorrecto");
		}
		while (num_jugadores < 3);
		
		nombre = sc.nextLine();  // Hay que saltar linea
		
		// Recibe los jugadores y los añade a la lista de jugadores
		int i = 1;
		while (i<=num_jugadores) {
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
				jugadores.add(jugador);
				i++;
			}
		}
		
		// Crea la partida
		error = false;
		Poker partida = null;
		try {
			partida = new Poker(jugadores);
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
			error = true;
		}
		
		// Display de resultado	
		if (!error) {
			System.out.println("----- Partida preparada -----");	
			System.out.println("Baraja:");	
			System.out.println(partida.baraja.cartas);	
			System.out.println("Jugadores:");
			for (int j=0;j<num_jugadores;j++) {
				System.out.println(partida.jugadores.get(j).getNombre());
			}
		}
	}
}


