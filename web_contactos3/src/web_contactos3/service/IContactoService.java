package web_contactos3.service;

import java.util.List;
import web_contactos3.entity.Contacto;

public interface IContactoService {
	List<Contacto> getContactos();
	void save(Contacto contacto);
	void delete(Contacto contacto);
	Contacto getContacto(int idcontacto);
}
