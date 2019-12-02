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
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import org.hibernate.annotations.Type;

import club.model.Jugador;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "partidas")
public class Partida {

	@Id
	@Column(name = "idpartida")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpartida;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	fetch=FetchType.LAZY)
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
	
	//@Type(type = "date")
	@Column(name = "fechapartida")
	private Date fechapartida;
	
	//@Type(type = "time")
	@Column(name = "horainicio")
	private Time horainicio;
	
	//@Type(type = "time")
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

	
	//@OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    //private Set<BookPublisher> bookPublishers;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="partida",
			cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Partida> apuntados;
	
	
	//@OneToMany(fetch = FetchType.EAGER,mappedBy="cpartida",
	//		cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	//private List<Jugador> products;
	
	@Override
	public String toString() {
		return "Jugador [idjpartida=" + idpartida + ", juego=" + juego + 
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

}
