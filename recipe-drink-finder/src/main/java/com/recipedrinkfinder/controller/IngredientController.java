package com.recipedrinkfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipedrinkfinder.entities.Ingredient;
import com.recipedrinkfinder.service.IngredientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(tags="Ingredient Endpoint")
@RestController
@RequestMapping("/api")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;
	
	@ApiOperation(value = "Find all ingredients recorded")
	@GetMapping("/ingredients")
	public List<Ingredient> findAll(){
		return ingredientService.findAll();
	}
	
	@ApiOperation(value = "Find a ingredient by ID")
	@GetMapping("/ingredients/{ingredientId}")
	public Ingredient findById(@PathVariable Long ingredientId) {
		
		Ingredient ingredient = ingredientService.findById(ingredientId);
		
		if(ingredient == null) {
			throw new RuntimeException("Não foi encontrado nenhum ingredient com esse ID");
		}
		
		return ingredient;
	}
	
	@ApiOperation(value = "Create a ingredient")
	@PostMapping(value= "/ingredients", produces ={"application/json"} ,consumes ={"application/json"} )
	public Ingredient create(@RequestBody Ingredient ingredient) {
		
		return ingredientService.save(ingredient);
	}
	
	@ApiOperation(value = "Update a ingredient")
	@PutMapping("/ingredients")
	public Ingredient update(@RequestBody Ingredient ingredient) {
		return ingredientService.save(ingredient);
	}
	
	@ApiOperation(value = "Delete a ingredient by ID")
	@DeleteMapping("/ingredients/{ingredientId}")
	public void delete(@PathVariable Long ingredientId) {
		 ingredientService.deleteById(ingredientId);
	}	
}
