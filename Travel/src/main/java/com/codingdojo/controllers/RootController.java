package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Travel;
import com.codingdojo.services.TravelService;


@Controller
@RequestMapping("/expenses")
public class RootController
{
	@Autowired
	private TravelService travelService;
	
	@GetMapping("")
	public String index(Model model)
	{
		System.out.println("Create Travel Form");
		model.addAttribute("travel",new Travel());
		return "index";
	}
	
	@PostMapping("")
	public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult res )
	{
		if(res.hasErrors())
		{
			return "index";
		}
		travelService.create(travel);
		return "redirect:/expenses";
	}
	
	@GetMapping("/show/{id}")
	public String show()
	{
		return "show";
	}
	
	@GetMapping("/edit/{id}")
	public String edit()
	{
		return "edit";
	}
};
