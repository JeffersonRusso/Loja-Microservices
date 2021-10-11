package com.microservice.loja.estoque.entrypoint.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;

/**
 * Mapper que converte um EntryPointModel para um objeto UseCase
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 */

@Component
public class ProdutoEntryPointMapperRequest extends BaseMapperEntryPoint<ProdutoDomainRequest, ProdutoModelRequest> {
	
	@Override
	public ProdutoModelRequest convertToModel(ProdutoDomainRequest domain, Object... args) {
		ProdutoModelRequest model = new ProdutoModelRequest();
		if(domain != null) {
			BeanUtils.copyProperties(domain, model);
		}
		return model;
	}
	
	@Override
	public ProdutoDomainRequest convertToDomain(ProdutoModelRequest model, Object... args) {
		ProdutoDomainRequest domain = new ProdutoDomainRequest();
		if(model != null) {
			BeanUtils.copyProperties(model, domain);
		}
		return domain;
	}
}