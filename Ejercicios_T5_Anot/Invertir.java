package Ejercicios_T5_Anot;

//* 
//* Clase para codificar y decodificar un String invirtiendo las letras
//*
public class Invertir implements ICodificar {
	
	//*
	//*   Codifica un String invirtiendo las letras
	//*
	@Override
	public String codificar(String cadena)
	{
	  String salida = new String();
		
  	  for (int i = cadena.length(); i>0; i--) {
  		 salida = salida + cadena.substring(i-1, i); 
  	  }

  	  return salida;
	}
	
	//*
	//*   Decodifica un String invirtiendo las letras
	//*
	@Override
	public String decodificar(String cadena)
	{
	  return codificar(cadena);
	}
	
}
