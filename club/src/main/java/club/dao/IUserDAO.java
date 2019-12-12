package club.dao;

import java.util.List;

import club.model.Authorities;
import club.model.User;
import club.model.Jugador;

public interface IUserDAO {
	
	User getUser(String username);
	
	List<User> getUsers();

	void save(User user);

	void delete(User user);
	
}
