package crudOperation.services;

import java.util.HashMap;
import java.util.List;


import crudOperation.dao.UserDAO;
import crudOperation.user.User;

public class ServiceImpl implements Service {

	
	UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		System.out.println(userDAO);
	}
	
	
	public List<User> saveUser(User user) {
		
		return userDAO.createUser(user);
		
	}
	public List<User> updateUser(User user) {
		
		
		 return userDAO.update(user);
	}
	public List<User> deleteUser(String username) {
		
		
		 return userDAO.delete(username);
		
	}
	public List<User> findUser(String username) {
		
		
		return userDAO.findUser(username);
		
	}

	
	
}
