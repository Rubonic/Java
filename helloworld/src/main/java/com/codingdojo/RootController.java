package com.codingdojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	@GetMapping("/")
	public String home() 
	{
		String content = "";
		for (int i=0; i < 10; i++) 
		{
			content += "<h1>Hello World "+i+"</h1>";
		}
		return content;
	}
	// /users?username=billy
	@GetMapping("/search")
	public String search( @RequestParam(value="username", required=false) String searchTerm)
	{
		return "<h1>You have searched for: "+searchTerm+"</h1>;
	}
	
	@GetMapping("/user/{user_id}")
	
};
