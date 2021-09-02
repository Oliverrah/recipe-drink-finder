package com.recipedrinkfinder.service;

import java.util.List;

import com.recipedrinkfinder.entities.Ingredient;

public interface IngredientService {

	public List<Ingredient> findAll();
	public Ingredient findById(Long id);
	public Ingredient save(Ingredient drink);
	public void deleteById(Long id);

}
