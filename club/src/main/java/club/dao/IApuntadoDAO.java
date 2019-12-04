package club.dao;

import java.util.List;

import club.model.Apuntado;

public interface IApuntadoDAO {
	
	Apuntado getApuntado(int idjugador);
	
	List<Apuntado> getApuntados();
	
	//List<Apuntado> getApuntados(int idpartida);

	void save(Apuntado apuntado);

	void delete(Apuntado apuntado);
}
