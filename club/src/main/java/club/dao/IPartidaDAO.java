package club.dao;

import java.util.List;

import club.model.Partida;

public interface IPartidaDAO {
	
	Partida getPartida(int idpartida);
	
	List<Partida> getPartidas();

	void save(Partida partida);

	void delete(Partida partida);
}
