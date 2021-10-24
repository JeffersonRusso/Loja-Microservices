package com.microservice.loja.estoque.dataprovider.repository.filter.specification;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.model.request.FilterUseCase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CriteriaDynamicQuery {
	
	public Specification<ProdutoEntity> getSpecificationFromFilters(List<FilterUseCase> filter){
		Specification<ProdutoEntity> specification = 
		            where(createSpecification(filter.remove(0)));
		
		  for (FilterUseCase input : filter) {
		    specification = specification.and(createSpecification(input));
		  }  
		  return specification; 
		}
	
	private Specification<ProdutoEntity> createSpecification(FilterUseCase input) {
		switch (input.getOperator()) {

		case EQUALS:
			return (root, query, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get(input.getField()),
					castToRequiredType(
							root.get(input.getField()).getJavaType(), input.getValue()));

		case NOT_EQUALS:
			return (root, query, criteriaBuilder) -> 
			criteriaBuilder.notEqual(root.get(input.getField()),
					castToRequiredType(
							root.get(input.getField()).getJavaType(), input.getValue()));

		case GREATER_THAN:
			return (root, query, criteriaBuilder) -> 
			criteriaBuilder.gt(root.get(input.getField()),
					(Number) castToRequiredType(
							root.get(input.getField()).getJavaType(), input.getValue()));

		case LESS_THAN:
			return (root, query, criteriaBuilder) -> 
			criteriaBuilder.lt(root.get(input.getField()),
					(Number) castToRequiredType(
							root.get(input.getField()).getJavaType(), input.getValue()));

		case LIKE:
			return (root, query, criteriaBuilder) -> 
			criteriaBuilder.like(root.get(input.getField()),
					"%" + input.getValue() + "%");

		case IN:
			return (root, query, criteriaBuilder) ->
			criteriaBuilder.in(root.get(input.getField()))
					.value(castToRequiredType(
							root.get(input.getField()).getJavaType(), input.getValues()));

		default:
			throw new RuntimeException("Operation not supported yet");
		}
	}

	private Object castToRequiredType(Class fieldType, List<String> value) {
		List<Object> lists = new ArrayList();
		for (String s : value) {
			lists.add(castToRequiredType(fieldType, s));
		}
		return lists;
	}
	
	private Object castToRequiredType(Class fieldType, String value) {
		if (fieldType.isAssignableFrom(Double.class)) {
			return Double.valueOf(value);
		} else if (fieldType.isAssignableFrom(Integer.class)) {
			return Integer.valueOf(value);
		} else if (Enum.class.isAssignableFrom(fieldType)) {
			return Enum.valueOf(fieldType, value);
		}
		return null;
	}
}
