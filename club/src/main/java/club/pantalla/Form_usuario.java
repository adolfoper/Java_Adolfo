package club.pantalla;

import java.sql.Date;

import javax.persistence.Column;

import club.model.Apuntado;
import club.model.Partida;
import club.model.Jugador;

public class Form_usuario {
			
	private String username;

	private String password;

	private String categoria;
	
	private String nombre;
		
	private String direccion1;

	private String direccion2;
		
	private long telefono;
		
	private int numsocio;
		
	private Date fechaalta;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	@Override
	public String toString() {
		return "Form_jugador [username=" + username + ", password=" + password + ", categoria=" + categoria + ", nombre="
				+ nombre + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + ", telefono=" + telefono
				+ ", numsocio=" + numsocio + ", fechaalta=" + fechaalta + "]";
	}

}
