package Ejercicios_T2A3B;

public class Francesa extends Baraja {
	
	// definicion figuras de la baraja francesa
	static String palos [] = {"Picas","Tréboles","Diamantes","Corazones"};
	static String figuras [] = {"J","Q","K"};
	static int num_cartas = 10;
	
	//
	//	Constructor 
	//
	public Francesa() {
		reiniciar();
	}
	
	//
	//	Reiniciar
	//
	void reiniciar() {
		
		//  Borrado de baraja
		while (cartas.size()>0) {
			cartas.remove(0);
		}
		
		// Generar baraja
		crea_Baraja(palos,num_cartas,figuras);
	}
	
}
