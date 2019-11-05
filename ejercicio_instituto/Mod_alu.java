package ejercicio_instituto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="mod_alu")
public class Mod_alu {
	@Id
	@Column(name="idmod_alu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmod_alu;
	
	@Column(name="idmodulo")
	private int idmodulo;
	
	@Column(name="idalumno")
	private int idalumno;
	
	public Mod_alu() {
		
	}
	
	public Mod_alu(int idmodulo, int idalumno) {
		super();
		this.idmodulo= idmodulo;
		this.idalumno= idalumno;
	}
	
	public int getIdmodulo() {
		return idmodulo;
	}
	
	public void setIdmodulo(int idmodulo) {
		this.idmodulo= idmodulo;
	}
	
	public int getIdalumno() {
		return idalumno;
	}
	
	public void setidalumno(int idalumno) {
		this.idalumno= idalumno;
	}
	
	public int getIdmod_alu() {
		return idmod_alu;
	}
	
	public void setIdmod_alu(int idmod_alu) {
		this.idmod_alu= idmod_alu;
	}
	
	@Override
	public String toString() {
		return"mod_alu [idmod_alu=" + idmod_alu +
					   "idmodulo="+ idmodulo + 
					 ", idalumno=" + idalumno + "]";
	}
}
