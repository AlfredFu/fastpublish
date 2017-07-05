package me.wmn.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		
		System.out.println("=====FASTPUBLISH=====管理员 " + userDetails.getUsername() + "登录");
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
