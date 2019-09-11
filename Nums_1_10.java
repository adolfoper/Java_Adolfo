package ejercicios_T1;

import java.util.Scanner;

public class Nums_1_10 {
	public static void main (String args[]){
		
		Scanner sc = new Scanner(System.in);		
		int numero = 0;
		
		do
		{
			System.out.println("Introduzca un número del 1 al 10:");	
			numero = sc.nextInt();
			if (numero < 1 | numero > 10)
				System.out.println("Numero no válido, vuelva a intentarlo");
		} 
		while (numero < 1 | numero > 10);
		
		System.out.println("Número correcto:"+numero);	
		
		sc.close(); 
		
	}

}
