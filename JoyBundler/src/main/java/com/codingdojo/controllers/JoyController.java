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

import com.codingdojo.models.Joy;
import com.codingdojo.models.User;
import com.codingdojo.services.JoyService;
import com.codingdojo.services.UserService;

@Controller
public class JoyController {
	
	@Autowired
	private JoyService joyService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		// get user
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findOneUser(userId);
		// get the list of project
		List<Joy> joys = joyService.allJoys();
		
		
		// put the variable into jsp
		model.addAttribute("user", user);
		model.addAttribute("joys", joys);
		
		return "home";
		
	}
	
	
	// create ---- render the form, process form
	@GetMapping("/names/new")
	public String newProject(@ModelAttribute("joy") Joy joy) {
		return "newNames";
	}
	
	// process form
	@PostMapping("/names/new")
	public String processCreate(@Valid @ModelAttribute("joy") Joy joy, BindingResult result) {
		if(result.hasErrors()) {
			return "newNames";
		}else {
			joyService.createJoy(joy);
			return "redirect:/name";
		}
	}
	
	// edit
	@GetMapping("/names/{id}/edit")
	public String editForm(@PathVariable("id")Long id, Model model) {
		Joy joy = joyService.findOneJoy(id);
		model.addAttribute("joy", joy);
		return "editNames";
	}
	
	@PutMapping("/names/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("joy") Joy joy, BindingResult result) {
		if(result.hasErrors()) {
			return "editNames";
		}else {
			joyService.updateJoy(joy);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/names/{id}")
	public String oneJoy(@PathVariable("id")Long id, Model model) {
		model.addAttribute("joy", joyService.findOneJoy(id));
		return "oneName";
	}
	
	@DeleteMapping("/names/{id}/delete")
	public String deleteJoy(@PathVariable("id")Long id) {
		joyService.deleteJoy(id);
		return "redirect:/home";
	}
	
	

}
