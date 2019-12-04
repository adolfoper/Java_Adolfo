package club.services;

import java.util.List;

import club.model.Jugador;

public interface IJugadorService {
	List<Jugador> getJugadores();

	void save(Jugador jugador);

	Jugador getJugador(int idjugador);
	
	Jugador getJugador(String username);

	void delete(Jugador jugador);
}
