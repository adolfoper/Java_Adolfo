package Ejercicios_T5;


//* 
//* Clase para codificar y decodificar un String invirtiendo las letras
//*
public class Cesar implements ICodificar {

	final int salto = 2;  // Numero de posiciones a saltar en la dodificacion
	final int ini_alfabeto = 97;   // inicio de alfabeto minúsculas
	final int fin_alfabeto = 122;  // inicio de alfabeto minúsculas
	
	//*
	//*   Codifica un String invirtiendo las letras
	//*
	@Override
	public String codificar(String cadena)
	{	
  	   	return trasladar(cadena,salto);
	}
	
	//*
	//*   Decodifica un String invirtiendo las letras
	//*
	@Override
	public String decodificar(String cadena)
	{
		return trasladar(cadena, -salto);
	}
	
	//
	//   Cambia un texto trasladando sus letras hacia delante o hacia atrás
	//
	private String trasladar (String cadena, int desplaza) {
		String salida = new String();
		int valor_ascii;
		String texto = cadena.toLowerCase();	
			
		// Recorre el texto aplicando codificacion cesar a cada letra (num posicones es salto)
	  	for (char c: texto.toCharArray()) {
	  		texto=Character.toString(c);
	  		valor_ascii = (int) c;
	  		 
	  		// Si es un acarcter alfabético, convertir
	  		if (valor_ascii >= ini_alfabeto & valor_ascii <= fin_alfabeto){ 
	  			
	  			valor_ascii =  valor_ascii + desplaza;
	  			
	  	  		// Si da la vuelta al alfabeto por arriba, contar desde el principio
	  			if (valor_ascii > fin_alfabeto){
	  				valor_ascii = valor_ascii + ini_alfabeto - fin_alfabeto - 1;
	  			}
	  			
	  			// Si da la vuelta al alfabeto por abajo, contar desde el final
	  			if (valor_ascii < ini_alfabeto){
	  				valor_ascii = valor_ascii - ini_alfabeto + fin_alfabeto + 1;
	  			}
	  			
	  			c = (char)valor_ascii;
	  		 }
			salida += Character.toString(c);	 
	  	  }
	  	
	  	  return salida;
	}
	
}
