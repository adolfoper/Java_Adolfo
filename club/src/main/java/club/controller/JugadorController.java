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
//import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import club.model.Jugador;
import club.model.Partida;
import club.services.IJugadorService;

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
	
	@GetMapping("/index_jugadores")
 	public String index(HttpServletRequest request, Model modelo)  {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /index_usuarios");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
		
		List<Jugador> jugadores = jugadorService.getJugadores();
		System.out.println("** cargada lista jugadores:"+jugadores);
		List<Linea_jugador> lineas = new ArrayList<Linea_jugador>();

		for (Jugador jugador:jugadores) {
			Linea_jugador linea= new Linea_jugador();
			System.out.println("** tratando jugador:"+jugador);
			linea.setFromBD(jugador);
			lineas.add(linea);
		}
		System.out.println("** cargada lista lineas:"+lineas);
		modelo.addAttribute("lineas", lineas);
		
		return"jugadores";
	}
	
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
	
	@PostMapping("/procesar_alta_jugador")
	public String procesar_alta_jugador(HttpServletRequest request, 
										@Valid @ModelAttribute("form_jugador") Form_jugador form_jugador, 
										BindingResult bindingResult) { 
		
		System.out.println("=>> JugadorController /procesar_alta_jugador");
		
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "alta_jugador"; 
		} 

		System.out.println("Sin errores");
		
		boolean existe = true;
		
		//try {
		//	User userGet = userService.getUser(form_jugador.getUsername());
	    //}
	    //catch (Exception ex) {
	    //   existe = false;
	    //}
		
		if (existe) {
			form_jugador.setMensaje("Código de usuario existente");
			return "alta_jugador";
		}
		
		//User user = form_jugador.getToBD_User(true,true);
		//Authorities authority = form_jugador.getToBD_Authorities(user);
	    //Jugador jugador = form_jugador.getToBD_Jugador(user);
	    
		//userService.save(user);
		//System.out.println("** Grabado user");
		
		//authoritiesService.save(authority);
		//System.out.println("** Grabado authorities");
		
		//authoritiesService.save(authority);
		//System.out.println("** Grabado jugador");
			
	     System.out.println("--> index2");
	     return "redirect:/index2";
	}
	
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}

}
