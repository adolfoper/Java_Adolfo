package club.services;

import java.util.List;

import club.model.Jugador;

public interface IJugadorService {
	List<Jugador> getJugadores();

	void save(Jugador jugador);

	Jugador getJugador(int idjugador);

	void delete(Jugador jugador);
}
