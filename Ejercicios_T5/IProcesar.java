package Ejercicios_T5;
import java.util.ArrayList;

//*
//* Interface de procesar texto
//*
public interface IProcesar {
	public ArrayList<String> dividir(String cadena); 
	public String unir(ArrayList<String> cadenas);
}
