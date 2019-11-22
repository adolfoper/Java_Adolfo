package acceso_editorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/colaborador")
	
public class ColaboradorController {
	
	@GetMapping("/")
	public String inicio() {
//		System.out.println("colaborador");
		return"index-colaborador";
	}
	
}
