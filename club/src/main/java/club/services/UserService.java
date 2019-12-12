package club.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.dao.IUserDAO;
import club.model.User;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDAO.save(user);

	}

	@Override
	@Transactional
	public User getUser(String username) {
		
		return userDAO.getUser(username);
	}

	@Override
	@Transactional
	public void delete(User user) {
		userDAO.delete(user);

	}

}
