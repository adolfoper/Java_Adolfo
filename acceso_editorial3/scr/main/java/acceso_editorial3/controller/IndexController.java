package acceso_editorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class IndexController {
	@GetMapping("/")
	public String inicio() {
//		System.out.println("index");
		return"index";
	}
	
	@GetMapping("/index")
	public String retrorno() {
//		System.out.println("index 2");
		return"index";
	}
}