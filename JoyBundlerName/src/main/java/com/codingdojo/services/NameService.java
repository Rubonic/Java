package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.NameJoy;
import com.codingdojo.repositories.NameRepository;

@Service
public class NameService {
	
	@Autowired
	NameRepository nameRepo;
//------------------------------SHOW ALL-----------------------------------------//
	public List<NameJoy> allNames() {
		return nameRepo.findAll();
	}
//------------------------------ADD-----------------------------------------//
	public NameJoy addName(NameJoy name) {
		return nameRepo.save(name);
	}
//------------------------------FIND ONE-----------------------------------------//
	public NameJoy findOneName(Long id) {
		Optional<NameJoy>optionalName = nameRepo.findById(id);
		if(optionalName.isPresent()) {
			return optionalName.get();
		}else {
			return null;
		}
	}
//------------------------------DELETE-----------------------------------------//
	public void deleteName(Long id) {
		nameRepo.deleteById(id);
	}
//------------------------------EDIT-----------------------------------------//
	public NameJoy editName(NameJoy name) {
		return nameRepo.save(name);
	}
}
