package me.wmn.user;

public class User {
	
	private String username;
	
	private String password;
	
	public User(){
		username = "fredfu";
		password = "fred909A";
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

}
