package ejercicios_T1;

import java.util.Scanner;

public class SumaMult {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Suma y multiplicaci�n de dos n�meros enteros \n");
		
		System.out.println("Introduzca el primer n�mero:");	
		int num1 = sc.nextInt();
		
		System.out.println("Introduzca el segundo n�mero:");
		int num2 = sc.nextInt();

		System.out.println("La suma es: "+(num1+num2));
		System.out.println("La multiplicaci�n es: "+(num1*num2));
		
		sc.close(); 
		
	}

}
