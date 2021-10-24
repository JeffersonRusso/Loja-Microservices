package com.microservice.loja.estoque.entrypoint.model.request;

import java.util.List;

import com.microservice.loja.estoque.dataprovider.repository.filter.specification.QueryOperator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterModel {
	
	
	private String field;
	private String value;
	private List<String> values;
	private QueryOperator operator;
}
