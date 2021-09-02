package com.recipedrinkfinder.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.recipedrinkfinder.entities.Drink;
import com.recipedrinkfinder.repository.DrinkRepository;

@Service
public class DrinkServiceImplementation implements DrinkService{

	@Autowired
	DrinkRepository drinkRepository;
	
	
	@Override
	public List<Drink> findAll(Pageable pageable) {
		return drinkRepository.findAll(pageable).getContent();
	}

	@Override
	public Drink findById(Long id) {
		Optional<Drink> result = drinkRepository.findById(id);
		
		Drink drink = null;
		
		
		if(result.isPresent()) {
			drink = result.get();
		}
		else {
			throw new NoSuchElementException("Did not found drink ID " + id);
		}
		
		return drink;
	}
	
	@Override
	public Drink save(Drink drink) {
		return drinkRepository.save(drink);
	}
	@Override
	public void deleteById(Long id) {
		drinkRepository.deleteById(id);	
	}


	@Override
	public List<Drink> findByDrinkName(String drinkName) {
		return drinkRepository.findByDrinkName(drinkName);
		
	}


	@Override
	public List<Drink> findDrinkByIngredientsName(List<String> ingredients) {
		return drinkRepository.findDrinkByIngredientsName(ingredients);
	}

}
