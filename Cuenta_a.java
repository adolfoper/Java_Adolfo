package ejercicios_T1;

import java.util.Scanner;

public class Cuenta_a {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Contador de letras \'a\' \n");
		
		System.out.println("Introduzca una palabra:");	
		String palabra = sc.nextLine();

//      Contador de ocurrencias
		int conta = 0;                             

//      Localización de la primera letra 'a'
		int pos = palabra.indexOf("a");
		System.out.println("palabra:"+palabra);
		
//        Búsqueda de las siguientes letras 'a'	
		while (pos !=-1)
		{	
			conta++;
			pos = palabra.indexOf('a',pos+1);
		}
		
		System.out.println("Total letras \'a\': "+conta);
		
		sc.close(); 
		
	}

}
