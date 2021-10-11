package com.microservice.loja.estoque.entrypoint.model.request;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
public class Filter {
	private String field;
	private String value;
	private List<String> values;
}
