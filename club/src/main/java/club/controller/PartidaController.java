package club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import java.util.ArrayList;
//import java.util.List;

import club.model.Jugador;
import club.services.IJugadorService;
import club.model.Partida;
import club.services.IPartidaService;
import club.pantalla.Form_partida;

@Controller
@RequestMapping("/partida")
public class PartidaController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IPartidaService partidaService;
	
	@GetMapping("/addpartida")
	public String addpartida(HttpServletRequest request, Model modelo) {
		System.out.println("PartidaController /addpartida");

		Form_partida form_partida = new Form_partida();
		modelo.addAttribute("form_partida", form_partida);
		
        System.out.println("--> index2");
		return"alta_partida";
	}
	
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
        return "redirect:/index2";
	}
	
	//public String procesar_alta_partida(HttpServletRequest request, Model modelo) {
	@GetMapping("/procesar_alta_partida")
	public String procesar_alta_partida(HttpServletRequest request, 
										@Valid @ModelAttribute("form_partida") Form_partida form_partida, 
										BindingResult bindingResult) { 
//	public String procesar_alta_partida(@Valid @ModelAttribute("form_partida") Form_partida form_partida,
// 				BindingResult bindingResult) {
		
		System.out.println("PartidaController /alta_partida");
        
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "alta_partida"; 
		} 
		else {
			System.out.println("Sin errores");
			
			String name = request.getUserPrincipal().getName();
			Jugador perfil = jugadorService.getJugador(name);
	        System.out.println("** Perfil:"+perfil);
	        
	        Partida partida = form_partida.getToBD(perfil);
	        System.out.println("** Partida convertida");
			partidaService.save(partida);	
	        System.out.println("** Partida grabada");
	        System.out.println("--> index2");
	        return "redirect:/index2";
		}
	}
	
}
