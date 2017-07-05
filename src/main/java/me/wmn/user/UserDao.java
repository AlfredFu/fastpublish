package me.wmn.user;

import org.springframework.stereotype.Repository;

@Repository("securityUserDao")
public class UserDao implements IUserDao {
	
	public User getUser(String username){
		//TODO
		return new User();
	}

}
