package ejercicios_T1;

import java.util.Scanner;
import java.util.ArrayList;

public class E01_06_Num_Arraylist {
	public static void main (String args[]){
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int numero = 0;
		boolean hay_Par = false;
		int suma = 0;
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca n�meros del 1 al 10. 0 para terminar \n");	
		numero = sc.nextInt();
		
//		Blucle de introducci�n de n n�meros
		while (numero != 0)
		{
			if (numero < 0 | numero > 10)
				System.out.println("Los numeros han de ser del 1 al 10, vuelva a intentarlo.");		
			else
				lista.add(numero);
			
			numero = sc.nextInt();
		}				
		
//		Mostrar total de elementos		
		System.out.println("Total n�meros introducidos: "+lista.size());
		
//		Mostrar numeros pares y sumar
		System.out.println("Lista de n�meros pares introducidos: ");
		
		for (int numero_Recuperado: lista)
		{	
			// lista numeros pares
			if (numero_Recuperado % 2 == 0)
			{
				System.out.println(numero_Recuperado);
				hay_Par = true;
			}
			
			// suma numeros		
			suma = suma + numero_Recuperado;
		}
		
		if (!hay_Par)
			System.out.println("No hay numeros pares");
		
		System.out.println("Suma de n�meros introducidos: ");
		System.out.println(suma);
		
		sc.close(); 
			
	}

}
