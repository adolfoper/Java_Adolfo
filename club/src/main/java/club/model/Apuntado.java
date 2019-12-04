package club.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.AssociationOverrides;
import javax.persistence.AssociationOverride;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;
//import java.io.Serializable;
//import org.hibernate.annotations.Type;

import club.model.Jugador;

@Entity
@Table(name = "apuntados")
@AssociationOverrides({
	@AssociationOverride(name = "pk.jugador", 
		joinColumns = @JoinColumn(name = "idjugador")),
	@AssociationOverride(name = "pk.partida", 
		joinColumns = @JoinColumn(name = "idpartida")) })
public class Apuntado {

	@Id
	@Column(name = "idapuntado")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idapuntado;
	
	//@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	//fetch=FetchType.LAZY)
	//@JoinColumn(name="idpartida")
	//private Partida partida;
	
	//@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
	//fetch=FetchType.LAZY)
	//@JoinColumn(name="idjugador")
	//private Jugador jugador;
	
	private ApuntadoId pk = new ApuntadoId();
	
	@EmbeddedId
	public ApuntadoId getPk() {
		return pk;
	}

	public void setPk(ApuntadoId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Partida getPartida() {
		return getPk().getPartida();
	}

	public void setPartida(Partida partida) {
		getPk().setPartida(partida);
	}

	@Transient
	public Jugador getJugador() {
		return getPk().getJugador();
	}

	public void setJugador(Jugador jugador) {
		getPk().setJugador(jugador);
	}
	
	@Column(name = "comentarios")
	private String comentarios;

	public Apuntado(Partida partida, Jugador jugador, String comentarios) {
		super();
		//this.partida = partida;
		//this.jugador = jugador;
		setPartida(partida);
		setJugador(jugador);
		this.comentarios = comentarios;
	}


	public Apuntado(String comentarios) {
		super();
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Apuntado [idapuntado=" + idapuntado + ", partida=" + getPartida() + 
				", jugadores=" + getJugador() + "]";
	}


	public int getIdapuntado() {
		return idapuntado;
	}


	public void setIdapuntado(int idapuntado) {
		this.idapuntado = idapuntado;
	}


	//public Partida getPartida() {
	//	return partida;
	//}


	//public void setPartida(Partida partida) {
	//	this.partida = partida;
	//}


	//public Jugador getJugador() {
	//	return jugador;
	//}


	//public void setJugador(Jugador jugador) {
	//	this.jugador = jugador;
	//}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


}
