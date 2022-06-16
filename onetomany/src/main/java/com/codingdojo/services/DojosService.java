package com.codingdojo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojos;
import com.codingdojo.repositories.DojosRepository;

@Service
public class DojosService 
{
	@Autowired
	private DojosRepository dojosRepository;
	
	public void create(Dojos dojos)
	{
		dojosRepository.save(dojos);
	}
	
	public Dojos findById(Long id)
	{
		return dojosRepository.findById(id).orElse(null);
	}
	
	public ArrayList<Dojos> findAll()
	{
		return dojosRepository.findAll();
	}
	
	public void update(Dojos dojos)
	{
		dojosRepository.save(dojos);
	}
	
	public void deleteById(Long id)
	{
		dojosRepository.deleteById(id);
	}
};