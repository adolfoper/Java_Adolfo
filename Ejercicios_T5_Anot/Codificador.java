package Ejercicios_T5_Anot;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

//* 
//* Clase para codificar y decodificar frases con Iproceso + ICodificacion
//*
public class Codificador {
	
	IProcesar proceso;
	ICodificar codificado;
	
	//*
	//*  Constructor
	//*
	public Codificador(IProcesar proceso, ICodificar codificado){
		this.proceso = proceso;
		this.codificado = codificado;
	}
	
	//*
	//*  Codifica una frase con Iproceso + ICodificacion
	//*
	public String codificar(String cadena)
	{
	  	
		// Divide la cadena en trozos según el tipo de objeto IProceso
		ArrayList<String> trozos = proceso.dividir(cadena);
		ArrayList<String> trozos_codif = new ArrayList<String>();
		
		// Codifica cada trozo según el tipo de objeto ICodificacion
		for(String unTrozo: trozos) {
			trozos_codif.add(codificado.codificar(unTrozo));
		}
		
		// Junta los trozos segun el tipo de objeto IProceso
		String salida = proceso.unir(trozos_codif);
		
		return salida;
	}
	
	//*
	//*  Decodifica una frase con Iproceso + ICodificacion
	//*
	public String decodificar(String cadena)
	{
	  	
		// Divide la cadena en trozos según el tipo de objeto IProceso
		ArrayList<String> trozos = proceso.dividir(cadena);
		ArrayList<String> trozos_codif = new ArrayList<String>();
		
		// Decodifica cada trozo según el tipo de objeto ICodificacion
		for(String unTrozo: trozos) {
			trozos_codif.add(codificado.decodificar(unTrozo));
		}
		
		// Junta los trozos segun el tipo de objeto IProceso
		String salida = proceso.unir(trozos_codif);
		
		return salida;
	}
		
}
