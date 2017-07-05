package me.wmn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	@Qualifier("securityUserDao")
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails details = null;
		
		User u = this.userDao.getUser(username);
		
		details = new org.springframework.security.core.userdetails.User(
				u.getUsername(), 
				u.getPassword(), 
				u.isEnabled(), 
				u.isAccountNonExpired(), 
				u.isCredentialsNonExpired(), 
				u.isAccountNonLocked(), 
				AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		
		return details;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
