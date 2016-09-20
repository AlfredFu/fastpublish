package me.wmn.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	
	private int id;
	
	@NotEmpty(message="{product.name.notempty}")
	@Length(min=3, max=10)
	private String name;
	
	@Length(min=10, max=1024)
	private String description;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}