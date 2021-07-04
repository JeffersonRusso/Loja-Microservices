package com.microservice.loja.estoque.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.microservice.loja.estoque.usecase.gateway.ProdutoGateway;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public class ProdutoUseCase {
	
	private ProdutoGateway produtoGateway;
	
	@Autowired
	public ProdutoUseCase(ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public Optional<ProdutoDomainResponse> buscarProdutoPorId(
			final ProdutoDomainRequest produtoDomainRequest) {
		return this.produtoGateway.buscarProdutoPorId(produtoDomainRequest);
	}
}