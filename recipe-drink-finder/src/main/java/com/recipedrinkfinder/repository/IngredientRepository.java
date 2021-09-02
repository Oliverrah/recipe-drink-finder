package com.recipedrinkfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipedrinkfinder.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	
}
