package me.wmn.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublishController {
	
	@RequestMapping("/showpublish")
	public String showPublish(Map<String, Object> model){
		return "publish";
	}

}
