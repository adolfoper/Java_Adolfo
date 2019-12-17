package club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	// 
	// Listado de jugadores apuntados a una partida
	// 
	@GetMapping("/apuntados")
 	public String apuntados(HttpServletRequest request, @RequestParam("idpartida") int idpartida, Model modelo)  {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> ApuntadoController /apuntado");
		
		// Recupera jugador actual y partida
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        
		Partida partida = partidaService.getPartida(idpartida);
		
		// Carga la lista de apuntados
		modelo = carga_form_apuntados(partida, perfil, modelo);
				
        System.out.println("--> apuntados");
		return"apuntados";
	}
	
	// 
	// Trata las acciones de la pantalla de lista de apuntados
	//
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
		
		// Recupera perfil del usuario y partida de la pantalla
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        
		Partida partida = partidaService.getPartida(idpartida);
		 
		 Apuntado apuntado = new Apuntado();
		
		// Tratamiento según el botón pulsado
		switch (accion) {
			case "Actualizar":
				apuntado = apuntadoService.getApuntado(idapuntado);
				apuntado.setComentarios(comentarios);
				apuntadoService.save(apuntado);
				 break;
			case "Desapuntar":
				apuntado = apuntadoService.getApuntado(idapuntado);
				apuntadoService.delete(apuntado);
				 break;
			case "Apuntar":
				apuntado.setComentarios(comentarios);
				apuntado.setPartida(partida);
				apuntado.setJugador(perfil);
				apuntadoService.save(apuntado);
				 break;
		}
		
		// Recarga de la pantalla de listado para reflejasr los cambios
		partida = partidaService.getPartida(idpartida);
		modelo = carga_form_apuntados(partida, perfil, modelo);
		
		System.out.println("--> apuntados");
		return"apuntados";
	}

	// 
	// Vuelta a la pantalla de partidas
	//
	@GetMapping("/cancel")
	public String cancel (HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> ApuntadoController /cancel");
        System.out.println("--> index2");
        return "redirect:/index2";
	}
	
	// 
	// Carga la lista de apuntados
	//
	public Model carga_form_apuntados(Partida partida, Jugador perfil, Model modelo)  {
		
		modelo.addAttribute("partida", partida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);

		List<Apuntado> apuntados = partida.getApuntados();
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
		
		modelo.addAttribute("lineas", lineas);
		modelo.addAttribute("form_apuntado", form_apuntado);
		modelo.addAttribute("form_partida", form_partida);
		
		return modelo;
		
	}
}
