package club.dao;

import java.util.List;

import club.model.Jugador;

public interface IJugadorDAO {
	
	Jugador getJugador(int idjugador);
	
	Jugador getJugador(String username);
	
	List<Jugador> getJugadores();

	void save(Jugador jugador);

	void delete(Jugador jugador);
}
