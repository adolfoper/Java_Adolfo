package acceso_editorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/editor")
	
public class EditorController {
	
	@GetMapping("/")
	public String inicio() {
//		System.out.println("editor");
		return"index-editor";
	}
	
}
