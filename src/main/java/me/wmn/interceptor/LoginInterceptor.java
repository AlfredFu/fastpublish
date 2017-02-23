package me.wmn.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException{
		if(request.getSession().getAttribute("username") == null || request.getSession().getAttribute("username").equals("")){
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		
		return true;
	}

}

