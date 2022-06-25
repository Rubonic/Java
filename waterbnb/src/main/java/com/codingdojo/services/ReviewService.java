package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Listing;
import com.codingdojo.models.Review;
import com.codingdojo.repositories.ReviewRepository;

@Service
public class ReviewService {
private final ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public List<Review> allReviews(){
		return reviewRepository.findAll();
	}
	
	public List<Review> findByLocation(Listing listing){
		return reviewRepository.findByListingIs(listing);
	}
	
	public Review updateReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public void deleteReview(Review review) {
		reviewRepository.delete(review);
	}
	
	public Review findById(Long id) {
		Optional<Review> optionalReview = reviewRepository.findById(id);
		if(optionalReview.isPresent()) {
			return optionalReview.get();
		}else {
			return null;
		}
	}
}