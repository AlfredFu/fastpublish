package me.wmn.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.wmn.util.GlobalConstants;

@Controller
public class LoginController {
	
	static private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Value("${admin.username}")
	private String adminUserName;
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Value("${visitor.username}")
	private String visitorUserName;
	
	@Value("${visitor.password}")
	private String visitorPassword;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(/*HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra*/){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal != null && !GlobalConstants.ANONYMOUS_USERNAME.equals(principal.toString())){//用户已经登录
			//request.getRequestDispatcher("/product/overview/29").forward(request, response);
			//response.sendRedirect("/product/overview/29");
			//return "forward:/product/overview/29?test=yes";
			return "redirect:/product/overview/29";
		}
//		String uname = "";
//		if(principal instanceof UserDetails){
//			uname = ((UserDetails)principal).getUsername();
//		}else{
//			uname = principal.toString();
//		}
//		System.out.println(uname);
		logger.info("user access login page");
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String doLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) throws IOException{
		String backUrl = request.getParameter("back_url");
		logger.info("User {} log in", username);
		if(backUrl != null && backUrl.length() > 0){
			return "redirect:" + backUrl;
		}
		return "redirect:/product/overview/29";
	}

}
