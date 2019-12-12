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
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> ApuntadoController /apuntado");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
        
        System.out.println("** Idpartida:"+idpartida);
		Partida partida = partidaService.getPartida(idpartida);
		
		System.out.println("** a carga_form_apuntados");
		modelo = carga_form_apuntados(partida, perfil, modelo);
		System.out.println("** tras carga_form_apuntados");
		
		/*
		 * Form_partida form_partida = new Form_partida();
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
		*/		
        System.out.println("--> apuntados");
		return"apuntados";
	}
	
	@PostMapping("/procesar_apuntados")
	public String procesar(HttpServletRequest request, 
			@RequestParam("comentarios") String comentarios, 
			@RequestParam("idapuntado") int idapuntado, 
			@RequestParam("idpartida") int idpartida, 
			@RequestParam("accion") String accion, 
			Model modelo)  {
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> ApuntadoController /procesar_apuntados");
		
		System.out.println("comentarios: "+comentarios);
		System.out.println("idapuntado: "+idapuntado);
		System.out.println("idpartida: "+idpartida);
		System.out.println("accion: "+accion);
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
        
		Partida partida = partidaService.getPartida(idpartida);
		 System.out.println("** Partida:"+partida);
		 
		 Apuntado apuntado = new Apuntado();
		
		switch (accion) {
			case "Actualizar":
				 System.out.println("** Actualizar");
				apuntado = apuntadoService.getApuntado(idapuntado);
				apuntado.setComentarios(comentarios);
				apuntadoService.save(apuntado);
				 System.out.println("** Actualizado");
				 break;
			case "Desapuntar":
				 System.out.println("** Desapuntar");
				apuntado = apuntadoService.getApuntado(idapuntado);
				apuntadoService.delete(apuntado);
				 System.out.println("** Desapuntado");
				 break;
			case "Apuntar":
				 System.out.println("** Apuntar");
				apuntado.setComentarios(comentarios);
				apuntado.setPartida(partida);
				apuntado.setJugador(perfil);
				apuntadoService.save(apuntado);
				 System.out.println("** Apuntado");
				 break;
		}
		
		partida = partidaService.getPartida(idpartida);
		modelo = carga_form_apuntados(partida, perfil, modelo);
		
		System.out.println("--> apuntados");
		return"apuntados";
	}

	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> ApuntadoController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	public Model carga_form_apuntados(Partida partida, Jugador perfil, Model modelo)  {
		
		System.out.println("** carga_form_apuntados");
		
		modelo.addAttribute("partida", partida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);

		List<Apuntado> apuntados = partida.getApuntados();
		System.out.println("** lista apuntados partida:"+ apuntados);
		List<Linea_apuntado> lineas = new ArrayList<Linea_apuntado>();
		
		Form_apuntados form_apuntado = new Form_apuntados(partida.getIdpartida(), perfil.getIdjugador());
		
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
		
        System.out.println("** Lineas de apuntados cargadas:"+lineas);
        System.out.println("Form_apuntado:"+form_apuntado);
        System.out.println("Form_partida:"+form_partida);
        
		modelo.addAttribute("lineas", lineas);
		modelo.addAttribute("form_apuntado", form_apuntado);
		modelo.addAttribute("form_partida", form_partida);
		
		System.out.println ("**** Modelo:"+modelo);
		
		return modelo;
		
	}
}
