package club.pantalla;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import club.model.Partida;
import club.model.Jugador;

public class Form_partida {
			
	private int idpartida;
	
	private String creador;
	
	private String juego;
	
	private String comentarios;

	private String plazasmax;
	
	private String plazasmin;

	private String fechapartida;

	private String horainicio;
	
	private String horafin;
	
	public Form_partida() {
		super();
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("** Creando form_partida");
		System.out.println(date.format(formatter));
		this.fechapartida = date.format(formatter);
	}
	// Convertir valores a formato BD
	public Partida getToBD(Jugador jugador) {
		
		Partida partida = new Partida();
        System.out.println("** getToBD");
		
		partida.setJugador(jugador);	
		partida.setJuego(this.juego);		
		partida.setComentarios(this.comentarios);
		partida.setPlazasmin(Integer.valueOf(this.plazasmin));
		partida.setPlazasmax(Integer.valueOf(this.plazasmax));
		partida.setFechapartida(Date.valueOf(this.fechapartida));
		partida.setHorainicio(Time.valueOf(this.horainicio));
		partida.setHorafin(Time.valueOf(this.fechapartida));
		
		return partida;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
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

	public String getFechapartida() {
		return fechapartida;
	}

	public void setFechapartida(String fechapartida) {
		this.fechapartida = fechapartida;
	}

	public String getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}

	public String getHorafin() {
		return horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}

	public String getPlazasmax() {
		return plazasmax;
	}

	public void setPlazasmax(String plazasmax) {
		this.plazasmax = plazasmax;
	}

	public String getPlazasmin() {
		return plazasmin;
	}

	public void setPlazasmin(String plazasmin) {
		this.plazasmin = plazasmin;
	}
	
}
