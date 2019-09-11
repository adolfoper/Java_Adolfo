package ejercicios_T1;

import java.util.Scanner;

public class Trata_Palabras {
	
	// main llamará a los dos métodos para poder probarlos en el ejercicio
	// No valida que los strings introducidos sean una sola palabra
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		
		// Ejecucion metodo Palabra_Mas_Larga
  		System.out.println("Comparador de palabras \n");
		
  		System.out.println("Introduzca primera palabra:");	
  		String palabra1 = sc.nextLine();
		
  		System.out.println("Introduzca segunda palabra:");	
 		String palabra2 = sc.nextLine();
		
 		System.out.println("Palabra mas larga: "+Palabra_Mas_Larga(palabra1,palabra2)+"\n");	
		
		// Ejecucion metodo Contar_Letras
  		System.out.println("Contador de letras en una palabra \n");
		
  		System.out.println("Introduzca una palabra:");	
  		String palabra = sc.nextLine();
		
  		System.out.println("Introduzca la letra a buscar:");	
  		String letra = sc.nextLine();
		
  		System.out.println("Número de ocurrencias:"+Contar_Letras(palabra,letra)+"\n");	
		
		sc.close(); 
		
	}
	
	// Compara dos strings y devuelve el más largo
	public static String Palabra_Mas_Larga (String palabra1,String palabra2){
		if (palabra1.length() > palabra2.length())
			return (palabra1);
		else if (palabra1.length() < palabra2.length())
			return (palabra2);
		else
			return ("Son de igual longitud");
	}
	
	public static int Contar_Letras (String palabra, String letra){
//      Contador de ocurrencias
		int conta = 0;                             

//      Localización de la primera letra
		int pos = palabra.indexOf(letra);
		
//        Búsqueda de las siguientes letras 'a'	
		while (pos !=-1)
		{	
			conta++;
			pos = palabra.indexOf(letra,pos+1);
		}
		
		return (conta); 
	}

}
