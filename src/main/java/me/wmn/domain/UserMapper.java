package me.wmn.domain;

import java.util.List;

public interface UserMapper {

	public User selectById(int id);
	
	public void deleteById(int id);
	
	public List<User> getAll();
	
	public void update(User user);
	
	public void add(User user);
}
