package club.pantalla;

import java.util.Set;
import java.util.Iterator;

import club.model.Jugador;
import club.model.Authorities;
import club.model.User;

public class Linea_jugador {
		
	private int idjugador;
	
	public int getIdjugador() {
		return idjugador;
	}

	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}

	private String username;
	
	private String numsocio;
	
	private String nombre;
	
	private String tipo;

	// Carga la linea de pantalla a partir de la vista de base de datos
	public void setFromBD(Jugador jugador) {
		this.idjugador = jugador.getIdjugador();
		this.username = jugador.getUser().getUsername();
		
		// Mostrar raya si no tiene número de socio
		if (jugador.getNumsocio()==0) {
			this.numsocio = "-";
		}
		else {
			this.numsocio = Integer.toString(jugador.getNumsocio());
		}
		this.nombre = jugador.getNombre();
		
		User user1 = jugador.getUser();		
		Set authorities = user1.getAuthorities();
		
		// Cargar el tipo de usuario
		authorities = jugador.getUser().getAuthorities();
		Iterator iterator = authorities.iterator();
		Authorities authority = (Authorities) iterator.next();
		this.tipo = authority.getAuthority().substring(5);	
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNumsocio() {
		return numsocio;
	}

	public void setNumsocio(String numsocio) {
		this.numsocio = numsocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Linea_jugador [idjugador="+idjugador+",username=" + username + ", numsocio=" + numsocio + ", nombre="
				+ nombre + ", tipo=" + tipo + "]";
	}
	
}
