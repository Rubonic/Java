package com.codingdojo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingdojo.models.Travel;
import com.codingdojo.repositories.TravelRepository;

@Service
public class TravelService 
{
	@Autowired
	private TravelRepository travelRepository;
	
//	INSERT INTO TRAVEL() VALUES();
	public void create(Travel travel)
	{
		travelRepository.save(travel);
	}
	
//  update table movie(asdasd,asdasd,asdasd) values(asdasd,asdasdasd) where movie.id=movie.getId()
	public void update(Travel travel)
	{
		travelRepository.save(travel);
	}
	
//	SELECT * FROM TRAVEL;
	public ArrayList<Travel> findAll()
	{
		return (ArrayList<Travel>) travelRepository.findAll();
	}
	
//	SELECT * FROM TRAVEL WHERE TRAVEL.ID=?;
	public Travel findOne(Long id)
	{
		Optional<Travel> travel=travelRepository.findById(id);
		return travel.isPresent()?travel.get():null;
	}
	
	public void deleteOne(Long id)
	{
		travelRepository.deleteById(id);
	}
	
};