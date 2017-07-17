package me.wmn.user;

public interface IUserDao {

	User getUser(String username);
	
	void addUser(User user);
	
	void deleteAll();
}
