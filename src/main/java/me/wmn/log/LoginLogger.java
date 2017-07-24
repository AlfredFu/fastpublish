package me.wmn.log;

import org.slf4j.LoggerFactory;

public class LoginLogger {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginLogger.class);

	public void logLoginRecord(){
		logger.warn("AOP intercept: User login");
	}
}
