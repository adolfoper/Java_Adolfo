package ejercicios_T1;

import java.util.Scanner;

public class SumaMult {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Suma y multiplicación de dos números enteros \n");
		
		System.out.println("Introduzca el primer número:");	
		int num1 = sc.nextInt();
		
		System.out.println("Introduzca el segundo número:");
		int num2 = sc.nextInt();

		System.out.println("La suma es: "+(num1+num2));
		System.out.println("La multiplicación es: "+(num1*num2));
		
		sc.close(); 
		
	}

}
