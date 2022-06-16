package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Ninjas;
import com.codingdojo.services.DojosService;
import com.codingdojo.services.NinjasService;

@Controller
public class NinjasController 
{
	@Autowired
	private NinjasService ninjasService;
	
	@Autowired
	private DojosService dojosService;
	
	@GetMapping("/new")
	public String createFood(Model model)
	{
		model.addAttribute("nijas",new Ninjas());
		model.addAttribute("dojos",dojosService.findAll());
		return "ninjas";
	}
	
	@PostMapping("/new")
	public String insertNinjas(@Valid @ModelAttribute("ninjas") Ninjas ninjas, BindingResult res )
	{
		if(res.hasErrors())
		{
			return "ninjas";
		}
		ninjasService.create(ninjas);
		return "redirect:/ninjas/new";
	}
};