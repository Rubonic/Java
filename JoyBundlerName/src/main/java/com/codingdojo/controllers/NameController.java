package com.codingdojo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.models.NameJoy;
import com.codingdojo.services.NameService;

@Controller
public class NameController {
	
	@Autowired
	private NameService nameService;
	
	@GetMapping("/names")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		List<NameJoy> names = nameService.allNames();
		model.addAttribute("names", names);		
		return "dashboard";
	}
//------------------------------ADD-----------------------------------------//
	@GetMapping("/names/add")
	public String addName(@ModelAttribute("namejoy")NameJoy name, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "addName";
	}
	
	@PostMapping("/names/add")
	public String processAddName(@Valid @ModelAttribute("namejoy")NameJoy name, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addName";
		}else {
			nameService.addName(name);
			return "redirect:/names";
		}
	}
//------------------------------SHOW-----------------------------------------//
	@GetMapping("names/{id}")
	public String showOneName(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		NameJoy name = nameService.findOneName(id);
		model.addAttribute("namejoy", name);
		return "showName";
	}
//------------------------------DELETE-----------------------------------------//
	@DeleteMapping("/names/{id}/delete")
	public String processDelete(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		nameService.deleteName(id);
		return "redirect:/names";
	}
//------------------------------EDIT-----------------------------------------//
	@GetMapping("/names/{id}/edit")
	public String editName(@PathVariable("id")Long id, HttpSession session, Model model) {
		NameJoy name = nameService.findOneName(id);
		Long userId = (Long) session.getAttribute("userId");
		if(!name.getCreator().getId().equals(userId)) {
			return "redirect:/names";
		}
		model.addAttribute("namejoy", name);
		return "editName";
	}
	
	@PutMapping("/names/{id}/edit")
	public String processEditName(@Valid @ModelAttribute("namejoy")NameJoy name, 
			BindingResult result, HttpSession session){
		Long userId = (Long) session.getAttribute("userId");
		if(!name.getCreator().getId().equals(userId)) {
			return "redirect:/names";
		}
		if(result.hasErrors()) {
			return "editName";
		}else {
			nameService.editName(name);
			return "redirect:/names";
		}
	}
}
