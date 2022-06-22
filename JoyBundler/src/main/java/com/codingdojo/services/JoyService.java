package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Joy;
import com.codingdojo.repositories.JoyRepository;

@Service
public class JoyService {
	@Autowired
	private JoyRepository joyRepo;
	
	// all projects
	public List<Joy> allJoys(){
		return joyRepo.findAll();
	}
	
	// find one project
	public Joy findOneJoy(Long id) {
		Optional<Joy> optionalJoy = joyRepo.findById(id);
		if(optionalJoy.isPresent()) {
			return optionalJoy.get();
		}else {
			return null;
		}
	}
	
	// create project
	public Joy createJoy(Joy joy) {
		return joyRepo.save(joy);
	}

	// update project
	public Joy updateJoy(Joy joy) {
		return joyRepo.save(joy);
	}
	
	
	// delete project
	public void deleteJoy(Long id) {
		joyRepo.deleteById(id);
	}
	
	
}
