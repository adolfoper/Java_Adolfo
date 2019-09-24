package Ejercicios_T2A2;

import Ejercicios_T2A2.Francesa;

public class Prueba_Cartas {
	
	public static void main (String args[]){
		
		Francesa baraja_Francesa = new Francesa();	
		System.out.println(baraja_Francesa.cartas);
		
		baraja_Francesa.reiniciar();
		System.out.println(baraja_Francesa.cartas);
		
		Espanyola baraja_Espanyola = new Espanyola();	
		System.out.println(baraja_Espanyola.cartas);
		
		baraja_Francesa.reiniciar();
		System.out.println(baraja_Espanyola.cartas);
	}

}


