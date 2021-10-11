package com.microservice.loja.estoque.entrypoint.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

public abstract class BaseMapperEntryPoint<E, D> {
	  public abstract E convertToDomain(D model, Object... args);

	   public abstract D convertToModel(E domain, Object... args);

	   public Collection<E> convertToDomain(Collection<D> models, Object... args) {
	        return 	models.stream().map(model -> convertToDomain(model, args)).collect(Collectors.toList());
	    }

	    public Collection<D> convertToModel(Collection<E> domains, Object... args) {
	        return domains.stream().map(domain -> convertToModel(domain, args)).collect(Collectors.toList());
	    }
	    
	    public List<E> convertToDomainList(Collection<D> models, Object... args) {
	        return convertToDomain(models, args).stream().collect(Collectors.toList());
	    }

	    public List<D> convertToModelList(Collection<E> domains, Object... args) {
	        return convertToModel(domains, args).stream().collect(Collectors.toList());
	    }
}