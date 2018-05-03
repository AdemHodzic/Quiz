package DAO;

import java.util.ArrayList;

import Entities.UserProperties;

public interface UserDAO {
	
	public UserProperties getUser(UserProperties properties);
	public ArrayList<UserProperties> getAlluser();
	public void addUser(UserProperties properties);
	public void deleteUser(UserProperties properties);
	public void updateUser(UserProperties properties);
	
	
}
