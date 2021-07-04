package com.microservice.loja.estoque.dataprovider.mapper;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public class ProdutoDataProviderDomainMapper {
	
	public static ProdutoDomainResponse toProdutoDomain(ProdutoEntity produtoEntity) {
		return ProdutoDomainResponse.builder()
				.idProduto(produtoEntity.getIdProduto())
				.nome(produtoEntity.getNome())
				.preco(produtoEntity.getPreco())
				.imagem(produtoEntity.getImagem())
				.build();
	}
}