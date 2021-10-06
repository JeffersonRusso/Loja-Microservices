package com.microservice.loja.usuario.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseMapper<E, D> {

    public abstract E convertToDomain(D dto, Object... args);

   
    public Collection<E> convertToEntity(Collection<D> dto, Object... args) {
        return dto.stream().map(d -> convertToDomain(d, args)).collect(Collectors.toList());
    }

    public List<E> convertToEntityList(Collection<D> dto, Object... args) {
        return convertToEntity(dto, args).stream().collect(Collectors.toList());
    }

    public Set<E> convertToEntitySet(Collection<D> dto, Object... args) {
        return convertToEntity(dto, args).stream().collect(Collectors.toSet());
    }
    
    

}