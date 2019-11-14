package web_contactos3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web_contactos3.Contacto_web;

//import web_contactos3.DAO.IContactoDAO;
import web_contactos3.service.IContactoService;
import web_contactos3.entity.Contacto;
import java.util.List;

import javax.validation.Valid;

@Controller
public class Controlador {
	
	@Autowired
	private IContactoService contactoService;
	
	String mensaje = "";
	
	// Supuesto menú de inicio no necesario realmente
	@RequestMapping("/")
	public String index(Model modelo) {
		//System.out.println("Index");
		mensaje="";
		return"redirect:/lista-contactos";
	}

	// Muestra la pantalla de listado de contactos
	@RequestMapping("/lista-contactos")
	public String lista(Model modelo) {
		//System.out.println("lista_contactos");
		List<Contacto> contactos=contactoService.getContactos();
		//System.out.println(contactos);
		modelo.addAttribute("contactos",contactos);
		modelo.addAttribute("mensaje",mensaje);
		return "lista-contactos";
	}

	// Muestra la pantalla de alta de contacto
	@RequestMapping("/alta_contacto")
	public String altaContacto(Model modelo) {
		//System.out.println("Alta contacto");
		Contacto_web contacto_web = new Contacto_web();
		modelo.addAttribute("contacto_web", contacto_web);
		return"alta_contacto";
	}
	
	// Procesa la respuesta de la pantalla de alta de contacto
	@PostMapping("/procesar_alta")
	public String procesar_alta(@Valid @ModelAttribute("contacto_web") Contacto_web contacto_web,
			 				BindingResult bindingResult) {
		//System.out.println("Entra en procesar alta");
		if (bindingResult.hasErrors()) { 
			//System.out.println("Con errores");
			//System.out.println(bindingResult.getAllErrors());
			return "/alta_contacto"; 
		} 
		else {
			//System.out.println("Sin errores");
			Contacto contacto = contacto_web.getToBD();
			contactoService.save(contacto);
			mensaje = "Alta realizada";
			return"redirect:/lista-contactos";	
		}
	}

	// Muestra la pantalla de modificación de contacto
	@GetMapping("modificar_contacto")
	public String modificar_contacto(@RequestParam("idcontacto") int idcontacto, Model modelo) {
		// System.out.println("Entra en modificar contacto");
		Contacto contacto= contactoService.getContacto(idcontacto);
		Contacto_web contacto_web = new Contacto_web();
		contacto_web.setFromBD(contacto);
		modelo.addAttribute("contacto_web", contacto_web);
		return"modificar_contacto";
	}
	
	// Muestra la pantalla de modificación de contacto
	@PostMapping("procesar_modificacion")
	public String procesar_modificacion(@Valid @ModelAttribute("contacto_web") Contacto_web contacto_web,
 			BindingResult bindingResult) {
		System.out.println("Entra en procesar modificación");
		if (bindingResult.hasErrors()) { 
			System.out.println("Con errores");
			System.out.println(bindingResult.getAllErrors());
			return "/modificar_contacto"; 
		} 
		else {
			System.out.println("Sin errores");
			Contacto contacto = contacto_web.getToBD();
			contactoService.save(contacto);
			mensaje = "Modifiación realizada";
			return"redirect:/lista-contactos";	
		}
	}
		
		@GetMapping("borrar_contacto")
		public String borrar_contacto(@RequestParam("idcontacto") int idcontacto) {
			Contacto contacto= contactoService.getContacto(idcontacto);
			contactoService.delete(contacto);
			mensaje = "Baja realizada";
			return"redirect:/lista-contactos";
		}
	
}
