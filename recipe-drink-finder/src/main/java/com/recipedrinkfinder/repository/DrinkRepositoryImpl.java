package com.recipedrinkfinder.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipedrinkfinder.entities.Drink;

@Repository
public class DrinkRepositoryImpl implements DrinkRepositoryCustom {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Drink> findByDrinkName(String drinkName) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Drink> query = currentSession.createQuery("from Drink where lower(name) like :theName", Drink.class);
		query.setParameter("theName", "%" + drinkName.toLowerCase() + "%");
		
		return query.getResultList();
	}

	@Override
	public List<Drink> findDrinkByIngredientsName(List<String> ingredients) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		NativeQuery<Drink> query = currentSession.createNativeQuery("select dr.id, dr.name, dr.description from drink as dr \r\n"
				+ "inner join drink_ingredients as di on dr.id = di.drink_id\r\n"
				+ "inner join ingredients as ing on ing.id = di.ingredients_id\r\n"
				+ "where ing.name in(:theIngredients)", Drink.class);
			
		query.setParameterList("theIngredients", ingredients);
			
		return query.getResultList();
	}

}
