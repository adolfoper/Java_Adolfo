package acceso_editorial3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@Controller 
public class LoginController {
	
	@GetMapping("/formlogin")
	public String formLogin() {
//		System.out.println("formlogin 1");
		return"login";
	}
	
	@GetMapping("/checkrol")
	public String checktol(HttpServletRequest request) {
//		System.out.println("checkrol");
		
        if (request.isUserInRole("ROLE_ADMINISTRADOR")) {
 //           System.out.println("Administrador");
            return "redirect:/administrador/";
        }
        if (request.isUserInRole("ROLE_EDITOR")) {
//            System.out.println("Editor");
            return "redirect:/editor/";
        }
        
		if (request.isUserInRole("ROLE_COLABORADOR")) {
//            System.out.println("Colaborador");
            return "redirect:/colaborador/";
        }
		
        return "redirect:/";
		
	}
}
