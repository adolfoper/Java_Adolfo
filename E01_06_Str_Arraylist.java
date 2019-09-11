package ejercicios_T1;

import java.util.Scanner;
import java.util.ArrayList;

public class E01_06_Str_Arraylist {
	public static void main (String args[]){
		
		ArrayList<String> lista = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca una frase y pulse intro \n");	
  		String frase = sc.nextLine();

//		Convertir signos de puntuacion en blancos
  		frase = frase.replace(',',' ').replace(';',' ')
                .replace('¡',' ').replace('!',' ')
                .replace('?', ' ').replace('¿', ' ').replace('.', ' ');
		
		//		Extracción de palabras de la frase
  		int ini_palabra = 0;
  		int fin_palabra = 0;
  		
		while (ini_palabra < frase.length())
		{
			//		Determinamos inicio de palabra
			while (ini_palabra < frase.length())
			{
				// solo puedo usar CharAt tras haberme asegurado que no se sobrepasa el length
				if (frase.charAt(ini_palabra)!=' ')
					break;
				
				++ini_palabra;
			}
			
			if (ini_palabra < frase.length()) 
			{
				//		Determinamos final de palabra
				fin_palabra = frase.indexOf(" ",ini_palabra + 1);
				if (fin_palabra == -1)
					fin_palabra = frase.length();
				
				//			Extraemos palabra en la lista
				lista.add (frase.substring(ini_palabra,fin_palabra));

				//			Resituamos inicio de palabra
				ini_palabra = fin_palabra + 1;
			}
		}
	
  		System.out.println("Número de palabras: "+lista.size());
		
		// El ejercicio es determinar la palabra mas larga recorriendo el arraylist
		// aunque se pueda determinar en su carga
		
		if (lista.size() > 0) 
		{
			int long_max = 0;
			String palabra_max = "";
		
			// Determina la palabra mas larga (Si hay varias se queda con una)
			for (String palabra:lista)
			{
				if (long_max < palabra.length())
				{
					long_max = palabra.length();
					palabra_max = palabra;
				}
			}
			 System.out.println("Palabra más larga: "+palabra_max);
		}
		else
		  System.out.println("No hay palabras para seleccionar");
		
		sc.close(); 
			
	}

}
