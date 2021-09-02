package com.recipedrinkfinder.repository;

import java.util.List;

import com.recipedrinkfinder.entities.Drink;

public interface DrinkRepositoryCustom {
	
	public List<Drink> findByDrinkName(String drinkName);
	
	public List<Drink> findDrinkByIngredientsName(List<String> ingredients);
	
}
