package ejercicios_T1;

import java.util.Scanner;
import java.util.Arrays;

public class Introduce_Productos {
	public static void main (String args[]){
		
		String productos [] = new String [5];
		boolean repetido = false;
	
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca los nombres de 5 productos diferentes\n");	
	
//		Blucle de introducción de 5 productos
		for (int i = 0; i<5; i++)
		{
			do
			{
				System.out.println("Introduzca producto " + (i+1)+":");
				productos[i] = sc.nextLine();
				
				// verifica que el producto no esté repetido
				repetido = false;
				
				for (int j = 0; j<i; j++)
				{
					if (productos[i].contentEquals(productos[j]))
					{
						System.out.println("Producto repetido, por favor vuelva a intentarlo.");
						repetido = true;
						break;
					}
				}
			}
			// repetir introducción hasta que el dato sea correcto
			while (repetido);
		}				
		
		System.out.println("Productos introducidos:\n");
		System.out.println(Arrays.toString(productos));

		sc.close();
	}

}
