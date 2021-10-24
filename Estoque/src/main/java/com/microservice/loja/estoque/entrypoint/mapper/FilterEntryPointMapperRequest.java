package com.microservice.loja.estoque.entrypoint.mapper;

import org.springframework.beans.BeanUtils;

import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;

public class FilterEntryPointMapperRequest extends BaseMapperEntryPoint<ProdutoDomainRequest, ProdutoModelRequest> {
	
	@Override
	public ProdutoDomainRequest convertToDomain(ProdutoModelRequest model, Object... args) {
		ProdutoDomainRequest domain = new ProdutoDomainRequest();
		if(model != null) {
			BeanUtils.copyProperties(model, domain);
		}
		return domain;
	}

	@Override
	public ProdutoModelRequest convertToModel(ProdutoDomainRequest domain, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}
}
