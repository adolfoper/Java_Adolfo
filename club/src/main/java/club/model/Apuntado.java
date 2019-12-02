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
import javax.persistence.Table;
import java.io.Serializable;
//import org.hibernate.annotations.Type;

import club.model.Jugador;

@Entity
@Table(name = "apuntados")
public class Apuntado implements Serializable {

	@Id
	@Column(name = "idapuntado")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idapuntado;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	fetch=FetchType.LAZY)
	@JoinColumn(name="idpartida")
	private Partida partida;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	fetch=FetchType.LAZY)
	@JoinColumn(name="idjugador")
	private Jugador jugador;
	
	@Column(name = "comentarios")
	private String comentarios;

	public Apuntado(Partida partida, Jugador jugador, String comentarios) {
		super();
		this.partida = partida;
		this.jugador = jugador;
		this.comentarios = comentarios;
	}


	public Apuntado(String comentarios) {
		super();
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Apuntado [idapuntado=" + idapuntado + ", partida=" + partida + 
				", jugadores=" + jugador + "]";
	}


	public int getIdapuntado() {
		return idapuntado;
	}


	public void setIdapuntado(int idapuntado) {
		this.idapuntado = idapuntado;
	}


	public Partida getPartida() {
		return partida;
	}


	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


}
