package web_contactos;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="contactos")
public class Contacto implements iContacto{
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
	
	@Override
	public void iniciaContacto(String nombre, String email, int telefono) {
		this.nombre= nombre;
		this.email= email;
		this.telefono= telefono;
	}
	
	@Override
	public int getIdcontacto() {
		return idcontacto;
	}
	
	@Override
	public void setIdcontacto(int idcontacto) {
		this.idcontacto= idcontacto;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email= email;
	}
	
	@Override
	public int getTelefono() {
		return telefono;
	}
	
	@Override
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
