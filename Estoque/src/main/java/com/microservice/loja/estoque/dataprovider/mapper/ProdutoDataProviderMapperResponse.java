package com.microservice.loja.estoque.dataprovider.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

@Component
public class ProdutoDataProviderMapperResponse extends BaseMapperDataProvider<ProdutoEntity, ProdutoDomainResponse> {

	@Override
	public ProdutoDomainResponse convertToDomain(ProdutoEntity entity, Object... args) {
		ProdutoDomainResponse domain = new ProdutoDomainResponse();
		if(entity != null) {
			BeanUtils.copyProperties(entity, domain);
		}
		return domain;
	}
}