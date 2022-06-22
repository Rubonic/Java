package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.NameJoy;

@Repository
public interface NameRepository extends CrudRepository<NameJoy, Long>{
	List<NameJoy> findAll();
}

