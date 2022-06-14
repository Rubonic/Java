package com.codingdojo;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController 
{
	@GetMapping("/omikuji")
	public String home() 
	{
		return "index";
	}
	
	@GetMapping("/omikuji/show")
	public String show(Model model,HttpSession session)
	{
		String number=(String)session.getAttribute("number");
		String city=(String)session.getAttribute("city");
		String name=(String)session.getAttribute("name");
		String hobby=(String)session.getAttribute("hobby");
		String thing=(String)session.getAttribute("thing");
		String nice=(String)session.getAttribute("nice");
		
		String omi="In" +number+ "years,you will live in" 
		 +city+ "with" + name+ "as your roommate," +hobby+
		 "for a living. The next time you see a" +thing+ 
		 ",you will have good luck. Also," +nice+ ".";
		
		model.addAttribute("omi",omi);
		
		return "show";
	}
	
	@PostMapping("/submit")
	public String process
	( 
		@RequestParam("number")String number, 
		@RequestParam("city")String city,
		@RequestParam("name")String name,
		@RequestParam("hobby")String hobby,
		@RequestParam("thing")String thing,
		@RequestParam("nice")String nice,
		HttpSession session
	)
	{
//		System.out.println("Number:"+number);
//		System.out.println("City:"+city);
//		System.out.println("Name:"+name);
//		System.out.println("Hobby:"+hobby);
//		System.out.println("Thing:"+thing);
//		System.out.println("Nice:"+nice);
		
		session.setAttribute("number",number);
		session.setAttribute("city",city);
		session.setAttribute("name",name);
		session.setAttribute("hobby",hobby);
		session.setAttribute("thing",thing);
		session.setAttribute("nice",nice);
		
		return "redirect:/omikuji/show";
	}
};
