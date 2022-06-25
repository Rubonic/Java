package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Listing;
import com.codingdojo.models.User;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
	List<Listing> findAll();
	List<Listing> findByHostIs(User host);
	List<Listing> findByLocationContains(String phrase);
	Listing findByIdIs(Long id);
}
