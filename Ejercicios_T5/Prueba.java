package Ejercicios_T5;

public class Prueba {
	public static void main(String args[]) {
		
		//char c;
		//int valor_ascii = 123;
		
		//final int ini_alfabeto = 97;
		//final int fin_alfabeto = 122;
		
		//valor_ascii = valor_ascii + ini_alfabeto - fin_alfabeto - 1;
		
		//System.out.println(valor_ascii);
		
		//valor_ascii = 96;
		//valor_ascii = valor_ascii - ini_alfabeto + fin_alfabeto + 1;
			
		//Cesar cesar = new Cesar();
		//System.out.println(cesar.codificar("AB_c wxyz"));	
		//System.out.println(cesar.decodificar("CD_e yzab"));
		//System.out.println(cesar.decodificar(""));
		
		//Invertir invertir = new Invertir();
		//System.out.println(invertir.codificar("AB_c wxyz"));
		//System.out.println(invertir.decodificar("zyxw c_BA"));
		//System.out.println(invertir.decodificar(""));
		
		//Palabras palabra = new Palabras();
		//System.out.println(palabra.dividir("AB_c wxyz"));
		//System.out.println(palabra.dividir("A B_c wx*y z"));
		//System.out.println(palabra.dividir("a"));		
		//System.out.println(palabra.unir(palabra.dividir("AB_c wxyz")));
		//System.out.println(palabra.unir(palabra.dividir("A B_c wx*y z")));
		//System.out.println(palabra.unir(palabra.dividir(" ")));

		//Bloques bloque = new Bloques();
		//System.out.println(bloque.dividir("AB_c wxyz"));
		//System.out.println(bloque.dividir("A B_c wx*y z"));
		//System.out.println(bloque.dividir("a"));	
		
		IProcesar palabra = new Palabras();
		ICodificar invertir = new Invertir();
		
		Codificador codificador = new Codificador (palabra, invertir);
		
		System.out.println(codificador.codificar("Hola vecino"));
		
				//System.out.println(bloque.dividir("A B_c wx*y z"));
				//System.out.println(bloque.dividir("a"));	
						
				
	}

}