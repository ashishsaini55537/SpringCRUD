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
	
	
	public void saveUser(User user) {
		
		userDAO.createUser(user);
		
	}
	public void updateUser(User user) {
		
		
		 userDAO.update(user);
	}
	public void deleteUser(String username) {
		
		
		 userDAO.delete(username);
		
	}
	public List<User> findUser(String username) {
		
		
		return userDAO.findUser(username);
		
	}
	
	public List<User> showAll()
	{
		return userDAO.show();
		
	}


	public void uploadBulk(List<User> user) {
		
		userDAO.bulkUpload(user);
		
		
	}

	
	
}
