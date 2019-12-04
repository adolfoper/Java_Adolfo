package club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.model.Apuntado;
import club.model.Jugador;
import club.model.Partida;
import club.services.IPartidaService;
import club.services.IJugadorService;
import club.services.IApuntadoService;


@Controller
@RequestMapping("/socio")
public class SocioController {

	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IPartidaService partidaService;
	
	@Autowired
	private IApuntadoService apuntadoService;
	
	@GetMapping("/")
	public String socio() {
		System.out.println("SocioController");
		return "index-socio";
	}
}
