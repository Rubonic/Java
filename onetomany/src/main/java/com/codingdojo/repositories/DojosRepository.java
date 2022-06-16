package com.codingdojo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Dojos;

@Repository
public interface DojosRepository extends CrudRepository<Dojos,Long>
{
	ArrayList<Dojos> findAll();
};
