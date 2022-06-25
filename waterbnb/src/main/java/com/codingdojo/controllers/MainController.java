package com.codingdojo.controllers;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.models.Listing;
import com.codingdojo.models.LoginUser;
import com.codingdojo.models.Review;
import com.codingdojo.models.User;
import com.codingdojo.services.ListingService;
import com.codingdojo.services.ReviewService;
import com.codingdojo.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ListingService listingService;
	
	@Autowired
	private ReviewService reviewService;
	
	private int[] numbers = {0,1,2,3,4,5};
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("users", userService.allUsers());
		model.addAttribute("listings", listingService.allListings());
	    return "index";
	}
	
	@PostMapping("/")
	public String searchListings(@RequestParam(value="locationSearch") String locationSearch, Model model) {
		model.addAttribute("users", userService.allUsers());
		model.addAttribute("listings", listingService.allListings());
		model.addAttribute("searchResults", listingService.findByLocation(locationSearch));
	    return "index";
	}
	
	@GetMapping("/account")
	public String accountPage(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "login";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {

		User user = userService.register(newUser, result);
	     
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "login";
	    }
	    session.setAttribute("userId", user.getId());
	    
	    if(user.getHost()) {
	    	return "redirect:/host/dashboard";
	    }
	    
	    return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "login";
	    }
	     
	    session.setAttribute("userId", user.getId());
	    
	    if(user.getHost()) {
	    	return "redirect:/host/dashboard";
	    }
	    
	    return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/";
	}
	
	@GetMapping("/host/dashboard")
	public String listings(@ModelAttribute("listing") Listing listing, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("listings", listingService.findByUser(userService.findById(userId)));
		return "host_dashboard";
	}
	
	@PostMapping("/host/dashboard")
	public String addListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		if(result.hasErrors()) {
			return "host_dashboard";
		}else {
			Listing newListing = new Listing(listing.getLocation(), listing.getDescription(), listing.getPrice(), listing.getSize());
			newListing.setHost(userService.findById(userId));
			listingService.addListing(newListing);
			return "redirect:/host/dashboard";
		}
	}
	
	@GetMapping("/reviews/{id}")
	public String activity(@PathVariable("id") Long id, Model model) {
		Listing listing = listingService.findById(id);
		model.addAttribute("reviews", reviewService.findByLocation(listing));
		return "reviews_frame";
	}
	
	@GetMapping("/host/pools/{id}")
	public String viewListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("listing", listingService.findById(id));
		return "edit_listing";
	}
	
	@PostMapping("/host/pools/{id}")
	public String editPool(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("listing") Listing listing, 
			BindingResult result, 
			HttpSession session,
			Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findById(userId);
		model.addAttribute("user", user);
		
		if(result.hasErrors()) {
			System.out.println("errors = "+result.getErrorCount());
			return "edit_listing";
		}else {
			listing.setHost(user);
			listingService.updateListing(listing);
			return "redirect:/host/dashboard";
		}
	}
	
	@RequestMapping("/host/pools/delete/{id}")
	public String deleteListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		listingService.deleteListing(listingService.findById(id));
		return "redirect:/";
	}
	
	@GetMapping("/pools/{id}")
	public String showListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") != null) {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("user", userService.findById(userId));
		}
		
		model.addAttribute("listing", listingService.findById(id));
		return "listing_details";
	}
	
	@GetMapping("/pools/{id}/review")
	public String leaveReview(@PathVariable("id") Long id, @ModelAttribute("review") Review review, HttpSession session, Model model) {
		model.addAttribute("listing", listingService.findById(id));
		model.addAttribute("nums", numbers);
		return "new_review";
	}
	
	@PostMapping("/pools/{id}/review")
	public String leaveReview(@PathVariable("id") Long id, 
			@Valid @ModelAttribute("review") Review review, 
			BindingResult result, 
			HttpSession session, 
			Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findById(userId);
		
		if(result.hasErrors()) {
			model.addAttribute("listing", listingService.findById(id));
			model.addAttribute("nums", numbers);
			return "new_review";
		}else {
			Listing listing = listingService.findById(id);
			reviewService.addReview(new Review(review.getText(), review.getRating(), user, listing));
			Float newRating = 0f;
			int count = 0;
			for(Review r:reviewService.findByLocation(listing)) {
				newRating += r.getRating();
				count++;
			}
			listing.setRating(newRating/count);
			listingService.updateListing(listing);
			return "redirect:/pools/"+id;
		}
	}
}
