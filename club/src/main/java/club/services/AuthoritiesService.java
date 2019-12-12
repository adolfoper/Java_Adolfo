package club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.dao.IAuthoritiesDAO;
import club.model.Authorities;
import club.model.User;

@Service("authoritiesService")
public class AuthoritiesService implements IAuthoritiesService {

	@Autowired
	private IAuthoritiesDAO authoritiesDAO;
	
	@Override
	@Transactional
	public Authorities getAuthorities(String username, String authority) {
		return authoritiesDAO.getAuthorities(username, authority);
	}

	@Override
	@Transactional
	public List<Authorities> getAuthorities(String username) {
		return authoritiesDAO.getAuthorities(username);
	}
	
	@Override
	@Transactional
	public User getUser(String username) {
		return authoritiesDAO.getUser(username);
	}

	@Override
	@Transactional
	public void save(Authorities authority) {
		authoritiesDAO.save(authority);
	}
	
	@Override
	@Transactional
	public void delete(Authorities authority) {
		authoritiesDAO.delete(authority);
	}

}
