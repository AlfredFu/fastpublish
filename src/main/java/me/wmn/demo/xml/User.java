package me.wmn.demo.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class User{
	private int userId;
	private String username;
	private String password;
	private int credits;
	private String lastIp;
	private Date lastVisit;
	private List<LoginLog> logs;
	
	public User(){
		this.logs = new ArrayList<LoginLog>();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public List<LoginLog> getLogs() {
		return logs;
	}
	public void setLogs(List<LoginLog> logs) {
		this.logs = logs;
	}
	
	public void addLoginLog(LoginLog e){
		this.logs.add(e);
	}
	
	
}
