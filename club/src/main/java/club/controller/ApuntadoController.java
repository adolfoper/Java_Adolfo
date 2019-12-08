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
		System.out.println("ApuntadoController /apuntado");
		
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("** Perfil:"+perfil);
        
		Partida partida = partidaService.getPartida(idpartida);
		Form_partida form_partida = new Form_partida();
		form_partida.setFromBD(partida);
		modelo.addAttribute("form_partida", form_partida);
		
		List<Apuntado> apuntados = apuntadoService.getApuntados();
		List<Linea_apuntado> lineas = new ArrayList<Linea_apuntado>();
		int contador = 0;
		boolean perfil_apuntado = false;

		for (Apuntado apuntado:apuntados) {
			contador ++;
			Linea_apuntado linea= new Linea_apuntado();
			linea.setFromBD(apuntado,perfil,contador);
			if (linea.getEsUsuario()) {
				perfil_apuntado = true;
			}
			lineas.add(linea);
		}
		
		if (!perfil_apuntado) {
			contador ++;
			Linea_apuntado linea= new Linea_apuntado();
			linea.setVacio(perfil,contador);
			lineas.add(linea);
		}
		
		modelo.addAttribute("lineas", lineas);
		modelo.addAttribute("apuntado", perfil_apuntado);
		
        System.out.println("--> apuntados");
		return"apuntados";
	}
	
}
