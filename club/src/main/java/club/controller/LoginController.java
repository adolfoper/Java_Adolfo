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
	
	@GetMapping("/formlogin")
	public String formLogin() {
		System.out.println("formlogin 1");
		return"login";
	}
	
	@GetMapping("/index2")
	public String index2(HttpServletRequest request, Model modelo) {
		System.out.println("index2");
		System.out.println(request.getUserPrincipal().getName());
			
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
        System.out.println("** A cargar partidas");
		List<Partida> partidas = partidaService.getPartidas();
        System.out.println("** Partidas cargadas");
		List<Linea_index2> lineas = new ArrayList<Linea_index2>();
        System.out.println("** Lineas creada");

		for (Partida partida:partidas) {
			Linea_index2 inter= new Linea_index2();
			inter.setFromBD(partida);
			lineas.add(inter);
		}
        System.out.println("** Lineas cargadas");
		
		modelo.addAttribute("lineas", lineas);
		System.out.println("lineas:"+lineas);
		Partida partida = partidas.get(0);
		System.out.println("jugador 0:"+partida.getApuntados());
		
        //if (request.isUserInRole("ROLE_ADMINISTRADOR")) {
        //   System.out.println("Administrador");
        //    return "redirect:/administrador/";
        //}
        //if (request.isUserInRole("ROLE_SOCIO")) {
        //    System.out.println("Socio");
        //    return "redirect:/socio/";
        //}
        //
		//if (request.isUserInRole("ROLE_COLABORADOR")) {
        //    System.out.println("Colaborador");
        //    return "redirect:/colaborador/";
        //}
		
        //return "redirect:/";
		return"index2";
	}

}
