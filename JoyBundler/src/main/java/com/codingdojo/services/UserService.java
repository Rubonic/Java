package com.codingdojo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		// 1. check email (present --> reject)
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "The email already exists");
		}
		
		// 2. check password != confirm --> reject
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "matches", "The password and confirm password do not match");

		}
		
		// 3. if result has errors --> leave the method without saving
		if(result.hasErrors()) {
			return null;
		}
        // 4. Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}

	public User login(LoginUser newLogin, BindingResult result) {
    	// 1. Find user in the DB by email
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
        // 2. if email NOT present, reject & return
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "Unknown email");		
			return null;
		}
		
        // 3. get user from db
		User user = potentialUser.get();
		
        // 4. if BCrypt password match fails, reject
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
		    result.rejectValue("password", "Matches", "Invalid Password!");
		}
		// 5. if result has errors --> leave the method without saving
		if(result.hasErrors()) {
			return null;
		}		
		// 6. no error, return user
		return user;
	}
	
	// find one user
	public User findOneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	
	
}
