package com.recipedrinkfinder.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ingredients")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private String quantity;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="drink_ingredients", 
			   joinColumns =  @JoinColumn(name="ingredients_id"),
			   inverseJoinColumns =  @JoinColumn(name="drink_id"))
	@JsonIgnore
	private List<Drink> drinks;
	
	public Ingredient() {
		
	}

	public Ingredient(Long id, String name, String quantity, List<Drink> drinks) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.drinks = drinks;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}


	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", quantity=" + quantity + ", drinks=" + drinks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drinks == null) ? 0 : drinks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (drinks == null) {
			if (other.drinks != null)
				return false;
		} else if (!drinks.equals(other.drinks))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}