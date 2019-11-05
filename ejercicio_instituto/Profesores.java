package ejercicio_instituto;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="profesores")
public class Profesores {
	@Id
	@Column(name="idprofesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idprofesor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	@Column(name="dni")
	private String dni;
	
	// Relación 1 a N de profesor a modulos
	@OneToMany(mappedBy="profesor",
			   cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	
	private List<Modulos> modulos;
	
	public List<Modulos> getModulos() {
		return modulos;
	}
	
	public void setModulos(List<Modulos> modulos) {
		this.modulos= modulos;
	}
	
	public void addModulos(Modulos modulo) {
		if(modulos==null) {
			modulos=new ArrayList<Modulos>();
		}
		modulos.add(modulo);
		modulo.setProfesor(this);
	}
	
	public Profesores() {
		
	}
	
	public Profesores(String nombre, String dni, String email) {
		super();
		this.nombre= nombre;
		this.email= email;
		this.dni= dni;
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
	
	public int getIdprofesor() {
		return idprofesor;
	}
	
	public void setIdprofesor(int idprofesor) {
		this.idprofesor= idprofesor;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni= dni;
	}
	
	@Override
	public String toString() {
		String cadenaModulos="Modulos= ";
		boolean primera = true;
		for(Modulos m:modulos) {
			if (primera) {
				cadenaModulos+=m.getNombre();
				primera = false;
			}
			else {
				cadenaModulos+=", "+ m.getNombre();
			}
		}
		
		return"Profesor= [idprofesor="+ idprofesor+ 
						", nombre="+ nombre + 
						", dni="+ dni+ 
						", email="+ email+ ", " + 
						cadenaModulos + "]";
	}
}
