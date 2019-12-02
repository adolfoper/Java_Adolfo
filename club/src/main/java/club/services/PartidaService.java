package club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.dao.IPartidaDAO;
import club.model.Partida;

@Service("partidaService")
public class PartidaService implements IPartidaService {

	@Autowired
	private IPartidaDAO partidaDAO;
	
	@Override
	@Transactional
	public List<Partida> getPartidas() {
		return partidaDAO.getPartidas();
	}

	@Override
	@Transactional
	public void save(Partida partida) {
		partidaDAO.save(partida);

	}

	@Override
	@Transactional
	public Partida getPartida(int idpartida) {
		
		return partidaDAO.getPartida(idpartida);
	}

	@Override
	@Transactional
	public void delete(Partida partida) {
		partidaDAO.delete(partida);

	}

}
