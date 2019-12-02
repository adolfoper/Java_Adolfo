package club.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.model.Jugador;

@Repository
public class JugadorDAO implements IJugadorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Jugador getJugador(int idjugador) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Jugador.class,idjugador);
	}
	
	@Override
	public List<Jugador> getJugadores() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Jugador> jugadores = miSesion.createQuery("from Jugadores", Jugador.class).list();
		return jugadores;
	}

	@Override
	public void save(Jugador jugador) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(jugador);
	}

	@Override
	public void delete(Jugador jugador) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(jugador);

	}

}
