package ejercicios_T1;

import java.util.Scanner;

public class Port_aventura {
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Autorizaci�n para subir en la atracci�n \n");
		
		System.out.println("Introduzca su edad:");	
		int edad = sc.nextInt();
		
		System.out.println("Introduzca su altura en cent�metros:");
		int altura = sc.nextInt();
		
		if (edad > 16 | altura > 140)
			System.out.println("Enhorabuena, est� autorizado");
		else
			System.out.println("Lo sentimos, no est� autorizado");
		
		sc.close(); 
		
	}

}
