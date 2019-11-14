package web_contactos3.entity;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="contactos")
public class Contacto{
	@Id
	@Column(name="idcontacto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcontacto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefono")
	private int telefono;
	
	public Contacto() {
		super();
	}
	
	public void iniciaContacto(String nombre, String email, int telefono) {
		this.nombre= nombre;
		this.email= email;
		this.telefono= telefono;
	}
	
	public int getIdcontacto() {
		return idcontacto;
	}
	
	public void setIdcontacto(int idcontacto) {
		this.idcontacto= idcontacto;
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
		this.email= email;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		
		return"Contacto= [idcontacto="+ idcontacto+ 
						", nombre="+ nombre + 
						", email="+ email+ ", " + 
						", telefono="+ telefono+ ", " + "]";
	}
}
