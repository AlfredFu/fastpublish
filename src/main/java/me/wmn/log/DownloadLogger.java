package me.wmn.log;

import org.aopalliance.intercept.Joinpoint;
import org.slf4j.LoggerFactory;

public class DownloadLogger {
	
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadLogger.class);

	public void logDownloadRecord(){
		logger.warn("AOP intercept: User downoad package");
	}
}
