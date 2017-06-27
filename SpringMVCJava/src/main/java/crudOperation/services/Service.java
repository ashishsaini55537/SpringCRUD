package crudOperation.services;

import java.util.HashMap;
import java.util.List;

import crudOperation.user.User;

public interface Service {
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(String username);
	
	public List<User> findUser(String username);
	
	public List<User> showAll();
	
	public void uploadBulk(List<User> user);
		
	

}
