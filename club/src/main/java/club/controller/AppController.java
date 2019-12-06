package club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String inicio(Model modelo) {	
		System.out.println("AppController /");
		System.out.println("--> index");
		return "index";
	}
	
	@GetMapping("/index")
	public String retorno(Model modelo) {	
		System.out.println("AppController /index");
		System.out.println("--> index");
		return "index";
	}
}
