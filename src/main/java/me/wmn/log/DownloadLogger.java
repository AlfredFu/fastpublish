package me.wmn.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(10)
public class DownloadLogger {
	
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(DownloadLogger.class);

	@After("execution(* me.wmn.controller.PackageController.downloadPackage(..))")
	public void logDownloadRecord(){
		logger.warn("================After advice");
	}
	
	@Before("execution(* me.wmn.controller.PackageController.downloadPackage(..))")
	public void beforeLogDownloadRecord(){
		logger.warn("================Before advice");

	}
}
