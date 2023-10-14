package com.taco.TacoCloud.repository.jdbc;


import org.springframework.data.repository.CrudRepository;

import com.taco.TacoCloud.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String>{

	
}
