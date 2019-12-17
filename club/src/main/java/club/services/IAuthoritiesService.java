package club.services;

import java.util.List;

import club.model.Authorities;
import club.model.User;

public interface IAuthoritiesService {
	Authorities getAuthorities(String username, String authority);
	
	List<Authorities> getAuthorities(String username);
	
	User getUser(String username);

	void save(Authorities authority);

	void delete(Authorities authority);
}
