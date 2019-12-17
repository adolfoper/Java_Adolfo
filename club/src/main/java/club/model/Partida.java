package club.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import club.model.Jugador;

import java.sql.Date;
import java.sql.Time;
//import java.util.HashSet;
//import java.util.Set;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partidas")
public class Partida {

	@Id
	@Column(name = "idpartida")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpartida;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	fetch=FetchType.EAGER)
	@JoinColumn(name="idjugador")
	private Jugador jugador;
	
	@Column(name = "juego")
	private String juego;
	
	@Column(name = "comentarios")
	private String comentarios;

	@Column(name = "plazasmin")
	private int plazasmin;
	
	@Column(name = "plazasmax")
	private int plazasmax;
	
	@Column(name = "fechapartida")
	private Date fechapartida;
	
	@Column(name = "horainicio")
	private Time horainicio;
	
	@Column(name = "horafin")
	private Time horafin;

	public Partida() {

	}

	public Partida(String juego, String comentarios, int plazasmin, int plazasmax,
				   Date fechapartida, Time horainicio, Time horafin) {
		super();
		this.juego = juego;
		this.comentarios = comentarios;
		this.plazasmin = plazasmin;
		this.plazasmax = plazasmax;
		this.fechapartida = fechapartida;
		this.horainicio = horainicio;
		this.horafin = horafin;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="partida",
			cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Apuntado> apuntados;
	
	public void addApuntado(Apuntado apuntado) {
		if (apuntados==null) {
			apuntados=new ArrayList<Apuntado>();
		}
		apuntados.add(apuntado);
		apuntado.setPartida(this);
	}
	
	@Override
	public String toString() {
		return "Jugador [idpartida=" + idpartida + ", juego=" + juego + 
				", comentarios=" + comentarios + ", plazasmin=" + plazasmin +
				", plazasmax=" + plazasmax + ", fechapartida=" + fechapartida + 
				", horainicio=" + horainicio + ", horafin=" + horafin + "]";
	}


	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getPlazasmin() {
		return plazasmin;
	}

	public void setPlazasmin(int plazasmin) {
		this.plazasmin = plazasmin;
	}

	public int getPlazasmax() {
		return plazasmax;
	}

	public void setPlazasmax(int plazasmax) {
		this.plazasmax = plazasmax;
	}

	public Date getFechapartida() {
		return fechapartida;
	}

	public void setFechapartida(Date fechapartida) {
		this.fechapartida = fechapartida;
	}

	public Time getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public Time getHorafin() {
		return horafin;
	}

	public void setHorafin(Time horafin) {
		this.horafin = horafin;
	}

	public List<Apuntado> getApuntados() {
		return apuntados;
	}


	public void setApuntados(List<Apuntado> apuntados) {
		this.apuntados = apuntados;
	}

}
