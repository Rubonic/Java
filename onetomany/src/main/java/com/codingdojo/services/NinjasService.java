package com.codingdojo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingdojo.models.Ninjas;
import com.codingdojo.repositories.NinjasRepository;

@Service
public class NinjasService 
{
	@Autowired
	private NinjasRepository ninjasRepository;

	public void create(Ninjas ninjas)
	{
		ninjasRepository.save(ninjas);
	}
	
	public Ninjas findById(Long id)
	{
		return ninjasRepository.findById(id).orElse(null);
	}
	
	public ArrayList<Ninjas> findAll()
	{
		return ninjasRepository.findAll();
	}
	
	public void update(Ninjas ninjas)
	{
		ninjasRepository.save(ninjas);
	}
	
	public void deleteById(Long id)
	{
		ninjasRepository.deleteById(id);
	}
};