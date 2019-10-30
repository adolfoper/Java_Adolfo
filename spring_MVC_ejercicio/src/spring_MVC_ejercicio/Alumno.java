package spring_MVC_ejercicio;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Map;
import java.util.LinkedHashMap;

public class Alumno {
	
	private Map<String,String> listaAsignaturas;
	private Map<String,String> listaSN;
	
	@NotNull
	@Size(min = 3,message = "La longitud mínima debe ser 3")
	private String nombre;
	
	@Pattern(regexp = "[0-9]{8}[A-Z]|",message="NIF incorrecto")
	private String dni;
	
	@Email
	private String email;
	
	private String becado;
	
	private String asignatura;
		
	public Map<String, String> getListaAsignaturas() {
		return listaAsignaturas;
	}
	
	public Map<String, String> getListaSN() {
		return listaSN;
	}
	
	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni= dni;
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
		
	public Alumno() {
		super();
		listaAsignaturas=new LinkedHashMap<String,String>();
		listaAsignaturas.put("PHP","PHP");
		listaAsignaturas.put("JAVA","JAVA");	
		listaAsignaturas.put("JS","JS");
		listaAsignaturas.put(".NET",".NET");
		
		listaSN=new LinkedHashMap<String,String>();
		listaSN.put("S","Sí");
		listaSN.put("N","No");	

	}
}
