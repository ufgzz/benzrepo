package com.benz.portals.dao;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {
	
	public void testDAO(String username, String password) {
		
		System.out.println("TestDAO Begin ...");
		
		System.out.println("userName : " + username + ", password : " + password);
		
	}

}
