package crudOperation.dao;

import java.util.List;

import crudOperation.user.User;

public interface UserDAO {

	public List<User> createUser(User user);

	public List<User> findUser(String username);

	public List<User> update(User user);

	public List<User> delete(String username);

}
