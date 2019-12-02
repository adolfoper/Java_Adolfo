package club.services;

import java.util.List;

import club.model.Partida;

public interface IPartidaService {
	List<Partida> getPartidas();

	void save(Partida partida);

	Partida getPartida(int idpartida);

	void delete(Partida partida);
}
