package club.pantalla;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import club.model.User;
import club.validation.ValidarFecha;
import club.model.Jugador;
import club.model.Partida;
import club.model.Authorities;

import java.util.Map;
import java.util.LinkedHashMap;

public class Form_jugador {
	
	private int idjugador;
			
	@NotEmpty(message = "Campo obligatorio")
	@Size(max = 50,message = "La longitud máxima debe ser 50")
	private String username;

	private String tipo;
	
	@NotEmpty(message = "Campo obligatorio")
	@Size(max = 50,message = "La longitud máxima debe ser 50")
	private String nombre;
		
	@Size(max = 50,message = "La longitud máxima debe ser 50")
	private String direccion1;

	@Size(max = 50,message = "La longitud máxima debe ser 50")
	private String direccion2;
		
	@Digits(integer=9,fraction=0,message = "Debe ser numérico de hasta 9 dígitos")
	private String telefono;
		
	@Digits(integer=6,fraction=0,message = "Debe ser numérico de hasta 9 dígitos")
	private String numsocio;
	
	@ValidarFecha
	private String fechaalta;
	
	private Map<String,String> listaTipos;
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Form_jugador() {
		super();
		 System.out.println("** Creando form_partida");
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(date.format(formatter));
		this.fechaalta = date.format(formatter);
		this.mensaje="";
		
		listaTipos=new LinkedHashMap<String,String>();
		listaTipos.put("ADMINISTRADOR","ROLE_ADMINISTRADOR");
		listaTipos.put("SOCIO","ROLE_SOCIO");
		listaTipos.put("COLABORADOR","ROLE_COLABORADOR");
	}
	
	public int getIdjugador() {
		return idjugador;
	}

	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}

	public void setListaTipos(Map<String, String> listaTipos) {
		this.listaTipos = listaTipos;
	}

	public User getToBD_User(boolean reset_pass, boolean enabled) {
		
        System.out.println("** getToBD_User");
		User user = new User();
        //user.setUsername(this.username);
        
        //if (reset_pass = true){
        //	 user.setPassword("$2y$12$f0OvHgs0uSfwonMJsX0Geum7MNr1ouzMXAfttN7C5xzPoqh/kIhpK");
        //}

        //user.setEnabled(enabled);
        return user;
	}
	
	public Authorities getToBD_Authorities(User user) {
		Authorities authorities = new Authorities();
        System.out.println("** getToBD_Authorities");
        authorities.setUser(user);
        authorities.setAuthority(this.tipo);
        return authorities;
	}
        
	public Jugador getToBD_Jugador(User user) {
		Jugador jugador = new Jugador();
        System.out.println("** getToBD_jugador");
        
        jugador.setIdjugador(this.idjugador);
        jugador.setUser(user);
        jugador.setNombre(this.nombre);
        jugador.setDireccion1(this.direccion1);
        jugador.setDireccion2(this.direccion2);
        jugador.setTelefono(Integer.valueOf(this.telefono));
        jugador.setNumsocio(Integer.valueOf(this.numsocio));
        
        String fecha = this.fechaalta.substring(6, 10) +
				this.fechaalta.substring(2, 6) +
				this.fechaalta.substring(0, 2);

        try {
        	java.util.Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        	jugador.setFechaalta (new java.sql.Date(date1.getTime()));
        }
        catch (ParseException ex) {
        	// Excepción ya contemplada en la validación de fecha
        }
        
        return jugador;
	}
	
	public void setFromBD(Jugador jugador) {
		System.out.println("** setFromBD");
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
		/*
		this.username = user.getUsername();	
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
		*/
	}
	
	public Map<String, String> getListaTipos() {
		return listaTipos;
		}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNumsocio() {
		return numsocio;
	}

	public void setNumsocio(String numsocio) {
		this.numsocio = numsocio;
	}

	public String getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}

	@Override
	public String toString() {
		return "Form_jugador [idjugador=" + idjugador + ",username=" + username + ", tipo=" + tipo + ", nombre="
				+ nombre + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + ", telefono=" + telefono
				+ ", numsocio=" + numsocio + ", fechaalta=" + fechaalta + "]";
	}

}
