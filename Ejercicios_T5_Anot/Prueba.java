package Ejercicios_T5_Anot;

//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

// Clases de contexto
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Ejercicios_T5_Anot.*;

//@Configuration
//@ComponentScan("Ejercicios_T5_Anot")
public class Prueba {
	public static void main(String args[]) {
	
		// Cargar el contexto
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(CodificaConfig.class);
		
		// Pedir el bean
		IProcesar palabra = context.getBean("palabras", Palabras.class);
		//System.out.println(palabra.dividir("AB_c wxyz"));
		
		IProcesar bloque = context.getBean("bloques", Bloques.class);
		//System.out.println(bloque.dividir("AB_c wxyz"));
		
		ICodificar invertir = context.getBean("invertir", Invertir.class);
		//System.out.println(invertir.codificar("AB_c wxyz"));
		
		ICodificar cesar = context.getBean("cesar", Cesar.class);
		//System.out.println(cesar.codificar("AB_c wxyz"));
		
		Codificador codificador = context.getBean("codificador",Codificador.class);
		//Codificador codificador = new Codificador (palabra, invertir);
		System.out.println(codificador.codificar("Hola vecino"));
		
		// Cerrar el contexto
		context.close();				
				
	}

}