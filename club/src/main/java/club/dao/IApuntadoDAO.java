package club.dao;

import java.util.List;

import club.model.Apuntado;

public interface IApuntadoDAO {
	
	Apuntado getApuntado(int idjugador);
	
	List<Apuntado> getApuntados();

	void save(Apuntado apuntado);

	void delete(Apuntado apuntado);
}
