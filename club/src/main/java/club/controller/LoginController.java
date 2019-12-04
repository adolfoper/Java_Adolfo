package club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import club.model.Jugador;
import club.services.IJugadorService;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller 
public class LoginController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@GetMapping("/formlogin")
	public String formLogin() {
		System.out.println("formlogin 1");
		return"login";
	}
	
	@GetMapping("/checkrol")
	public String checktol(HttpServletRequest request) {
		System.out.println("checkrol");
		System.out.println(request.getUserPrincipal().getName());
			
		String name = request.getUserPrincipal().getName();
		Jugador perfil = jugadorService.getJugador(name);
        System.out.println("Perfil:"+perfil);
		//List<Category> categories = categoryService.getCategories();
		//modelo.addAttribute("categories", categories);
		
        if (request.isUserInRole("ROLE_ADMINISTRADOR")) {
           System.out.println("Administrador");
            return "redirect:/administrador/";
        }
        if (request.isUserInRole("ROLE_SOCIO")) {
            System.out.println("Socio");
            return "redirect:/socio/";
        }
        
		if (request.isUserInRole("ROLE_COLABORADOR")) {
            System.out.println("Colaborador");
            return "redirect:/colaborador/";
        }
		
        return "redirect:/";
	}

}
