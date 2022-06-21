package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.models.LogInUser;
import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepo;
	
	public List<User> getAllUsers(){
		return uRepo.findAll();
	}
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> probableUser = uRepo.findByEmail(newUser.getEmail());

		if(probableUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		
		 if(!newUser.getPassword().equals(newUser.getConfirm())) {
		 result.rejectValue("confirm", "Matches", "Passwords must match"); }
		
		 if(result.hasErrors()) { 
			 System.out.println("error"); 
			 return null;
		 }
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		User saveUser = uRepo.save(newUser);
		System.out.println(saveUser);
		return saveUser;
	}
	
	public User login(LogInUser newLogin, BindingResult result) {
		
		Optional<User> potentialUser = uRepo.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email cannot be found");
		}
		
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Password is Invalid");
		}

		if(result.hasErrors()) {
			return null;
		}

		return user;
	}
	
	public User findById(Long id) {
		Optional<User> potentialUser = uRepo.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		}
		System.out.println("From UserService: User not found");
		return null;
	}
}