package Ejercicios_T5_Anot;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

//*
//*  Divide una frase en bloques de 4 posiciones
//*
@Component
public class Bloques implements IProcesar {
	
	//
	//  Divide una frase en palabras
	//
	@Override
	public ArrayList<String> dividir(String cadena)
	{
	  String texto = new String();
	  texto = cadena;
		
	  ArrayList<String> fragmentos = new ArrayList<String>();
	  int ini_frag = 0;
  	  int fin_frag = 4;
		
  	  // Recorre el texto cortando fragmentos de 4 carácteres
  	  while (fin_frag < texto.length())
  	  {	
  		  //			Insertamos fragmento en la lista
  		  fragmentos.add (texto.substring(ini_frag,fin_frag));

  		  //			Resituamos los contadores de fragmento
  		  ini_frag = ini_frag + 4;
  		  fin_frag = fin_frag + 4;
  	  }
  	  
  	  // Insertamos el último trozo menor de 4 posiciones
  	  if (ini_frag < texto.length()) 
		{
  		  fragmentos.add (texto.substring(ini_frag,texto.length()));
		}
  	  return fragmentos;
	}
	
	//
	//  Une una lista de palabras en una frase
	//
	@Override
	public String unir(ArrayList<String> cadenas)
	{
		String frase = "";
		
		for (String palabra: cadenas) {
			frase += palabra;
		}
		return frase;
	}
	
}
