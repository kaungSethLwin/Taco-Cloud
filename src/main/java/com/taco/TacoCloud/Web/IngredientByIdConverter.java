package com.taco.TacoCloud.Web;




import org.springframework.stereotype.Component;

import com.taco.TacoCloud.Ingredient;

import org.springframework.core.convert.converter.Converter;

import com.taco.TacoCloud.repository.jdbc.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
	
	private IngredientRepository ingredientRepo;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	
	@Override
	public Ingredient convert (String id){
		return ingredientRepo.findById(id).orElse(null);
	}

}
