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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import java.util.ArrayList;
//import java.util.List;

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
	
	@GetMapping("/addpartida")
//	public String addpartida(HttpServletRequest request, Model modelo) {
 	public String addpartida(Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /addpartida");

		Form_partida form_partida = new Form_partida();
		modelo.addAttribute("form_partida", form_partida);
		
        System.out.println("--> alta_partida");
		return"alta_partida";
	}
	
	@GetMapping("/updatepartida")
	public String updatepartida(@RequestParam("idpartida") int idpartida, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /updatepartida");

		Partida partida = partidaService.getPartida(idpartida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);
		modelo.addAttribute("form_partida", form_partida);
        System.out.println("** ID:"+form_partida.getIdpartida());
		
        System.out.println("--> modif_partida");
		return"modif_partida";
	}
	
	@GetMapping("/deletepartida")
	public String deletepartida(@RequestParam("idpartida") int idpartida, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /deletepartida");

		Partida partida = partidaService.getPartida(idpartida);
		
		int idjugador=partida.getJugador().getIdjugador();
		
		List<Apuntado> apuntados = partida.getApuntados();
		for (Apuntado apuntado:apuntados) {
			apuntadoService.delete(apuntado);
		}
		
		partidaService.delete(partida);
		
        System.out.println("--> index2");
        return "redirect:/index2";
	}
		
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	//public String procesar_alta_partida(HttpServletRequest request, Model modelo) {
	@PostMapping("/procesar_alta_partida")
	public String procesar_alta_partida(HttpServletRequest request, 
										@Valid @ModelAttribute("form_partida") Form_partida form_partida, 
										BindingResult bindingResult) { 
//	public String procesar_alta_partida(@Valid @ModelAttribute("form_partida") Form_partida form_partida,
// 				BindingResult bindingResult) {
		
		System.out.println("=>> PartidaController /procesar_alta_partida");
        
		form_partida.setMensaje_horas("");
		form_partida.setMensaje_plazas("");
		
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "alta_partida"; 
		} 
		else {
			if (!form_partida.validar()) {
				System.out.println("Error de horas");
				return "alta_partida"; 
			}
			System.out.println("Sin errores");
			
			String name = request.getUserPrincipal().getName();
			Jugador perfil = jugadorService.getJugador(name);
	        System.out.println("** Perfil:"+perfil);
	        
	        Partida partida = form_partida.getToBD(perfil);
	        System.out.println("** Partida convertida:"+partida);
			partidaService.save(partida);	
	        System.out.println("** Partida grabada");
	        
	        Apuntado apuntado = new Apuntado();
	        apuntado.setComentarios("Creador de la partida");
			apuntado.setPartida(partida);
			apuntado.setJugador(perfil);
			apuntadoService.save(apuntado);
			
			 System.out.println("** Apuntado");
	        System.out.println("--> index2");
	        return "redirect:/index2";
		}
	}
	
	@PostMapping("/procesar_modif_partida")
	public String procesar_modif_partida(HttpServletRequest request, 
										@Valid @ModelAttribute("form_partida") Form_partida form_partida, 
										BindingResult bindingResult) { 
//	public String procesar_alta_partida(@Valid @ModelAttribute("form_partida") Form_partida form_partida,
// 				BindingResult bindingResult) {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> PartidaController /procesar_modif_partida");
        
		form_partida.setMensaje_horas("");
		form_partida.setMensaje_plazas("");
		
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			return "modif_partida"; 
		} 
		else {
			if (!form_partida.validar()) {
				System.out.println("Error de horas");
				return "modif_partida"; 
			}
			System.out.println("Sin errores");
			
			String name = request.getUserPrincipal().getName();
			Jugador perfil = jugadorService.getJugador(name);
	        System.out.println("** Perfil:"+perfil);
	        System.out.println("** ID:"+form_partida.getIdpartida());
	        
	        Partida partida = form_partida.getToBD(perfil);
	        System.out.println("** ID:"+partida.getIdpartida());
	        System.out.println("** Partida convertida:"+partida);
			partidaService.save(partida);	
	        System.out.println("** Partida grabada");
	        System.out.println("--> index2");
	        return "redirect:/index2";
		}
	}
	
}
