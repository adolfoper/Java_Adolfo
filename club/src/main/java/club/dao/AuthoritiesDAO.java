package club.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.model.User;
import club.model.Authorities;

@Repository
public class AuthoritiesDAO implements IAuthoritiesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Authorities getAuthorities(String username, String authority) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Authorities.class,username+authority);
	}
	
	@Override
	public List<Authorities> getAuthorities(String username){
		Session miSesion = sessionFactory.getCurrentSession();

		List<Authorities> authorities=miSesion.createQuery("from Authorities where username=:username", 
				Authorities.class).setParameter("username", username).list();
		return authorities;
	}
	
	@Override
	public User getUser(String username) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(User.class,username);
	}
	
	@Override
	public void save(Authorities authority) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(authority);
	}

	@Override
	public void delete(Authorities authority) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(authority);
	}

}
