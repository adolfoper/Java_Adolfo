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

import java.util.ArrayList;
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
import club.pantalla.Linea_apuntado;
import club.pantalla.Form_apuntados;


@Controller
@RequestMapping("/apuntado")
public class ApuntadoController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IPartidaService partidaService;
	
	@Autowired
	private IApuntadoService apuntadoService;
	
	@GetMapping("/apuntados")
 	public String apuntados(HttpServletRequest request, @RequestParam("idpartida") int idpartida, Model modelo)  {
		System.out.println("=>> ApuntadoController /apuntado");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
        
		Partida partida = partidaService.getPartida(idpartida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);
		modelo.addAttribute("form_partida", form_partida);
		
		List<Apuntado> apuntados = apuntadoService.getApuntados();
		List<Linea_apuntado> lineas = new ArrayList<Linea_apuntado>();
		
		Form_apuntados form_apuntado = new Form_apuntados(idpartida, perfil.getIdjugador());
		
		// Numero de linea
		int contador = 0;

		// Carga las lineas de apuntados
		for (Apuntado apuntado:apuntados) {
			contador ++;
			Linea_apuntado linea= new Linea_apuntado();
			linea.setFromBD(apuntado,perfil,contador);
			
			if (linea.getEsUsuario()) {
				form_apuntado.setIdapuntado(linea.getIdapuntado());
				form_apuntado.setComentarios(linea.getComentarios());
			}
			lineas.add(linea);
		}
		
        System.out.println("** Lineas de apuntados cargadas");
        System.out.println("Form_apuntado:"+form_apuntado);
        
		modelo.addAttribute("lineas", lineas);
		modelo.addAttribute("form_apuntado", form_apuntado);		
        System.out.println("--> apuntados");
		return"apuntados";
	}
	
	@GetMapping("/updateapuntado")
	public String alta_apuntado(HttpServletRequest request, 
			@RequestParam("idapuntado") int idapuntado, 
			@RequestParam("comentarios") String comentarios, 
			Model modelo)  {
	//public String procesar_alta_apuntado(HttpServletRequest request, 
	//			@Valid @ModelAttribute("form_apuntado") Form_apuntados form_apuntado, 
	//			BindingResult bindingResult) { 
		
		System.out.println("=>> ApuntadoController /addapuntado");
		
		System.out.println("idapuntado: "+idapuntado);
		System.out.println("comentarios: "+comentarios);
		Apuntado apuntado = apuntadoService.getApuntado(idapuntado);
		System.out.println("apuntado: "+apuntado);
        
        Jugador jugador = jugadorService.getJugador(apuntado.getJugador().getIdjugador());
        System.out.println("jugador: "+jugador);
		Partida partida = partidaService.getPartida(apuntado.getPartida().getIdpartida());
		System.out.println("partida: "+partida);
		
		apuntadoService.save(apuntado);
	    System.out.println("** Apuntado grabado");
	    modelo.addAttribute("idpartida", partida.getIdpartida());
	    System.out.println("--> apuntados");
	    return "redirect:/apuntado/apuntados";
	}
	

	@PostMapping("/procesar_apuntados")
	public String procesar(HttpServletRequest request, 
			@Valid @ModelAttribute("form_apuntado") Form_apuntados form_apuntado, 
			BindingResult bindingResult) { 
		
		System.out.println("=>> ApuntadoController /procesar_apuntados");
		
		System.out.println("form_apuntado: "+form_apuntado);
		
	    return "redirect:/apuntado/apuntados";
	}
}
