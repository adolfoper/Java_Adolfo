package web_contactos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web_contactos.Contacto;
import web_contactos.Contacto_web;
import org.springframework.ui.Model;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class Controlador {

	// Cargar el contexto
	ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext2.xml");
	
	// Pedir los beans
	Contacto contacto = context2.getBean("contacto",Contacto.class); 
	Contacto_web contacto_web = context2.getBean("contacto_web",Contacto_web.class);
	
	@RequestMapping("/")
	public String index(Model modelo) {
		System.out.println("Entra en /");
		return"index";
	}
	
	@RequestMapping("/alta_contacto")
	public String verForm(Model modelo) {
		contacto_web.reset();
		modelo.addAttribute("contacto_web", contacto_web);
		return"/contacto/alta_contacto";
	}
	
	@RequestMapping("/procesar_alta")
	public String procesar(@Valid @ModelAttribute("contacto_web") Contacto_web contacto_web,
			 				BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { 
			return "/contacto/alta_contacto"; 
		} 
		else {
			contacto = context2.getBean("contacto",Contacto.class);
			contacto = contacto_web.getToBD();
			// ==> llamada a DAO_Contactos.alta()	
			return "/contacto/alta_contacto_OK"; 
		}
	}
}