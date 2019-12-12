package club.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.model.Authorities;
import club.model.Jugador;
import club.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUser(String username) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(User.class,username);
	}
	
	@Override
	public List<User> getUsers() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<User> users = miSesion.createQuery("from User", User.class).list();
		return users;
	}

	@Override
	public void save(User user) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(user);
	}
}
