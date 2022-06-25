package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Listing;
import com.codingdojo.models.User;
import com.codingdojo.repositories.ListingRepository;

@Service
public class ListingService {
private final ListingRepository listingRepository;
	
	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}
	
	public List<Listing> allListings(){
		return listingRepository.findAll();
	}
	
	public List<Listing> findByUser(User user){
		return listingRepository.findByHostIs(user);
	}
	
	public List<Listing> findByLocation(String loc){
		return listingRepository.findByLocationContains(loc);
	}
	
	public Listing updateListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	public Listing addListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	public void deleteListing(Listing listing) {
		listingRepository.delete(listing);
	}
	
	public Listing findById(Long id) {
		Optional<Listing> optionalListing = listingRepository.findById(id);
		if(optionalListing.isPresent()) {
			return optionalListing.get();
		}else {
			return null;
		}
	}
}
