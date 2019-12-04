package club.services;

import java.util.List;

import club.model.Apuntado;

public interface IApuntadoService {
	List<Apuntado> getApuntados();
	
	//List<Apuntado> getApuntados(int idpartida);

	void save(Apuntado apuntado);

	Apuntado getApuntado(int idapuntado);

	void delete(Apuntado apuntado);
}
