package Ejercicios_T2;

public class E02_01_Empleado {

	//creamos los atributos publicos
	public String nombre;
	public String dni;
	public int sueldo;
	
	//
	//	Constructor con parametros
	//
	E02_01_Empleado(String nombre, String dni, int sueldo) {
		this.nombre = nombre;
		this.dni = dni;
		this.sueldo = sueldo;
	}
	
	//
	//   Constructor sin parametros
	//
	E02_01_Empleado() {
		this.nombre = "";
		this.dni ="";
		this.sueldo = 0;
	}
	
	//
	// Metodo Sueldo neto
	//	Retorna sueldo * 0.85
	//
	public int sueldo_Neto() {
		return ((int) Math.round(this.sueldo*0.85));
	}
}