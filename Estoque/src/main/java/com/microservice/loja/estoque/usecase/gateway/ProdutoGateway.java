package com.microservice.loja.estoque.usecase.gateway;

import java.util.List;
import java.util.Optional;

import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public interface ProdutoGateway {
	
	Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest);
	
	List<ProdutoDomainResponse> buscarTodosOsProdutos();
}
