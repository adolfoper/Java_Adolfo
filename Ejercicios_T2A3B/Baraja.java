package Ejercicios_T2A3B;

import java.util.*;

import Ejercicios_T2A2.Carta;

public abstract class Baraja {
	
	protected ArrayList<Carta> cartas = new ArrayList<Carta>();
	
	// baraja la ArrayList cartas
	void barajar() {
		Collections.shuffle(cartas);
	}
	
	// saca la primera carta de la baraja (Si est� vac�a retorna nulo)
	Carta repartir() {
		Carta carta = null;
		
		if (cartas.size()>0) {
			carta = cartas.get(0);
			cartas.remove(0);
		}
		return (carta);
	}
	
	// Crea una baraja  (Puesto aqu� para reutilizar c�digo)
	void crea_Baraja(String palos[], int num_cartas, String figuras[]) {
		
		Carta carta_Baraja = null;
		
		for (String palo :palos) {
			int valor = 0;
		
			// A�ade cartas num�ricas
			for (int i=1; i < num_cartas; i++) {
				valor++;
				carta_Baraja = new Carta(palo, Integer.toString(i), valor);
				cartas.add(carta_Baraja);
			}
		
			// A�ade figuras
			for (String figura :figuras) {
				valor++;
				carta_Baraja = new Carta(palo, figura, valor);
				cartas.add(carta_Baraja);
			}
		}
	}
	
	abstract void reiniciar();
	
}
