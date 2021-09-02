package com.recipedrinkfinder.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.recipedrinkfinder.entities.Drink;

public interface DrinkService {
	public List<Drink> findAll(Pageable pageable);
	public Drink findById(Long id);
	public List<Drink> findByDrinkName(String drinkName);
	public List<Drink> findDrinkByIngredientsName(List<String> ingredients);
	public Drink save(Drink drink);
	public void deleteById(Long id);
}
