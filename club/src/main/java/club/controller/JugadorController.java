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
import club.model.User;
//import club.services.IUserService;
import club.pantalla.Linea_jugador;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@GetMapping("/index_usuarios")
 	public String index(HttpServletRequest request, Model modelo)  {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("=>> JugadorController /jugador");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
		
		List<Jugador> jugadores = jugadorService.getJugadores();
		System.out.println("** cargada lista jugadores");
		List<Linea_jugador> lineas = new ArrayList<Linea_jugador>();

		for (Jugador jugador:jugadores) {
			Linea_jugador linea= new Linea_jugador();
			System.out.println("** tratando jugador:"+jugador);
			linea.setFromBD(jugador);
			lineas.add(linea);
		}
		
		return"jugadores";
	}

}
