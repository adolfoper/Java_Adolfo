package web_contactos3;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import web_contactos3.entity.Contacto;

import javax.validation.constraints.Email;

public class Contacto_web {
		
	// Campos de pantalla
	//@NotNull
	//@Digits(integer=10,fraction=0,message = "Debe ser numérico")
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
	
	@Digits(integer=9,fraction=0,message = "Debe ser numérico de hasta 9 dígitos")
	private String telefono;
	
	private String mensaje;

	public String getIdcontacto() {
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
	
	public String getMensaje() {
		return mensaje;
	}
		
	public void setMensaje(String mensaje) {
		this.mensaje= mensaje;
	}

	// Devolver valores en formato BD
	public Contacto getToBD() {
		Contacto contacto = new Contacto();
		contacto.setNombre(this.nombre);
		contacto.setEmail(this.email);
		contacto.setIdcontacto(Integer.valueOf(this.idcontacto));
		contacto.setTelefono(Integer.valueOf(this.telefono));
		return contacto;
	}
	
	// Recibir valores en formato BD
	public void setFromBD(Contacto contacto) {
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
