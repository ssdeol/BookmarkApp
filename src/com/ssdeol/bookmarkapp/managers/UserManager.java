package com.ssdeol.bookmarkapp.managers;

import com.ssdeol.bookmarkapp.dao.UserDao;
import com.ssdeol.bookmarkapp.entities.User;

public class UserManager {
	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao();
	// Private Constructor = Makes it a singleton
	private UserManager() {
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
}
