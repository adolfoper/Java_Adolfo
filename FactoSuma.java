package ejercicios_T1;

import java.util.Scanner;

public class FactoSuma {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un n�mero mayor que 1 para sumatorio:");
		
		int suma = 0;
		int numero = sc.nextInt();
		
//		No perar si n�mero incorrecto
		if (numero <= 1)
		    System.out.println("El n�mero no es mayor que uno");
		else
		{
//			Bucle de 1 a numero
			for (int x=1;x<=numero;x++)
				suma = suma +x;
		
			System.out.println("Sumatorio: "+suma);
		}
		
		sc.close(); 
		
	}

}
