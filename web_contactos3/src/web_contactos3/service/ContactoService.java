package web_contactos3.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web_contactos3.DAO.IContactoDAO;
import web_contactos3.entity.Contacto;
import org.springframework.stereotype.Service;

@Service
public class ContactoService implements IContactoService {
	@Autowired
	private IContactoDAO contactoDAO;
	@Override
	@Transactional
	public List<Contacto> getContactos() {
		return contactoDAO.getContactos();
	}
	
	@Transactional
	public void save(Contacto contacto) {
		contactoDAO.save(contacto);
	}
	
	@Transactional
	public Contacto getContacto(int idcontacto) {
		return contactoDAO.getContacto(idcontacto);
	}
	
	@Transactional
	public void delete(Contacto contacto) {
		contactoDAO.delete(contacto);
	}
}
