package Ejercicios_T2;

import java.util.Scanner;
import Ejercicios_T2.E02_A1_Jugador;
import Ejercicios_T2.E02_A1_Carta;

public class E02_A1_Prueba_Cartas {
	
	public static void main (String args[]){

		Scanner sc = new Scanner(System.in);		
	
		// Prueba clase Carta
		E02_A1_Carta carta1 = new E02_A1_Carta("Bastos", "7", 7);
		E02_A1_Carta carta2 = new E02_A1_Carta("Oros", "Rey", 12);
		
		carta1.setPalo("Espadas");
		carta1.setNombre("8");
		carta1.setValor(8);
		
		System.out.println("Palo carta 1: "+ carta1.getPalo());
		System.out.println("Nombre carta 1: "+ carta1.getNombre());
		System.out.println("Valor carta 1: "+ carta1.getValor());
		System.out.println("Carta 1: "+ carta1.toString());	
		System.out.println("Carta 2: "+ carta2.toString());	
		
		// Prueba clase Jugador
		boolean error = false;
		
		// Alta
		E02_A1_Jugador jugador1 = null;
		try {
			jugador1 = new E02_A1_Jugador("Manolo");
		}
		catch (Error_Valida err){
			System.out.println(err.getMessage());
			error = true;
		}
		
		// Set
		if (!error) {
			try {
				jugador1.setNombre("Manolon");
			}
			catch (Error_Valida err){
				System.out.println(err.getMessage());
				error = true;
			}
		}

		// Juego
		if (!error) {
			System.out.println("Get nombre 1: "+ jugador1.getNombre());
			
			System.out.println("  *** Da cartas ***");
			
			jugador1.darCarta (carta1);
			System.out.println("Juego: "+ jugador1.juego());
			
			jugador1.darCarta (carta2);
			System.out.println("Juego: "+ jugador1.juego());

			String carta_str = null;
			
			System.out.println("  *** Retira cartas ***");
			
			carta_str = jugador1.retirarCarta(1);
			System.out.println("Carta retirada: "+ carta_str);
			System.out.println("Juego: "+ jugador1.juego());
		}
		
		sc.close();
	}

}
