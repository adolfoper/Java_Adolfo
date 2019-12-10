package club.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.model.Apuntado;
import club.model.Partida;

@Repository
public class PartidaDAO implements IPartidaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Partida getPartida(int idpartida) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Partida.class,idpartida);
	}
	
	@Override
	public List<Partida> getPartidas() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Partida> partidas = miSesion.createQuery("from Partida", Partida.class).list();
		return partidas;
	}

	@Override
	public void save(Partida partida) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(partida);
	}

	@Override
	public void delete(Partida partida) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(partida);

	}
	
	@Override
	public List<Apuntado> getApuntados(int idpartida) {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Apuntado> apuntados = miSesion.createQuery("select apun from apuntados where apun.idpartida="+idpartida, Apuntado.class).list();
		return apuntados;
	}

}
