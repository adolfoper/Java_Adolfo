package club.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import club.model.Partida;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jugadores")
public class Jugador {

	@Id
	@Column(name = "idjugador")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idjugador;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
	private User user;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion1")
	private String direccion1;

	@Column(name = "direccion2")
	private String direccion2;
	
	@Column(name = "telefono")
	private long telefono;
	
	@Column(name = "numsocio")
	private int numsocio;
	
	//@Type(type = "date")
	@Column(name = "fechaalta")
	private Date fechaalta;
	
	private Set<Apuntado> apuntados = new HashSet<Apuntado>(0);
	
	// Relacion como creador de partidas
	@OneToMany(fetch = FetchType.EAGER,mappedBy="jugador",
			cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Partida> partidas;
	
	public void addPartida(Partida partida) {
		if (partidas==null) {
			partidas=new ArrayList<Partida>();
		}
		partidas.add(partida);
		partida.setJugador(this);
	}
	
	public List<Partida> getPartidas() {
		return partidas;
	}
	
	//@OneToMany(fetch = FetchType.EAGER,mappedBy="jugador",
	//		cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	////private List<Apuntado> apuntados;
	//private Set<Apuntado> apuntados = new HashSet<>();
	
	//public void addApuntado(Apuntado apuntado) {
	//	if (apuntados==null) {
	//		apuntados=new HashSet<Apuntado>();
//			apuntados=new ArrayList<Apuntado>();
	//	}
	//	apuntados.add(apuntado);
	//	apuntado.setJugador(this);
	//}
	
	//public List<Apuntado> getApuntados() {
	//	return apuntados;
	//}
	
	//public Set<Apuntado> getApuntados() {
	//	return apuntados;
	//}
	
	public void addApuntado(Apuntado apuntado) {
		if (apuntados==null) {
			apuntados=new HashSet<Apuntado>();
		}
		apuntados.add(apuntado);
		apuntado.setJugador(this);
	}
	
	public Set<Apuntado> getApuntados() {
		return apuntados;
	}
	
	public Jugador() {

	}


	public Jugador(String nombre, String direccion1, String direccion2, 
				   long telefono, int numsocio, Date fechaalta) {
		super();
		this.nombre = nombre;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.telefono = telefono;
		this.numsocio = numsocio;
		this.fechaalta = fechaalta;
	}

	@Override
	public String toString() {
		return "Jugador [idjugador=" + idjugador + ", nombre=" + nombre + 
				", direccion1=" + direccion1 + ", direccion2=" + direccion2 +
				", telefono=" + telefono + ", numsocio=" + numsocio + 
				", fechaalta=" + fechaalta + "]";
	}


	public int getIdjugador() {
		return idjugador;
	}


	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}


	public User getUser() {
		return user;
	}


	public void setUsername(User user) {
		this.user = user;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion1() {
		return direccion1;
	}


	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}


	public String getDireccion2() {
		return direccion2;
	}


	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public int getNumsocio() {
		return numsocio;
	}


	public void setNumsocio(int numsocio) {
		this.numsocio = numsocio;
	}


	public Date getFechaalta() {
		return fechaalta;
	}


	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}



}
