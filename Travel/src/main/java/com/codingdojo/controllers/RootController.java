package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("travels",travelService.findAll());
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
//-----------------------DELETE ITEM-------------------------------------// 
	@PostMapping("/delete/{id}")
	public String deleteTravel( @PathVariable("id") Long travelId )
	{
		travelService.deleteOne(travelId);
		return "redirect:/expenses";
	}
//-----------------------SHOWING ITEM-------------------------------------// 
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long travelId, Model model)
	{
		model.addAttribute("travel",travelService.findOne(travelId));
		return "show";
	}
//-----------------------EDIT ITEM-------------------------------------// 
	@GetMapping("/edit/{id}")
	public String edit( @PathVariable("id") Long travelId, Model model)
	{
		model.addAttribute("travel",travelService.findOne(travelId));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update( @Valid @ModelAttribute("travel") Travel travel, BindingResult res )
	{
		if(res.hasErrors())
		{
			return "edit";
		}
		travelService.update(travel);
		return "redirect:/expenses";
	}
};
