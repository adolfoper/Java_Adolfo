package club.pantalla;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import javax.persistence.Column;

import club.model.Partida;
import club.services.IPartidaService;

import club.model.Jugador;
import club.services.IJugadorService;

import club.services.IAuthoritiesService;
import club.model.Authorities;

import club.services.IUserService;
import club.model.User;

public class Linea_jugador {
			
	private String username;
	
	private String numsocio;
	
	private String nombre;
	
	private String tipo;

	public void setFromBD(Jugador jugador) {
			System.out.println("** setfromBD");
		this.username = jugador.getUser().getUsername();
		this.numsocio = Integer.toString(jugador.getNumsocio());
		this.nombre = jugador.getNombre();
		
		User user1 = jugador.getUser();
		//System.out.println("user:"+user1);
			
		Set authorities = user1.getAuthorities();
		System.out.println("authorities:"+authorities);
			
		authorities = jugador.getUser().getAuthorities();
		Iterator iterator = authorities.iterator();
		Authorities authority = (Authorities) iterator.next();
		this.tipo = authority.getAuthority().substring(5);	
		System.out.println("** salir");
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
		return "Linea_usuario [username=" + username + ", numsocio=" + numsocio + ", nombre="
				+ nombre + ", tipo=" + tipo + "]";
	}
	
}
