package me.demo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DownloadTimeAdvice {
	static Logger logger = LoggerFactory.getLogger(DownloadTimeAdvice.class);
	
	@Pointcut("execution(* me.wmn.controller.PackageController.downloadPackage(..))")
	private void downloadPackage(){} //声明一个切入点,切入点的名称其实是一个方法

	@Around("downloadPackage() && args(packageId, request, response)")
	public Object aroundAdvice(ProceedingJoinPoint pjp, int packageId, HttpServletRequest request, HttpServletResponse response) throws Throwable{
		if(logger.isWarnEnabled()){
			logger.warn("====================Around advice 在方法执行---前---");
		}
		long start = System.currentTimeMillis();
		
		Object res = pjp.proceed();
		
		long end = System.currentTimeMillis();
		
		logger.warn("====================Around advice 在方法执行---后---");
		logger.warn("============Download package {} take {} miliseconds============", packageId, (end - start));
		
		return res;
	}
	
	@After("downloadPackage()")
	public void afterAdvice(){
		logger.warn("====================After advice");
	}
	
	@AfterReturning(pointcut="downloadPackage()", returning="returnValue")
	public void afterReturningAdvice(JoinPoint jp, Object returnValue){
		logger.warn("====================AfterReturning advice");
	}
	
	@AfterThrowing("downloadPackage()")
	public void afterThrowingAdvice(){
		logger.warn("====================AfterThrowing advice");
	}
	
	@Before("downloadPackage()")
	public void beforeAdvice(){
		logger.warn("====================Before advice ");

	}
	
	
}
