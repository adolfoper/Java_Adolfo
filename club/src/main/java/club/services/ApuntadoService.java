package club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.dao.IApuntadoDAO;
import club.model.Apuntado;

@Service("apuntadoService")
public class ApuntadoService implements IApuntadoService {

	@Autowired
	private IApuntadoDAO apuntadoDAO;
	
	@Override
	@Transactional
	public List<Apuntado> getApuntados() {
		return apuntadoDAO.getApuntados();
	}
	
	@Override
	@Transactional
	public List<Apuntado> getApuntados(int idpartida) {
		return apuntadoDAO.getApuntados(idpartida);
	}

	@Override
	@Transactional
	public void save(Apuntado apuntado) {
		apuntadoDAO.save(apuntado);

	}

	@Override
	@Transactional
	public Apuntado getApuntado(int idapuntado) {
		
		return apuntadoDAO.getApuntado(idapuntado);
	}

	@Override
	@Transactional
	public void delete(Apuntado apuntado) {
		apuntadoDAO.delete(apuntado);

	}

}
