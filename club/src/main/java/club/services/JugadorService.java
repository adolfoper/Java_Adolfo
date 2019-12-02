package club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.dao.IJugadorDAO;
import club.model.Jugador;

@Service("jugadorService")
public class JugadorService implements IJugadorService {

	@Autowired
	private IJugadorDAO jugadorDAO;
	
	@Override
	@Transactional
	public List<Jugador> getJugadores() {
		return jugadorDAO.getJugadores();
	}

	@Override
	@Transactional
	public void save(Jugador jugador) {
		jugadorDAO.save(jugador);

	}

	@Override
	@Transactional
	public Jugador getJugador(int idjugador) {
		
		return jugadorDAO.getJugador(idjugador);
	}

	@Override
	@Transactional
	public void delete(Jugador jugador) {
		jugadorDAO.delete(jugador);

	}

}
