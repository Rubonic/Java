package com.codingdojo.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
public class Dojos 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Dojo Name must be between 1 to 255 characters!")
	private String name;
	

	@OneToMany(mappedBy="dojos", fetch = FetchType.LAZY)
    private List<Ninjas> ninjas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ninjas> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
	}

	public Dojos()
	{
		
	}
};