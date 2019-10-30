package spring_MVC_ejercicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;

@Controller
public class Controlador {
	
	@RequestMapping("/")
	public String index(Model modelo) {
		return"index";
	}
	
	@RequestMapping("/form")
	public String verForm(Model modelo) {
		Alumno alumno=new Alumno();
		modelo.addAttribute("alumno", alumno);
		return"/alumno/form";
	}
	
	@RequestMapping("/procesar")
	public String procesar(@Valid @ModelAttribute("alumno") Alumno alumno,
			 				BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { 
			return "/alumno/form"; 
		} 
		else { 
			return "/alumno/ver-alumno"; 
		}
	}
}