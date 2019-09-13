package ejercicios_T1;

import java.util.Scanner;

import ejercicios_T1.E01_EJ_Analiza_Texto.Par;

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
		
/*		do
		{
			System.out.println("\nIntroduzca un opción: 1-codificar, 2-decodificar)");	
			opcion = sc.nextLine();
		}
		while (	!opcion.equals("1") & !opcion.equals("2"));
		*/
		opcion="1";
		
		if (opcion.equals("1"))
			codifica_A_Numero();
 		else
 			decodifica_A_Palabra();
		
		sc.close(); 
	}
	
	
	// Converte una palabra a numéro codificado
	public static void codifica_A_Numero (){
				
		System.out.println("\ncarácteres no reconocibles se mostrarán como ceros");	
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
	
	// Converte un numéro codificado a las posibles palabras decodificadas
	public static void decodifica_A_Palabra (){
				
		ArrayList<Pos_Itera> lista_posiciones = new ArrayList<Pos_Itera>();
		
		System.out.println("\ndígitos no reconocibles se mostrarán como espacios");	
		System.out.println("\nIntroduzca un número con dígitos de 2 a 9 y pulse intro");	
		String numero = sc.nextLine();

  		// Recorre el número asignandole una posicion en la tabla de conversion e
		// inicializando el número de interaciones a 0
		for (char c: numero.toCharArray ()) 
  		{
			lista_posiciones.add(obtiene_Posicion(c));
  		}
	
		// Genera la lista de palabras codificadas
		ArrayList<String> palabras_cod = genera_Palabras_Cod(lista_posiciones);
		
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
	
	// Asigna a un caracter numérico una posicion en la tabla de conversion e
	// inicializa su número de interaciones a 0
	public static Pos_Itera obtiene_Posicion (char c)
	{
	
	  	Pos_Itera pos_itera = new Pos_Itera(-1,0);
	  	
		if (c>='2' & c<='9')
		{
			pos_itera.posicion = (Integer.valueOf(c)-2);
		}
		
		return pos_itera;
	}
	
	// Devuelve una lista de palabras generada a partir de una lista de posiciones de 
	// la tabla de conversion.
	public static ArrayList<String> genera_Palabras_Cod (ArrayList<Pos_Itera> lista_posiciones)
	{	
		ArrayList<String> lista_palabras_cod = new ArrayList<String>();
		
		// compone las palabras a partir de la tabla de conversion y las añade a la lista de salida
		for (int i=0; i<lista_posiciones.size(); i++)
		{
			String palabra = "";
			int pos = lista_posiciones.get(i).posicion;
					
			for (int j=0; j<3; j++)
			{
				palabra += Character.toString(tabla_conversion[i][j]);
			}
			lista_palabras_cod.add(palabra);
		}
		
		return lista_palabras_cod;
	}
	
	//***************************************************
	// clase de datos posicion + iteracion
	//***************************************************
	public static class Pos_Itera
	{
		//creamos los atributos privados
		public int posicion;
		public int iteracion;
		
	//
	//   Constructor sin parametros
	//
		public Pos_Itera() {
			this.posicion =0;
			this.iteracion =0;
		}
	
	//
	//	Constructor con parametros
	//
		public Pos_Itera(int posicion, int iteracion) {
			this.posicion  =posicion;
			this.iteracion =iteracion;
		}
	}
}
