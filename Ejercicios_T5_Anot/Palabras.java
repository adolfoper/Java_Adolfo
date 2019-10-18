package Ejercicios_T5_Anot;

import java.util.ArrayList;
import org.springframework.stereotype.Component;


//* 
//* Clase para cortar y ensamblar palabras de un String
//*
public class Palabras implements IProcesar {
	
	//*
	//*  Divide una frase en palabras
	//*
	@Override
	public ArrayList<String> dividir(String cadena)
	{
	  String texto = new String();
	  texto = cadena;
		
	  ArrayList<String> fragmentos = new ArrayList<String>();
	  int ini_frag = 0;
  	  int fin_frag = 0;
		
  	  while (ini_frag < texto.length())
  	  {
		//		Saltamos blancos del principio si los hubiera
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
			fin_frag = texto.indexOf(" ",ini_frag + 1);
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
	
	//*
	//*  Une una lista de palabras en una frase separándolas con un espacio
	//*
	@Override
	public String unir(ArrayList<String> cadenas)
	{
		String frase = "";
		boolean primera_vez = true;
		
		for (String palabra: cadenas) {
			if (!primera_vez) {
				frase += " ";	
			}
			else
				primera_vez = false;
			frase += palabra;
		}
		return frase;
	}
	
}
