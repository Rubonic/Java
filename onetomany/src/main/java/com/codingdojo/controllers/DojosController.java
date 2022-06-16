package com.codingdojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Dojos;
import com.codingdojo.services.DojosService;
import com.codingdojo.services.NinjasService;

@Controller
public class DojosController 
{
	@Autowired
	private DojosService dojosService;
	
	@Autowired
	private NinjasService ninjasService;
	
//	@GetMapping("/{id}")
//	public String findDojosById(@PathVariable("id") Long id, Model model )
//	{
//		select * from dojos join ninjas on dojos.id=ninjas.dojos_id;
//		 model.addAttribute("dojos",dojosService.findById(id));
//		 return "dojos";
//	}

	@GetMapping("/new")
	public String createDojos( Model model )
	{
		model.addAttribute("dojos",new Dojos());
		return "dojos";
	}
	
	@PostMapping("/new")
	public String insertDojos( @Valid @ModelAttribute("dojos") Dojos dojos, BindingResult res )
	{
		if(res.hasErrors())
		{
			return "dojos";
		}
		dojosService.create(dojos);
		return "redirect:/dojos/new";
	}
};