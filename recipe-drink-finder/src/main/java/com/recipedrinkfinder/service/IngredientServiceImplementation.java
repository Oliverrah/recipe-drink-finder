package com.recipedrinkfinder.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipedrinkfinder.entities.Ingredient;
import com.recipedrinkfinder.repository.IngredientRepository;

@Service
public class IngredientServiceImplementation implements IngredientService{

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Override
	@Transactional
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient findById(Long id) {
		
		Optional<Ingredient> result = ingredientRepository.findById(id);
		
		Ingredient ingredient = null;
		
		if(result.isPresent()) {
			ingredient = result.get();
		}
		
		else {
			throw new NoSuchElementException("Did not found ingredient ID " + id);
		}
		
		return ingredient;
	}
	
	
	@Override
	public Ingredient save(Ingredient drink) {
		return ingredientRepository.save(drink);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		ingredientRepository.deleteById(id);	
	}
}
