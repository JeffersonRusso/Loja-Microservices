package com.microservice.loja.estoque.entrypoint.mapper;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.microservice.loja.estoque.entrypoint.model.request.FilterModel;
import com.microservice.loja.estoque.usecase.model.request.FilterUseCase;

public class FilterEntryPointMapper {
	
	private FilterEntryPointMapper() { }
	
	static public List<FilterUseCase> convertFiltersToDomain(List<FilterModel> filtersModel) {
		List<FilterUseCase> listaFiltrosDomain = new LinkedList<>();
		
		BeanUtils.copyProperties(filtersModel, listaFiltrosDomain);
		
		return listaFiltrosDomain;
	}
}