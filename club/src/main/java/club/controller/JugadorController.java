package club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import club.model.Jugador;
import club.services.IJugadorService;

import club.model.Apuntado;
import club.services.IApuntadoService;

import club.services.IUserService;
import club.model.User;

import club.services.IAuthoritiesService;
import club.model.Authorities;

import club.pantalla.Linea_jugador;
import club.pantalla.Form_jugador;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAuthoritiesService authoritiesService;
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IApuntadoService apuntadoService;
	
	// 
	// Carga del listado de jugadores
	//
	@GetMapping("/index_jugadores")
 	public String index(HttpServletRequest request, Model modelo)  {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /index_usuarios");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
		
		List<Jugador> jugadores = jugadorService.getJugadores();
		List<Linea_jugador> lineas = new ArrayList<Linea_jugador>();

		for (Jugador jugador:jugadores) {
			Linea_jugador linea= new Linea_jugador();
			linea.setFromBD(jugador);
			lineas.add(linea);
		}
		modelo.addAttribute("lineas", lineas);
		
		System.out.println("--> jugadores");
		return"jugadores";
	}
	
	// 
	// Carga la pantalla de alta de jugador
	//
	@GetMapping("/addjugador")
 	public String addjugador(Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /addjugador");

		Form_jugador form_jugador = new Form_jugador();
		modelo.addAttribute("form_jugador", form_jugador);
		
        System.out.println("--> alta_jugador");
		return"alta_jugador";
	}
	
	// 
	// Carga la pantalla de modificación de jugador
	//
	@GetMapping("/updatejugador")
 	public String updatejugador(@RequestParam("idjugador") int idjugador, Model modelo) {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /updatejugador");

		Form_jugador form_jugador = new Form_jugador();
		Jugador jugador = jugadorService.getJugador(idjugador);
		
		form_jugador.setFromBD(jugador);
		
		modelo.addAttribute("form_jugador", form_jugador);
		
        System.out.println("--> modif_jugador");
		return"modif_jugador";
	}
	
	// 
	// Baja de jugador (más los rows asociados de apuntados, user y cathegories)
	//
	@GetMapping("/deletejugador")
	public String deletepartida(@RequestParam("idjugador") int idjugador, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /deletejugador");

		Jugador jugador = jugadorService.getJugador(idjugador);
		
		// delete apuntados
		List<Apuntado> apuntados = new ArrayList<Apuntado>(jugador.getApuntados());

		for(Apuntado apuntado:apuntados){
	        apuntadoService.delete(apuntado);
	     }
		
		User user = jugador.getUser();
		
		// delete authorities
		Set authorities = user.getAuthorities();		
		Iterator iterator = authorities.iterator();
		Authorities authority = (Authorities) iterator.next();
		
		authoritiesService.delete(authority);
		
		// delete jugador y user
		jugadorService.delete(jugador);	
		userService.delete(user);
		
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	
	// 
	// Trata el retorno de la pantalla de alta de jugador
	//
	@PostMapping("/procesar_alta_jugador")
	public String procesar_alta_jugador(HttpServletRequest request, 
										@Valid @ModelAttribute("form_jugador") Form_jugador form_jugador, 
										BindingResult bindingResult) { 	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /procesar_alta_jugador");
		
		if (bindingResult.hasErrors()) { 
			return "alta_jugador"; 
		} 
		
		if (form_jugador.valida()==false) { 
			return "alta_jugador"; 
		}
		
		// verifica que el código de usuario no exista
		User userGet = userService.getUser(form_jugador.getUsername());
		
		if (userGet != null) {
			form_jugador.setMensaje("Código de usuario existente");
			return "alta_jugador";
		}
		
		// Actualiza user
		User user = form_jugador.getToBD_User(true,true);
		userService.save(user);
		
		// Actualiza authorities
		userGet = userService.getUser(form_jugador.getUsername());
		Authorities authority = form_jugador.getToBD_Authorities(userGet);
		authoritiesService.save(authority);
		
		// Actualiza jugador
	    Jugador jugador = form_jugador.getToBD_Jugador(user);		
		jugadorService.save(jugador);
			
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	
	// 
	// Trata el retorno de la pantalla de modificación de jugador
	//
	@PostMapping("/procesar_modif_jugador")
	public String procesar_modif_jugador(HttpServletRequest request, 
										@Valid @ModelAttribute("form_jugador") Form_jugador form_jugador, 
										BindingResult bindingResult) { 	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /procesar_modif_jugador");
		
		if (bindingResult.hasErrors()) { 
			return "modif_jugador"; 
		} 
		
		if (form_jugador.valida()==false) { 
			return "modif_jugador"; 
		}
		
		User user = userService.getUser(form_jugador.getUsername());
		
		// Recupera jugador, user y authorities
		Set authorities = user.getAuthorities();
		Iterator iterator = authorities.iterator();
		Authorities authority = (Authorities) iterator.next();
		
		Jugador jugador = form_jugador.getToBD_Jugador(user);	
		
		// Se actualiza authorities solo si se ha cambiado el tipo de usuario
		String tipo_old = authority.getAuthority().substring(5);
		String tipo_new = form_jugador.getTipo();
		
		if (tipo_old != tipo_new) {
			Authorities authority2 = new Authorities();
			authority2 = authority;
			authoritiesService.delete(authority);
			authority2.setAuthority(tipo_new);
			authoritiesService.save(authority2);
		}
			
		// Se actualiza jugador
		jugadorService.save(jugador);
			
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	
	// Vuelta a la pantalla de listado de partidas
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	// Vuelta a la pantalla de listado de jugadores
	@GetMapping("/cancel2")
	public String cancel2 (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /cancel2");
        System.out.println("--> index2");
        return "redirect:/jugador/index_jugadores";
	}

}
