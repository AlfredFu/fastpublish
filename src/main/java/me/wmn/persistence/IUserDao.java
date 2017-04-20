package me.wmn.persistence;

import java.util.List;

import me.wmn.domain.User;

public interface IUserDao {

	public User selectById(int id);
	
	public void deleteById(int id);
	
	public List<User> getAll();
	
	public void update(User user);
	
	public void add(User user);
	
}
