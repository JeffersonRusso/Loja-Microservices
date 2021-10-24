package com.microservice.loja.estoque.usecase.model.request;

import java.util.List;

import com.microservice.loja.estoque.dataprovider.repository.filter.specification.QueryOperator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FilterUseCase {
	private String field;
	private String value;
	private List<String> values;
	private QueryOperator operator;
}
