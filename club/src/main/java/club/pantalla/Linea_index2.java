package club.pantalla;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

import club.model.Partida;

public class Linea_index2 {
			
	private int idpartida;
	
	private String creador;
	
	private String juego;
	
	private String comentarios;

	private String plazas;

	private String fechapartida;

	private String horainicio;
	
	private String horafin;
	
	private int numApuntados;
	
	//
	// Recibir valores en formato BD
	//
	public void setFromBD(Partida partida) {
        
		this.idpartida = partida.getIdpartida();	
		this.creador = partida.getJugador().getNombre();	
		this.juego = partida.getJuego();		
		this.comentarios = partida.getComentarios();
		this.plazas = Integer.toString(partida.getPlazasmin())+ "-" + 		
					  Integer.toString(partida.getPlazasmax());

		// Conversión de fecha
		DateFormat fecha = new SimpleDateFormat("dd/MM/YYYY");
		this.fechapartida = fecha.format(partida.getFechapartida());

		// Conversión de hora
		DateFormat hora = new SimpleDateFormat("HH:mm");
		this.horainicio = hora.format(partida.getHorainicio());		
		this.horafin = hora.format(partida.getHorafin());
		
		// Carga el número de apuntados a la partida
		this.numApuntados = partida.getApuntados().size();
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

	public String getPlazas() {
		return plazas;
	}

	public void setPlazas(String plazas) {
		this.plazas = plazas;
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

	public int getNumApuntados() {
		return numApuntados;
	}

	public void setNumApuntados(int numApuntados) {
		this.numApuntados = numApuntados;
	}
	
}
