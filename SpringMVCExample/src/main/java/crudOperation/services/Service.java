package crudOperation.services;

import java.util.HashMap;
import java.util.List;

import crudOperation.user.User;

public interface Service {
	
	public List<User> saveUser(User user);
	
	public List<User> updateUser(User user);
	
	public List<User> deleteUser(String username);
	
	public List<User> findUser(String username);

}
