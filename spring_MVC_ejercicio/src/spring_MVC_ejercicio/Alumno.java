package spring_MVC_ejercicio;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Alumno {

	//@NotNull
	@Size(min = 3,message = "Debe introducir el nombre del alumno")
	private String nombre;
	
	private String dni;
	private String email;
	private String becado;
	private String asignatura;
		
	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBecado() {
		return becado;
	}

	public void setBecado(String becado) {
		this.becado = becado;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getDni() {
			return dni;
	}
		
	public void setDni(String dni) {
		this.dni= dni;
	}
		
	public Alumno() {
			super();
	}
}
