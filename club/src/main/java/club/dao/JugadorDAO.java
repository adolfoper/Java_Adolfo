package club.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Collection;

import club.model.Jugador;
import club.model.Apuntado;

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
	public Jugador getJugador(String username) {
		Session miSesion=sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query q = miSesion.createQuery
				("from Jugador where username = :u");
		q.setParameter("u",username);  

		@SuppressWarnings("rawtypes")
		List results = q.getResultList();
		
		Jugador jugador = null;
		if(!results.isEmpty()){
			// ignores multiple results
		    List<Jugador> results2 = typesafeAdd(results, new ArrayList<Jugador>(), Jugador.class);
			jugador = results2.get(0);
		}
			
		return jugador;
	}
	
	@Override
	public List<Jugador> getJugadores() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Jugador> jugadores = miSesion.createQuery("from Jugador", Jugador.class).list();
		return jugadores;
	}
	
	@Override
	public List<Apuntado> getApuntados(int idjugador) {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Apuntado> apuntados = miSesion.createQuery("select apun from apuntados where apun.idjugador="+idjugador, Apuntado.class).list();
		return apuntados;
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

	private <T, C extends Collection<T>> C typesafeAdd(Iterable<?> from, 
				  C to, Class<T> listClass) {
	    for (Object item: from) {
	      to.add(listClass.cast(item));
	    }
	    return to;
	  }
}
