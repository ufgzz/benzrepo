package com.signhor.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.signhor.cms.dao.UserDAO;
import com.signhor.cms.model.User;

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
