package club.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.model.Apuntado;

@Repository
public class ApuntadoDAO implements IApuntadoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Apuntado getApuntado(int idapuntado) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Apuntado.class,idapuntado);
	}
	
	@Override
	public List<Apuntado> getApuntados() {
		Session miSesion = sessionFactory.getCurrentSession();

		List<Apuntado> apuntados = miSesion.createQuery("from Apuntado", Apuntado.class).list();
		return apuntados;
	}
	
	//@Override
	//public List<Apuntado> getApuntados(int idpartida) {
	//	Session miSesion = sessionFactory.getCurrentSession();
	//	List<Apuntado> apuntados=miSesion.createQuery("from Partida where idpartida=:idpartida", 
	//	Apuntado.class).setParameter("idpartida", idpartida).list();	
	//	return apuntados;
	//}

	@Override
	public void save(Apuntado apuntado) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(apuntado);
	}

	@Override
	public void delete(Apuntado apuntado) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(apuntado);

	}

}
