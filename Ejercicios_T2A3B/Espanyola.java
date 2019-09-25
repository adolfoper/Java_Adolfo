package Ejercicios_T2A3B;

public class Espanyola extends Baraja {
	
	// definicion figuras de la baraja francesa
	static String palos [] = {"Oros","Bastos","Copas","Espadas"};
	static String figuras [] = {"Sota","caballo","Rey"};
	static int num_cartas = 7;
	
	//
	//	Constructor 
	//
	public Espanyola() {
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
