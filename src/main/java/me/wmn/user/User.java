package me.wmn.user;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private long userId;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String intro;
	
	private List<Role> roles;
	
	public User(){
		roles = new ArrayList<Role>();
	}
	
	public boolean isEnabled(){
		return true;
	}
	
	public boolean isAccountNonExpired(){
		return true;
	}
	
	public boolean isCredentialsNonExpired(){
		return true;
	}
	
	public boolean isAccountNonLocked(){
		return true;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	

}
