package Ejercicios_T3A2;

public class Consola implements IMostrar {

	public Consola() {
		// Nada que declarar
	}

	@Override
	public void mostrar(String literal) {
		System.out.println(literal);
	}

}
