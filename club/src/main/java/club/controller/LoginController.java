package club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import club.model.Jugador;
import club.services.IJugadorService;
import club.model.Partida;
import club.services.IPartidaService;

import club.pantalla.Linea_index2;

@Controller 
public class LoginController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IPartidaService partidaService;
	
	//
	// Petición de login
	//
	@GetMapping("/formlogin")
	public String formLogin(){ 
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("==>> LoginController /formlogin");
        System.out.println("--> login");
		return"login";
	}
	
	//
	// Listado de partidas
	//
	@GetMapping("/index2")
	public String index2(HttpServletRequest request, Model modelo) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> LoginController /index2");
					
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);

		List<Partida> partidas = partidaService.getPartidas();
		List<Linea_index2> lineas = new ArrayList<Linea_index2>();

		// Carga de las líneas de partida
		for (Partida partida:partidas) {
			Linea_index2 linea= new Linea_index2();
			linea.setFromBD(partida);
			lineas.add(linea);
		}
		
		modelo.addAttribute("lineas", lineas);
		System.out.println("lineas:"+lineas);

        System.out.println("--> index2");
		return"index2";
	}

}
