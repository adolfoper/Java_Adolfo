package club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String inicio(Model modelo) {	
		System.out.println("AppController -> index");
		return "index";
	}
}
