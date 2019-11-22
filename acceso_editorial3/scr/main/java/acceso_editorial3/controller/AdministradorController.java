package acceso_editorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/administrador")
	
public class AdministradorController {
	
	@GetMapping("/")
	public String inicio() {
//		System.out.println("administrador");
		return"index-administrador";
	}
	
}
