package ejercicios_T1;

import java.util.Scanner;
import java.util.ArrayList;

public class E01_EJ_Analiza_Texto {
	public static void main (String args[]){
		
		ArrayList<String> frases = new ArrayList<String>();
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<Par> palabra_ocurr = new ArrayList<Par>();
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Introduzca un texto y pulse intro \n");	
  		String texto = sc.nextLine();

//		Convertir signos de puntuacion no usados en blancos
  		texto = texto.replace(',',' ').replace(';',' ')
                .replace('¡',' ').replace('!',' ')
                .replace('?', ' ').replace('¿', ' ');
 
//		Extracción de las frases separadas por puntos 		
  		frases = extrae_Fragmentos (texto,".");
  		System.out.println("Fragmentos: "+frases+"\n");

//		Extracción de palabras separadas por espacio
  		for (String frase_unica: frases)
  		{
  	  		palabras.addAll(extrae_Fragmentos (frase_unica," "));
  		}
  		
//		Genera un arrayList de palabras ordenadas por su numero de ocurrencia
  		palabra_ocurr = ordena_Por_Ocurrencia(palabras);		
  		
// 		Lista las frases ordenadas por tamaño
		System.out.println("\nFrases ordenadas por tamaño"); 
		System.out.println("---------------------------"); 
  		for (String una_frase: frases)
  		  	System.out.println(una_frase); 
  		
// 		Lista las palabras ordenadas por ocurrencia
		System.out.println("\nPalabras ordenas por número de ocurrencias"); 
		System.out.println("------------------------------------------"); 
  		for (Par una_palabra_ocurr: palabra_ocurr)
  		{
  		  	System.out.println(una_palabra_ocurr.palabra+ " "+una_palabra_ocurr.ocurrencia); 
  		}
  		
		sc.close(); 
	}
	
	//
	// Crea un ArrayList a partir de un string y un delimintador
	//
	public static ArrayList<String> extrae_Fragmentos (String texto, String delimitador){
			    
		ArrayList<String> fragmentos = new ArrayList<String>();
		int ini_frag = 0;
  		int fin_frag = 0;
		
		while (ini_frag < texto.length())
		{
			//		Determinamos inicio de frase
			while (ini_frag < texto.length())
			{
				// CharAt no pude estar en el while por si ini_frag sobrepasa el length
				if (texto.charAt(ini_frag)!=' ')
					break;
				
				++ini_frag;
			}
			
			if (ini_frag < texto.length()) 
			{
				//		Determinamos final de fragmento
				fin_frag = texto.indexOf(delimitador,ini_frag + 1);
				if (fin_frag == -1)
					fin_frag = texto.length();
				
				//			Insertamos fragmento en la lista
				fragmentos.add (texto.substring(ini_frag,fin_frag));

				//			Resituamos inicio de fragmento
				ini_frag = fin_frag + 1;
			}
		}
  		
		return fragmentos;
	}

	
	//
	// Ordena un ArrayList por tamaño
	//
	public static ArrayList<String> ordena_Por_Tamaño (ArrayList<String> lista){
  
		ArrayList<String> lista_ordenada = new ArrayList<String>(lista);
		String intermedia;
  		
		for(int i=0; i<lista_ordenada.size()-1;i++)
		{
			for(int j=i+1; j< lista_ordenada.size();j++)
			{
//				Si elemento i es mayor que elmento j intercambianos los valores
				if(lista_ordenada.get(i).length() > lista_ordenada.get(j).length())
				{
					intermedia=lista_ordenada.get(i);
					lista_ordenada.set(i,lista_ordenada.get(j));
					lista_ordenada.set(j,intermedia);
				}
			}	
		}
	
		return lista_ordenada;
	}

	
	//
	// Ordena un ArrayList alfabéticamente
	//
	public static ArrayList<String> ordena_Alfabeticamente (ArrayList<String> lista){
  
		ArrayList<String> lista_ordenada = new ArrayList<String>(lista);
		String intermedia;
  		
		for(int i=0; i<lista_ordenada.size()-1;i++)
		{
			for(int j=i+1; j< lista_ordenada.size();j++)
			{
//				Si elemento i es mayor que elmento j intercambianos los valores
				if(lista_ordenada.get(i).compareTo ( lista_ordenada.get(j) ) > 0)
				{
					intermedia=lista_ordenada.get(i);
					lista_ordenada.set(i,lista_ordenada.get(j));
					lista_ordenada.set(j,intermedia);
				}
			}	
		}
		
		return lista_ordenada;
	}

	//
	// Ordena un ArrayList por frecuencia de palabras.
	// En caso de igual número de frecuencia deja la primera por orden alfabético.
	//
	public static ArrayList<Par> ordena_Por_Ocurrencia (ArrayList<String> lista){
  
		ArrayList<String> lista_ordenada = new ArrayList<String>(lista);
		ArrayList<Par> lista_palabra_ocurrencia = new ArrayList<Par>();
		
		Par intermedia;

		//		Ordena las palabras como fase previa a contar ocurrencias 
		lista_ordenada = ordena_Alfabeticamente(lista_ordenada);
  		
  		//		Crea ArrayList de palabras + ocurrencia 
		lista_palabra_ocurrencia = crea_Lista_Palabra_Ocurrencia(lista_ordenada); 
		
		for(int i=0; i<lista_palabra_ocurrencia.size()-1;i++)
		{
	
			for(int j=i+1; j<lista_palabra_ocurrencia.size();j++)
			{
				
				//		Si elemento i es mayor que elmento j intercambianos los valores			
				if (lista_palabra_ocurrencia.get(i).ocurrencia > 
				    lista_palabra_ocurrencia.get(j).ocurrencia)
				{
					intermedia=lista_palabra_ocurrencia.get(i);
					lista_palabra_ocurrencia.set(i,lista_palabra_ocurrencia.get(j));
					lista_palabra_ocurrencia.set(j,intermedia);
					j++;
				}
			}	
		}

		return lista_palabra_ocurrencia;
	}
	
	//
	// Crea una lista de palabras con su número de repeticiones. 
	//
	public static ArrayList<Par> crea_Lista_Palabra_Ocurrencia (ArrayList<String> lista){
	
		ArrayList<Par> lista_palabra_ocurrencia = new ArrayList<Par>();
	  	Par par_act = new Par("",0);
		String palabra;
		int i = 0;
		
		//  Recorre la lista ordenada
		for(i=0;i<lista.size();i++)
		{
			palabra = lista.get(i);

			// palabra repetida
			if (par_act.palabra.equals(palabra))
			{
				++par_act.ocurrencia;
			}
			// nueva palabra
			else
			{
				// graba palabra anterior
		  		if (i != 0)
		  			lista_palabra_ocurrencia.add(par_act);	
				
				// inicializa nueva palabra
				par_act = new Par(palabra,1);
				par_act.ocurrencia = 1;
			}
			
		}

		// graba la última palabra
		if (lista.size()>0)	
			lista_palabra_ocurrencia.add(par_act);	
		
		return lista_palabra_ocurrencia;
	}	
	
	//***************************************************
	// clase par de datos palabra + ocurrencia
	//***************************************************
	public static class Par
	{
		//creamos los atributos privados
		public String palabra;
		public int ocurrencia;
		
	//
	//   Constructor sin parametros
	//
		public Par() {
			this.palabra = "";
			this.ocurrencia =0;
		}
	
	//
	//	Constructor con parametros
	//
		public Par(String palabra, int ocurrencia) {
			this.palabra = palabra;
			this.ocurrencia =ocurrencia;
		}
	}
}


