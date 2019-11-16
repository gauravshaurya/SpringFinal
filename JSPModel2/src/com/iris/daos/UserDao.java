package com.iris.daos;

import java.util.List;

import com.iris.models.User;

public interface UserDao {
	public boolean registerUser(User uObj);
	public User loginUser(int userId,String password);
	public List<User> getAllUsers();
	public boolean deleteUser(int userId) throws Exception;
	/* public User updateUser(); */
}
