package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Ninjas 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1,max=255,message="Ninja Name must be between 1 to 255 characters!")
	private String firstName;
	
	@Size(min=1,max=255,message="Ninja Name must be between 1 to 255 characters!")
	private String lastName;
	
	@Min(value=5,message="Ninja must be at least 5 years old!")
	@Max(value=60,message="Ninja cannot be older than 60 years old!")
	private Integer age;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojos_id")
	private Dojos dojos;
	
	
	public Ninjas()
	{
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Dojos getDojos() {
		return dojos;
	}


	public void setDojos(Dojos dojos) {
		this.dojos = dojos;
	}
};