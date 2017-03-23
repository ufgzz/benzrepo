package com.benz.portals.service;

import com.benz.portals.dao.UserDAO;
import com.benz.portals.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {
	
	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	public User testService(String username, String password) {
		
		System.out.println("TestService Begin ...");
		userDAO.testDAO(username, password);
		
		User loginUser = new User();
		loginUser.setUsername(username);
		loginUser.setPassword(password);
		return loginUser;
	}

}
