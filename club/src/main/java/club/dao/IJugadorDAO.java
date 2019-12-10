package club.dao;

import java.util.List;

import club.model.Jugador;
import club.model.Apuntado;

public interface IJugadorDAO {
	
	Jugador getJugador(int idjugador);
	
	Jugador getJugador(String username);
	
	List<Jugador> getJugadores();

	void save(Jugador jugador);

	void delete(Jugador jugador);
	
	public List<Apuntado> getApuntados(int idjugador);
}
