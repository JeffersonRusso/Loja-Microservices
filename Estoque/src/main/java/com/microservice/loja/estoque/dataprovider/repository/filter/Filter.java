package com.microservice.loja.estoque.dataprovider.repository.filter;

import java.util.List;

import com.microservice.loja.estoque.dataprovider.repository.filter.specification.QueryOperator;

import lombok.Getter;

@Getter
public class Filter {
	private String field;
	private String value;
	private List<String> values;
	private QueryOperator operator;
}
