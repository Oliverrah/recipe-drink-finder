package com.recipedrinkfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipedrinkfinder.entities.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long>, DrinkRepositoryCustom {


}
