package crudOperation.dao;

import java.util.List;

import crudOperation.user.User;

public interface UserDAO {

	public void createUser(User user);

	public List<User> findUser(String username);

	public void update(User user);

	public void delete(String username);
	
	public List<User> show();

}
