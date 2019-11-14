package web_contactos3.DAO;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web_contactos3.entity.Contacto;


@Repository
public class ContactoDAO implements IContactoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//XTransactional
	public List<Contacto> getContactos() {
		Session miSesion=sessionFactory.getCurrentSession();
		
		List<Contacto> contactos=miSesion.createQuery("from Contacto",Contacto.class).list();
		return contactos;
	}
	
	@Override
	public void save(Contacto contacto) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(contacto);
	}
	
	@Override
	public void delete(Contacto contacto) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(contacto);
	}
	
	@Override
	public Contacto getContacto(int idcontacto) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Contacto.class,idcontacto);
	}

}
