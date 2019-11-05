package ejercicio_instituto;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="modulos")
public class Modulos {
	@Id
	@Column(name="idmodulo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmodulo;
	
	@Column(name="nombre")
	private String nombre;
	
	// Relación 1 a N con profesores
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="idprofesor")
	private Profesores profesor;
	public Profesores getProfesor() {
		return profesor;
	}
	
	public void setProfesor(Profesores profesor) {
		this.profesor= profesor;
	}
	
	public Modulos() {
		
	}
	
	public Modulos(String nombre) {
		super();
		this.nombre= nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}
	
	public int getIdmodulo() {
		return idmodulo;
	}
	
	public void setIdmodulo(int idmodulo) {
		this.idmodulo= idmodulo;
	}
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH },
		fetch = FetchType.LAZY)
		@JoinTable(name = "mod_alu",
		joinColumns = @JoinColumn(name="idmodulo"),
		inverseJoinColumns = @JoinColumn(name="idalumno"))
		
		private List<Alumnos> alumnos;
		public List<Alumnos> getAlumnos() {
			return alumnos;
		}
			
		public void setAlumnos(List<Alumnos> alumnos) {
			this.alumnos = alumnos;
		}
		
		public void addAlumno(Alumnos alumno) {
		if (alumnos == null) {
			alumnos = new ArrayList<Alumnos>();
			}
				alumnos.add(alumno);
			}	
	
	@Override
	public String toString() {
		
		String cadenaAlumnos="Alumnos=";
		boolean primera = true;
		for(Alumnos a:alumnos) {
			if (primera) {
				cadenaAlumnos+=a.getNombre();
				primera = false;
			}
			else
				cadenaAlumnos+=", " + a.getNombre();
		}
		
		return"Modulo= [idmodulo="+ idmodulo + 
					 ", nombre="+ nombre + 
					 ", " + profesor.toString() + 
					 ", " + cadenaAlumnos + "]"; 
	}
	
}
