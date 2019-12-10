package club.pantalla;

import club.model.Apuntado;
import club.model.Partida;
import club.model.Jugador;

public class Form_apuntados {
			
	private int idapuntado;
	
	private int idpartida;
	
	private int idjugador;
	
	private String comentarios;
	
	private String mensaje;

	public Form_apuntados(int idpartida, int idjugador) {
		super();
		this.idapuntado = 0;
		this.idjugador = idjugador;
		this.idpartida = idpartida;
		this.comentarios = "";
	}
	
	public Apuntado setToBD(Jugador jugador, Partida partida) {
		Apuntado apuntado = new Apuntado();
		apuntado.setIdapuntado(this.idapuntado); 
		apuntado.setJugador(jugador); 
		apuntado.setPartida(partida); 
		apuntado.setComentarios(this.comentarios);
		return apuntado;
	}
	
	public int getIdapuntado() {
		return idapuntado;
	}

	public void setIdapuntado(int idapuntado) {
		this.idapuntado = idapuntado;
	}

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}
	
	public int getIdjugador() {
		return idjugador;
	}

	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Form_apuntados [idapuntado=" + idapuntado + ", idpartida=" + idpartida + ", idjugador=" + idjugador
				+ ", comentarios=" + comentarios + ", mensaje=" + mensaje + "]";
	}
	
}
