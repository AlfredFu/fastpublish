package me.wmn.user;

public interface UserMapper {
	User getUser(String username);
	
	void addUser(User user);
	
	void deleteAll();
}
