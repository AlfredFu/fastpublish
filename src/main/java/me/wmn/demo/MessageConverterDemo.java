package me.wmn.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import me.wmn.domain.User;

@Controller
@RequestMapping("/demo")
@SessionAttributes("user")
public class MessageConverterDemo {
	
	@RequestMapping("/requestbody")
	public void handler41(@RequestBody String requestBody, HttpServletResponse response){
		System.out.println("---------Request body begin-------------");
		System.out.println(requestBody);
		System.out.println("---------Request body end-------------");
		try {
			response.getWriter().println(requestBody);
			response.getWriter().println("Hahaha...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("/handle42/{imageId}")
	public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException{
		System.out.println("load image of  " + imageId);
		Resource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return fileData;
	}
	
	@RequestMapping("/handle51")
	public ResponseEntity<User> handle51(HttpEntity<User> requestEntity){
		User user = requestEntity.getBody();
		user.setId(1000);
		return new ResponseEntity<User>(user, HttpStatus.OK	);
	}
	
	
	@RequestMapping("test")
	public String test(@ModelAttribute("user") User user, @RequestParam("id") String id){
		return "test";
	}
	
}
