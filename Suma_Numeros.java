package ejercicios_T1;

import java.util.Scanner;

public class Suma_Numeros {
	public static void main (String args[]){
		
		int numeros [] = new int [10];
		int suma = 0;
	
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca 10 n�meros para sumarlos\n");	
	
//		Blucle de introducci�n de 10 n�meros
		for (int i = 0; i<10; i++)
		{
			System.out.println("Introduzca n�mero " + (i+1));
			numeros[i] = sc.nextInt();
			suma = suma + numeros[i]; 
		}				
		
		System.out.println("Suma de los 10 n�meros:"+suma);	
		
		sc.close(); 
		
	}

}
