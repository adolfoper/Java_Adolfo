package ejercicios_T1;

import java.util.Scanner;
import java.util.Arrays;

public class Ordena_Numeros {
	public static void main (String args[]){
		
		int numeros [] = new int [10];
		int suma = 0;
	
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca 10 números para sumarlos\n");	
	
//		Blucle de introducción de 10 números
		for (int i = 0; i<10; i++)
		{
			System.out.println("Introduzca número " + (i+1)+":");
			numeros[i] = sc.nextInt();
			suma = suma + numeros[i]; 
		}				

		int intermedia;
		
//		Ordenar array
//      Supongo que Arrays.sort(numeros) no vale ;)
		for(int i=0; i<9;i++)
		{
			for(int j=i+1;j<10;j++)
			{
//				Si elemento i es mayor que elmento j intercambianos los valores
				if(numeros[i]>numeros[j])
				{
					intermedia=numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=intermedia;
				}
			}	
		}
		System.out.println("Números ordenados:\n");
		System.out.println(Arrays.toString(numeros));

		sc.close();
	}

}
