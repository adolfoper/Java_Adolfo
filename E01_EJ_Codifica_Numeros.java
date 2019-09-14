package ejercicios_T1;

import java.util.Scanner;

import java.util.ArrayList;

public class E01_EJ_Codifica_Numeros {
	
	static Scanner sc = new Scanner(System.in);
	//static String tabla_conversion [][] = new String [9][3];
	static char tabla_conversion [] [] =   {{'A','B','C'},
									  		{'D','E','F'},
									  		{'G','H','I'},
									  		{'J','K','L'},
									  		{'M','N','O'},
									  		{'P','R','S'},
									  		{'T','U','V'},
									  		{'W','X','Y'}};
	 
	public static void main (String args[]){
		
		String opcion = "";
		
		// Repetir hasta pulsar salir
		do
		{
			// Repetir hasta opción correcta
			do
			{
				System.out.println("\nIntroduzca un opción: 1-Codificar, 2-Decodificar, 3-Finalizar)");	
				opcion = sc.nextLine();
				if (!opcion.equals("1") & !opcion.equals("2") & !opcion.equals("3"))
					System.out.println("Opción errónea");	
			}
			while (	!opcion.equals("1") & !opcion.equals("2") & !opcion.equals("3"));
		
			if (opcion.equals("1"))
				codifica_A_Numero();
			else if (opcion.equals("2"))
				decodifica_A_Palabra();
			
		} while (!opcion.equals("3"));
		
		System.out.println("Fin del programa");	
		sc.close(); 
	}
	
	
	// Converte una palabra a numéro codificado
	public static void codifica_A_Numero (){
				
		System.out.println("\nCarácteres no reconocibles se mostrarán como ceros");	
		System.out.println("\nIntroduzca una palabra y pulse intro");	
  		String palabra = sc.nextLine();
  		
  		String cod_numero = "";
  		
  		// Recorre la palabra asignandole el codigo numérico
  		for (char c: palabra.toCharArray ()) 
  		{ 
  			cod_numero += obtiene_Cod_Numero(c);
  		}	
		System.out.println("Resultado: "+cod_numero);	
	}
	
	// Encuentra la codificación de un caracter a numérico
	// Devuelve "0" si no lo encuentra
	public static String obtiene_Cod_Numero (char c)
	{
		
		// para el caracter a mayúculas
	    if(Character.isLowerCase(c))
	       c = Character.toUpperCase(c);
		
		String encontrado = "0";
		
		// búsqueda en la tabla de conversión
		for (int i=0;(i<8 & encontrado == "0"); i++)
		{
			for (int j=0;(j<3 & encontrado == "0"); j++)
			{
				if (c==tabla_conversion[i][j])
				encontrado = Integer.toString(i+2);
			}
		}	
		
		return encontrado;
	}
	
	// Converte un numéro codificado a las posibles palabras decodificadas
	public static void decodifica_A_Palabra (){
				
		ArrayList<Integer> lista_posiciones = new ArrayList<Integer>();
		ArrayList<String> lista_palabras_cod = new ArrayList<String>();
		
		System.out.println("\nDígitos no reconocibles se mostrarán como espacios");	
		System.out.println("\nIntroduzca un número con dígitos de 2 a 9 y pulse intro");	
		String numero = sc.nextLine();

  		// Recorre el número asignandole una posicion en la tabla de conversion e
		// inicializando el número de interaciones a 0
		for (char c: numero.toCharArray ()) 
  		{
			lista_posiciones.add(obtiene_Posicion(c));
  		}
		
		// Genera la lista de palabras codificadas
		lista_palabras_cod = genera_Palabras_Cod(lista_palabras_cod, lista_posiciones,0,"");
		
		System.out.println("\nPalabras posibles:");	

		for (String s :lista_palabras_cod)
			System.out.println(s);
	}
	
	// Asigna a un caracter numérico su posicion en la tabla de conversion
	public static int obtiene_Posicion (char c)
	{ 	
		Integer pos;
		
		if (c>='2' & c<='9')
		{
			pos = c - '0';
			pos = pos - 2;
		}
		else
			pos = -1;
		
		return pos;
	}
	
	// Devuelve una lista de palabras generada a partir de una lista de posiciones de 
	// la tabla de conversion.
	// Es recursiva.
	// Variables: Lista donde se cargan las palabras, lista de posiciones de letras, posicion actual en la lista de posiciones de letras, palabra actual 
	public static ArrayList<String> genera_Palabras_Cod (ArrayList<String> lista_palabras_cod, ArrayList<Integer> lista_posiciones, int indice, String palabra_ent)
	{	
		String letra;
		String palabra;
		
		// posicion actual
		int fila = lista_posiciones.get(indice);
		
		// para las tres columnas de la posicion
		for (int i=0; i<3; i++)
		{
			// recupera la letra que corresponde a la posición / columna actual
			if (fila == -1)
				letra = " ";
			else
				letra = Character.toString(tabla_conversion[fila] [i]);

			// incorpora letra a la palabra
			if (indice == 0)
				palabra = letra;
			else
				palabra = palabra_ent + letra;
			
			// Si no hemos llegado al final de la lista llamamos al siguiente nivel 
			if (indice < lista_posiciones.size()-1)
				lista_palabras_cod = genera_Palabras_Cod (lista_palabras_cod, lista_posiciones, indice+1, palabra);
			else
			// si nos hallamos al final de la lista. Incorporamos la palabra a la lista resultado.
				lista_palabras_cod.add(palabra);
		}
		
		return lista_palabras_cod;
	}
	
}
