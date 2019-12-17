package club.services;

import java.util.List;

import club.model.User;

public interface IUserService {
	
	User getUser(String username);
	
	List<User> getUsers();

	void save(User user);

	void delete(User user);
}
