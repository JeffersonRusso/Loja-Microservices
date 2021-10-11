package com.microservice.loja.estoque.entrypoint.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

/**
 * Mapper que converte um EntryPointModel para um objeto UseCase
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 */

@Component
public class ProdutoEntryPointMapperResponse extends BaseMapperEntryPoint<ProdutoDomainResponse, ProdutoModelResponse> {
	
	
	@Override
	public ProdutoModelResponse convertToModel(ProdutoDomainResponse domain, Object... args) {
		ProdutoModelResponse model = new ProdutoModelResponse();
		if(domain != null) {
			BeanUtils.copyProperties(domain, model);
		}
		return model;
	}
	
	@Override
	public ProdutoDomainResponse convertToDomain(ProdutoModelResponse model, Object... args) {
		ProdutoDomainResponse domain = new ProdutoDomainResponse();
		if(model != null) {
			BeanUtils.copyProperties(model, domain);
		}
		return domain;
	}
}