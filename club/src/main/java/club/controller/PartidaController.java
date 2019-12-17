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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import club.model.Jugador;
import club.services.IJugadorService;

import club.model.Partida;
import club.services.IPartidaService;

import club.model.Apuntado;
import club.services.IApuntadoService;

import club.pantalla.Form_partida;


@Controller
@RequestMapping("/partida")
public class PartidaController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IPartidaService partidaService;
	
	@Autowired
	private IApuntadoService apuntadoService;
	
	//
	// Carga la pantalla de alta de partida
	//
	@GetMapping("/addpartida")
 	public String addpartida(Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /addpartida");

		Form_partida form_partida = new Form_partida();
		modelo.addAttribute("form_partida", form_partida);
		
        System.out.println("--> alta_partida");
		return"alta_partida";
	}
	
	//
	// Carga la pantalla de modificación de partida
	//
	@GetMapping("/updatepartida")
	public String updatepartida(@RequestParam("idpartida") int idpartida, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /updatepartida");

		Partida partida = partidaService.getPartida(idpartida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);
		modelo.addAttribute("form_partida", form_partida);
        
        System.out.println("--> modif_partida");
		return"modif_partida";
	}
	
	//
	// Delete de partida
	//
	@GetMapping("/deletepartida")
	public String deletepartida(@RequestParam("idpartida") int idpartida, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /deletepartida");

		Partida partida = partidaService.getPartida(idpartida);
		
		int idjugador=partida.getJugador().getIdjugador();
		
		// Delete de los apuntados a la partida
		List<Apuntado> apuntados = partida.getApuntados();
		for (Apuntado apuntado:apuntados) {
			apuntadoService.delete(apuntado);
		}
		
		// Delete de los apuntados a la partida
		partidaService.delete(partida);
		
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	//
	// Vuelta a la pantalla de listado de partidas
	//
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	//
	// Trata el retorno de la pantalla de alta de partida
	//
	@PostMapping("/procesar_alta_partida")
	public String procesar_alta_partida(HttpServletRequest request, 
										@Valid @ModelAttribute("form_partida") Form_partida form_partida, 
										BindingResult bindingResult) { 
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /procesar_alta_partida");
        
		form_partida.setMensaje_horas("");
		form_partida.setMensaje_plazas("");
		
		// Control de errores
		if (bindingResult.hasErrors()) { 
			return "alta_partida"; 
		} 
		else {
			if (!form_partida.validar()) {
				return "alta_partida"; 
			}
			
			// Recupera el usuario activo y la partida
			String name = request.getUserPrincipal().getName();
			Jugador perfil = jugadorService.getJugador(name);
	        
			// Modifica partida
	        Partida partida = form_partida.getToBD(perfil);	       
	        partidaService.save(partida);	
	        
	        // Apunta al usuario activo a la partida
	        Apuntado apuntado = new Apuntado();
	        apuntado.setComentarios("Creador de la partida");
			apuntado.setPartida(partida);
			apuntado.setJugador(perfil);
			apuntadoService.save(apuntado);
			
	        System.out.println("--> index2");
	        return "redirect:/index2";
		}
	}
	
	//
	// Trata el retorno de la pantalla de modificación de partida
	//
	@PostMapping("/procesar_modif_partida")
	public String procesar_modif_partida(HttpServletRequest request, 
										@Valid @ModelAttribute("form_partida") Form_partida form_partida, 
										BindingResult bindingResult) { 
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /procesar_modif_partida");
        
		form_partida.setMensaje_horas("");
		form_partida.setMensaje_plazas("");
		
		// Control de errores
		if (bindingResult.hasErrors()) { 
			return "modif_partida"; 
		} 
		else {
			if (!form_partida.validar()) {
				return "modif_partida"; 
			}
			
			// Recupera usuario activo
			String name = request.getUserPrincipal().getName();
			Jugador perfil = jugadorService.getJugador(name);
	    	   
			// Modifica la partida
	        Partida partida = form_partida.getToBD(perfil);
	        partidaService.save(partida);	
	        
	        System.out.println("--> index2");
	        return "redirect:/index2";
		}
	}
	
}
