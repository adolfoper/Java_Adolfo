package web_contactos;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.constraints.Email;

public class Contacto_web {
	
	// Cargar beans
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
	Contacto contacto = context.getBean("contacto",Contacto.class);
	
	// Campos de pantalla
	@NotNull
	@Digits(integer=10,fraction=0,message = "Debe ser numérico")
	private String idcontacto;
	
	@NotNull
	@Size(min = 2,message = "La longitud mínima debe ser 2")
	private String nombre;
	
	@NotNull
	@Email
	@Size(min = 6,message = "La longitud mínima debe ser 6")
	private String email;
	
	@NotNull
	//xNotEmpty
	//xSize(min = 9,max=13,message = "La longitud mínima debe entre 9 y 13", groups=First.class)
	//xSize(min = 9,max=13,message = "La longitud mínima debe entre 9 y 13")
	@Digits(integer=13,fraction=0,message = "Debe ser numérico")
	private String telefono;

	public String idcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(String idcontacto) {
		this.idcontacto = idcontacto;
	}
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
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// Devolver valores en formato BD
	public Contacto getToBD() {
		contacto.setNombre(this.nombre);
		contacto.setEmail(this.email);
		contacto.setIdcontacto(Integer.valueOf(this.idcontacto));
		contacto.setIdcontacto(Integer.valueOf(this.telefono));
		return contacto;
	}
	
	// Recibir valores en formato BD
	public void setFromBD(iContacto contacto) {
		this.nombre= contacto.getNombre();
		this.email= contacto.getEmail();
		this.idcontacto = Integer.toString(contacto.getIdcontacto());
		this.telefono = Integer.toString(contacto.getTelefono());;
	}
	
	// Resetear los valores a nulos
	public void reset() {
		this.nombre= null;
		this.email= null;
		this.idcontacto = null;
		this.telefono = null;
	}
	
}
