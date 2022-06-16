package com.codingdojo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.models.Ninjas;

@Repository
public interface NinjasRepository extends CrudRepository<Ninjas,Long>
{
	ArrayList<Ninjas> findAll();
};
