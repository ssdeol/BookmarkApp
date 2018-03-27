package com.ssdeol.bookmarkapp.dao;

import com.ssdeol.bookmarkapp.DataStore;
import com.ssdeol.bookmarkapp.entities.User;
public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
