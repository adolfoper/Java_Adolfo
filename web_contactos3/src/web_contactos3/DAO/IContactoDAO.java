package web_contactos3.DAO;

import java.util.List;

import web_contactos3.entity.Contacto;

public interface IContactoDAO {
	
	List<Contacto> getContactos();
	void save(Contacto contacto);
	void delete(Contacto contacto);
	Contacto getContacto(int idcontacto);
	
}
