package com.ccs.ems.svc;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ccs.ems.dao.UserDAO;
import com.ccs.ems.model.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Transactional
	@Override
	public User getUserByFirstName(String userFirstName) {
		// TODO Auto-generated method stub
		return userDAO.getUserByFirstName(userFirstName);
	}

	@Transactional
	@Override
	public User getUserByLastName(String userLastName) {
		// TODO Auto-generated method stub
		return userDAO.getUserByLastName(userLastName);
	}

	@Transactional
	@Override
	public User getUserByID(long userID) {
		// TODO Auto-generated method stub
		return userDAO.getUserByID(userID);
	}

	@Transactional
	@Override
	public void renameUser(String oldFirstName, String newFirstName,
			String oldLastName, String newLastName) {
		// TODO Auto-generated method stub
		userDAO.renameUser(oldFirstName, newFirstName, oldLastName, newLastName);
	}

	@Transactional
	@Override
	public void deleteUserByID(long userID) {
		// TODO Auto-generated method stub
		userDAO.deleteUserByID(userID);
	}

	@Transactional
	@Override
	public void deleteUserByName(String userFisrtName, String userLastName) {
		// TODO Auto-generated method stub
		userDAO.deleteUserByName(userFisrtName, userLastName);
	}

	@Transactional
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.createUser(user);
	}

	@Transactional
	@Override
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

}
