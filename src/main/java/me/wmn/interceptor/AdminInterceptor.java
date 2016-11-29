package me.wmn.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor  extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException{
		String username = (String)request.getSession().getAttribute("username");
		
		//Only admin could
		if(username == null || !"fredfu".equals(username)){
			request.getRequestDispatcher("/product/29").forward(request, response);
			return false;
		}
				
		return true;
	}
}
