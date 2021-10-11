package com.microservice.loja.estoque.dataprovider.filter.specification;

import lombok.Getter;

@Getter
public enum QueryOperator {
	EQUALS,
	NOT_EQUALS,
	GREATER_THAN,
	LESS_THAN,
	LIKE,
	IN
}
