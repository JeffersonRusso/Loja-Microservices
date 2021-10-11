package com.microservice.loja.estoque.dataprovider.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseMapperDataProvider<E, D> {
	
	  public abstract D convertToDomain(E entity, Object... args);

	  public Collection<D> convertToDomain(Collection<E> entities, Object... args) {
	       return entities.stream().map(domain -> convertToDomain(domain, args)).collect(Collectors.toList());
	  }
  
	  public List<D> convertToDomainList(Collection<E> entities, Object... args) {
	       return convertToDomain(entities, args).stream().collect(Collectors.toList());
	  }
}