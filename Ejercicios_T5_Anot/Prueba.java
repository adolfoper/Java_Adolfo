package Ejercicios_T5_Anot;

import java.util.Scanner;

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

		System.out.println("Introduzca frase a codificar");
		Scanner sc = new Scanner(System.in);
		String mensaje = sc.nextLine();
			
		// Cargar el contexto 1
		AnnotationConfigApplicationContext context1= new AnnotationConfigApplicationContext(CodificaConfig.class);
		
		// Cargar el contexto 2
		AnnotationConfigApplicationContext context2= new AnnotationConfigApplicationContext(CodificaConfig2.class);
				
		// Pedir los beans
		IProcesar palabra = context1.getBean("palabras", Palabras.class);		
		ICodificar invertir = context1.getBean("invertir", Invertir.class);		
		ICodificar cesar = context2.getBean("cesar", Cesar.class);
		
		// Prueba con el config 1 (palabras + invertir)
		Codificador codificador1 = context1.getBean("codificador",Codificador.class);		
		System.out.println("\nCodificado con palabras + invertir:");
		System.out.println(codificador1.codificar(mensaje));
		
		// Prueba con el config 1 (palabras + César)
		Codificador codificador2 = context2.getBean("codificador",Codificador.class);
		System.out.println("\nCodificado con palabras + César:");
		System.out.println(codificador2.codificar(mensaje));	
		
		// Cerrar contextos y scanner
		context1.close();
		context2.close();		
		sc.close();
		
				
	}

}