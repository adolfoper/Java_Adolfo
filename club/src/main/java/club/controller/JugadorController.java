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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import club.model.Jugador;
import club.model.Partida;
import club.services.IJugadorService;

import club.services.IUserService;
import club.model.User;

import club.services.IAuthoritiesService;
import club.model.Apuntado;
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
		
		System.out.println("--> jugadores");
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
	
	@GetMapping("/updatejugador")
 	public String updatejugador(@RequestParam("idjugador") int idjugador, Model modelo) {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /updatejugador");

		Form_jugador form_jugador = new Form_jugador();
		Jugador jugador = jugadorService.getJugador(idjugador);
		
		form_jugador.setFromBD(jugador);
		modelo.addAttribute("** form_jugador", form_jugador);
		System.out.println("** Tipo:"+form_jugador.getTipo());
		System.out.println("** Idjugador:"+form_jugador.getIdjugador());
		
		modelo.addAttribute("form_jugador", form_jugador);
		
        System.out.println("--> modif_jugador");
		return"modif_jugador";
	}
	
	@GetMapping("/deletejugador")
	public String deletepartida(@RequestParam("idjugador") int idjugador, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /deletejugador");

		Jugador jugador = jugadorService.getJugador(idjugador);
		System.out.println("** Cargado jugador:"+jugador);
		
		User user = jugador.getUser();
		System.out.println("** Cargado user:"+user);
		
		Set authorities = user.getAuthorities();
		
		Iterator iterator = authorities.iterator();
		Authorities authority = (Authorities) iterator.next();
		System.out.println("** Cargado authority:"+authority);

		authoritiesService.delete(authority);	
		System.out.println("** Borrado authority");
		
		jugadorService.delete(jugador);
		System.out.println("** Borrado jugador");
		
		userService.delete(user);
		System.out.println("** Borrado user");
		
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	
	@PostMapping("/procesar_alta_jugador")
	public String procesar_alta_jugador(HttpServletRequest request, 
										@Valid @ModelAttribute("form_jugador") Form_jugador form_jugador, 
										BindingResult bindingResult) { 	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /procesar_alta_jugador");
		
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "alta_jugador"; 
		} 
		
		if (form_jugador.valida()==false) { 
			return "alta_jugador"; 
		}

		System.out.println("Sin errores");
		
		//try {
		//	User userGet = userService.getUser(form_jugador.getUsername());
	    //}
	    //catch (Exception ex) {
	    //   existe = false;
	    //}
		
		User userGet = userService.getUser(form_jugador.getUsername());
		
		if (userGet != null) {
			form_jugador.setMensaje("Código de usuario existente");
			return "alta_jugador";
		}
		
		User user = form_jugador.getToBD_User(true,true);
		userService.save(user);
		System.out.println("** Grabado user");
		
		userGet = userService.getUser(form_jugador.getUsername());
		Authorities authority = form_jugador.getToBD_Authorities(userGet);
		authoritiesService.save(authority);
		System.out.println("** Grabado authorities");
		
	    Jugador jugador = form_jugador.getToBD_Jugador(user);		
		jugadorService.save(jugador);
		System.out.println("** Grabado jugador");
			
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	

	@PostMapping("/procesar_modif_jugador")
	public String procesar_modif_jugador(HttpServletRequest request, 
										@Valid @ModelAttribute("form_jugador") Form_jugador form_jugador, 
										BindingResult bindingResult) { 	
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /procesar_modif_jugador");
		
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "modif_jugador"; 
		} 
		
		if (form_jugador.valida()==false) { 
			return "modif_jugador"; 
		}

		System.out.println("Sin errores");
		
		System.out.println("** Username:"+form_jugador.getUsername());
		User user = userService.getUser(form_jugador.getUsername());
		System.out.println("** Compuesto user:"+user);
		
		Set authorities = user.getAuthorities();
		System.out.println("1");
		System.out.println("** Authorities:"+authorities);
		Iterator iterator = authorities.iterator();
		System.out.println("2");
		Authorities authority = (Authorities) iterator.next();
		System.out.println("3");
		System.out.println("** Compuesto authority");
		
		Jugador jugador = form_jugador.getToBD_Jugador(user);	
		System.out.println("** Compuesto jugador");
		
		String tipo_old = authority.getAuthority().substring(5);
		String tipo_new = form_jugador.getTipo();
		
		System.out.println("Rol viejo:"+tipo_old);
		System.out.println("Rol nuevo:"+tipo_new);
		if (tipo_old != tipo_new) {
			Authorities authority2 = new Authorities();
			authority2 = authority;
			authoritiesService.delete(authority);
			authority2.setAuthority(tipo_new);
			authoritiesService.save(authority2);
			System.out.println("** Grabado authorities");
		}
			
		jugadorService.save(jugador);
		System.out.println("** Grabado jugador");
			
	     System.out.println("--> /jugador/index_jugadores");
	     return "redirect:/jugador/index_jugadores";
	}
	
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	@GetMapping("/cancel2")
	public String cancel2 (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /cancel2");
        System.out.println("--> index2");
        return "redirect:/jugador/index_jugadores";
	}

}
