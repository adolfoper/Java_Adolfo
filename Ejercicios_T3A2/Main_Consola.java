package Ejercicios_T3A2;

public class Main_Consola {

	public static void main(String[] args) {
		 Jugador eva = new Jugador("Eva", new Teclado());
         Jugador juan = new Jugador("Juan", new CPU());
         Consola mostrar = new Consola();
         Juego ppt = new Juego(eva, juan, new JuegoPPTLS(),mostrar);
         mostrar.mostrar(ppt.jugar());
	}
}
