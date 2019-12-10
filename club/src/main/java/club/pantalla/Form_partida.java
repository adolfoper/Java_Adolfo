package club.pantalla;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import club.model.Partida;
import club.model.Jugador;
import club.validation.ValidarFecha;
import club.validation.ValidarHora;

public class Form_partida {
			
	private int idpartida;
	
	private String creador;
	
	@NotEmpty(message = "Campo obligatorio")
	@Size(max = 50,message = "La longitud máxima debe ser 50")
	private String juego;
	
	@Size(max = 100,message = "La longitud máxima debe ser 100")
	private String comentarios;

	@Digits(integer=2,fraction=0,message = "Debe ser numérico de hasta 2 dígitos")
	private String plazasmax;
	
	@Digits(integer=2,fraction=0,message = "Debe ser numérico de hasta 2 dígitos")
	private String plazasmin;

	@ValidarFecha
	private String fechapartida;

	@ValidarHora
	private String horainicio;
	
	@NotNull
	@ValidarHora
	private String horafin;
	
	private String mensaje_horas;
	
	private String mensaje_plazas;
	
	public Form_partida() {
		super();
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("** Creando form_partida");
		System.out.println(date.format(formatter));
		this.fechapartida = date.format(formatter);
		this.horainicio="00:00";
		this.horafin="00:00";
	}
	
	public boolean validar() {
			
		boolean valido = true;
		
		this.mensaje_horas = "";
		this.mensaje_plazas = "";
		
        System.out.println("** Validando intervalo de horas");
        Time time = Time.valueOf(this.horainicio+":00");
        if (time.compareTo(Time.valueOf(this.horafin+":00"))>=0){
        	this.mensaje_horas = "Intervalo de horas no válido. ";
			valido = false;
        }
		
        if (Integer.valueOf(this.plazasmin) > Integer.valueOf(this.plazasmax)) {
        	this.mensaje_plazas = "Intervalo de plazas no válido. ";
			valido = false;
        }
        
        return valido;
	}
	
	// Convertir valores a formato BD
	public Partida getToBD(Jugador jugador) {
		
		Partida partida = new Partida();
        System.out.println("** getToBD");
          	partida.setIdpartida(this.idpartida);
        	partida.setJugador(jugador);
			partida.setJuego(this.juego);
		  	partida.setComentarios(this.comentarios);
		  	partida.setPlazasmin(Integer.valueOf(this.plazasmin));
			partida.setPlazasmax(Integer.valueOf(this.plazasmax));
		
		String fecha = this.fechapartida.substring(6, 10) +
						this.fechapartida.substring(2, 6) +
						this.fechapartida.substring(0, 2);
		//fecha.replace('/', '-');
		
		//partida.setFechapartida(Date.valueOf(fecha));
		try {
			java.util.Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			partida.setFechapartida (new java.sql.Date(date1.getTime()));
		}
		catch (ParseException ex) {
            // Excepción ya contemplada en la validación de fecha
        }
		
		partida.setHorainicio(Time.valueOf(this.horainicio+":00"));
		partida.setHorafin(Time.valueOf(this.horafin+":00"));
		return partida;
	}
	
	// Obtener valores de BD
	public void setFromBD(Partida partida) {
		
        System.out.println("** setFromBD");
		
		this.idpartida = partida.getIdpartida();	
		this.creador = partida.getJugador().getNombre();	
		this.juego = partida.getJuego();
		this.comentarios = partida.getComentarios();		
		this.plazasmin = Integer.toString(partida.getPlazasmin()); 		
		this.plazasmax = Integer.toString(partida.getPlazasmax());
		DateFormat fecha = new SimpleDateFormat("dd/MM/YYYY");
		this.fechapartida = fecha.format(partida.getFechapartida());

		DateFormat hora = new SimpleDateFormat("HH:mm");
		this.horainicio = hora.format(partida.getHorainicio());		
		this.horafin = hora.format(partida.getHorafin());
		this.mensaje_horas = "";
		this.mensaje_plazas = "";
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
	public String getMensaje_horas() {
		return mensaje_horas;
	}
	public void setMensaje_horas(String mensaje) {
		this.mensaje_horas = mensaje;
	}
	
	public String getMensaje_plazas() {
		return mensaje_plazas;
	}
	public void setMensaje_plazas(String mensaje) {
		this.mensaje_plazas = mensaje;
	}
	
}
