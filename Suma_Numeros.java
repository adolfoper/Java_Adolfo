package ejercicios_T1;

import java.util.Scanner;

public class Suma_Numeros {
	public static void main (String args[]){
		
		int numeros [] = new int [10];
		int suma = 0;
	
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca 10 números para sumarlos\n");	
	
//		Blucle de introducción de 10 números
		for (int i = 0; i<10; i++)
		{
			System.out.println("Introduzca número " + (i+1));
			numeros[i] = sc.nextInt();
			suma = suma + numeros[i]; 
		}				
		
		System.out.println("Suma de los 10 números:"+suma);	
		
		sc.close(); 
		
	}

}
