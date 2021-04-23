package com.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private Double quantity;

    @Column(name="explanation")
    private String explanation;
  

	public Inventory() {

	}

	public Inventory(Long id, String name, Double quantity, String explanation) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.explanation = explanation;
	}

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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getExplanation() { return explanation; }
	
	public void setExplanation(String explanation) { this.explanation =
	  explanation; }
	 

}
