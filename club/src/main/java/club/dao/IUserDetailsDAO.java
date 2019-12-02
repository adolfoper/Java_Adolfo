package club.dao;

import club.model.User;

public interface IUserDetailsDAO {
  User findUserByUsername(String username);
}
