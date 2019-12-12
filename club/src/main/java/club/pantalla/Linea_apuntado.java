package club.pantalla;

import club.model.Jugador;
import club.model.Apuntado;

public class Linea_apuntado {

	private int idapuntado;

	private String orden;

	private String nombre;
	
	private String comentarios;

	private boolean esUsuario;

	public void setFromBD(Apuntado apuntado, Jugador perfil, int numero) {
		this.idapuntado = apuntado.getIdapuntado();
		this.orden = Integer.toString(numero);
		this.nombre = apuntado.getJugador().getNombre();
		this.comentarios = apuntado.getComentarios();

		if (apuntado.getJugador().getIdjugador() == perfil.getIdjugador())
			this.esUsuario = true;
		else
			this.esUsuario = false;
	}
	
	public void setVacio(Jugador perfil, int numero) {
		this.idapuntado = 0;
		this.orden = Integer.toString(numero);
		this.nombre = perfil.getNombre();
		this.esUsuario = true;
	}

	public int getIdapuntado() {
		return idapuntado;
	}

	public void setIdapuntado(int idapuntado) {
		this.idapuntado = idapuntado;
	}

	public String getOrden() {
		return orden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEsUsuario() {
		return esUsuario;
	}

	public void setEsUsuario(boolean esUsuario) {
		this.esUsuario = esUsuario;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Linea_apuntado [idapuntado=" + idapuntado + ", orden=" + orden + ", nombre=" + nombre + ", comentarios="
				+ comentarios + ", esUsuario=" + esUsuario + "]";
	}

}
