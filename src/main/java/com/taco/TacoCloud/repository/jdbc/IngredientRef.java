package com.taco.TacoCloud.repository.jdbc;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class IngredientRef {
	private final String ingredient;

}
