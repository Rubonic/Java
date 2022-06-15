package com.codingdojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Travel 
{
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Item is required")
	@Size(min=2,max=20,message="Expense Item must be between 2-20 characters.")
	private String expense;
	
	@NotNull(message="Item is required")
	@Size(min=2,max=20,message="Vendor must be between 2-20 characters.")
	private String vendor;
	
	@NotNull(message="Price is required")
	private Integer amount;
	
	@NotNull(message="Description is required")
	@Size(min=1,max=200,message="Description must be between 1 -200 characters!")
	private String description;
	
	public Travel()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
};