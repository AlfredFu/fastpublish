package me.wmn.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Value("${admin.username}")
	private String adminUserName;
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Value("${visitor.username}")
	private String visitorUserName;
	
	@Value("${visitor.password}")
	private String visitorPassword;
	
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		String username = (String)request.getSession().getAttribute("username");
		if(username != null && !username.equals("")){
			return "redirect:/product/overview/29";
		}
		return "login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
		if((adminUserName.equals(username) && adminPassword.equals(password))
				|| (visitorUserName.equals(username) && visitorPassword.equals(password))
				){
			request.getSession().setAttribute("username", username);
			return "redirect:/product/29";
		}else{
			return "redirect:/login";
		}
	}
	
	@RequestMapping("logout")
	public String logOut(HttpServletRequest request){
		request.getSession().removeAttribute("username");
		return "redirect:/product/overview/29";
	}
	
}
