package com.recipedrinkfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipedrinkfinder.entities.Drink;
import com.recipedrinkfinder.exceptions.DrinkNotFoundException;
import com.recipedrinkfinder.service.DrinkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags = "Drink Endpoint")
@RestController
@RequestMapping("/api")
public class DrinkController {

	@Autowired
	DrinkService drinkService;
	
	@ApiOperation(value = "Find all drinks recorded")
	@GetMapping("/drinks")
	public List<Drink> findAll(@RequestParam(value="page", defaultValue = "0") int page,
							   @RequestParam(value="limit", defaultValue = "12") int limit,
							   @RequestParam(value="direction", defaultValue = "ASC") String direction){
		
		Direction orderDirection;
		
		if("DESC".equalsIgnoreCase(direction)) {
			orderDirection = Direction.DESC;
		}
		else if("ASC".equalsIgnoreCase(direction)) {
			orderDirection = Direction.ASC;
		}
		
		else {
			throw new RuntimeException("Invalid direction " + direction);
		}
				
		Pageable pageable = PageRequest.of(page, limit, Sort.by(orderDirection, "name"));
		
		return drinkService.findAll(pageable);
	}
	
	@ApiOperation(value = "Find a drink recipe by ID")
	@GetMapping("/drinks/{drinkId}")
	public Drink findById(@PathVariable Long drinkId) {
		
		Drink drink = drinkService.findById(drinkId);
		
		if(drink == null) {
			throw new DrinkNotFoundException("Não foi encontrado nenhum drink com esse ID - " + drinkId);
		}
		
		return drink;
	}
	
	@ApiOperation(value = "Find a drink recipe by name")
	@GetMapping("/drinks/search")
	public List<Drink> findByName(@RequestParam("drinkName") String drinkName){
		
		List<Drink> drinks = drinkService.findByDrinkName(drinkName);
		
		if(drinks.isEmpty()) {
			throw new DrinkNotFoundException("Não foi encontrado nenhum drink com esse nome - " + drinkName);
		}
		
		return drinks;	
	}
	
	@ApiOperation(value = "Find a drink recipe by one or more ingredients name")
	@GetMapping("/drinks/search-by-ingredients")
	public List<Drink> findByIngredients(@RequestParam("ingredientName") List<String> ingredientsName){
					
		return drinkService.findDrinkByIngredientsName(ingredientsName);
	}
	
	@ApiOperation(value = "Create a new drink recipe")
	@PostMapping(value= "/drinks", produces ={"application/json"} ,consumes ={"application/json"} )
	public Drink create(@RequestBody Drink drink) {
		
		return drinkService.save(drink);
	}
	
	@ApiOperation(value = "Update a drink recipe")
	@PutMapping("/drinks")
	public Drink update(@RequestBody Drink drink) {
		return drinkService.save(drink);
	}
	
	@ApiOperation(value = "Delete a drink recipe by ID")
	@DeleteMapping("/drinks/{drinkId}")
	public void delete(@PathVariable Long drinkId) {
		 drinkService.deleteById(drinkId);
	}	
}