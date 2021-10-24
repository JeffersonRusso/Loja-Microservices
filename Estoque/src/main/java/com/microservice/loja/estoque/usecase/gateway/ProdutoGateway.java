package com.microservice.loja.estoque.usecase.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.microservice.loja.estoque.usecase.model.request.FilterUseCase;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public interface ProdutoGateway {
	
	Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest);
	
	Optional<List<ProdutoDomainResponse>> buscaProdutosVitrine(Pageable paging);
	
	Optional<List<ProdutoDomainResponse>> buscarProdutosPorIds(List<ProdutoDomainRequest> produtosDomainRequest);

	Optional<List<ProdutoDomainResponse>> filtrarProdutos(List<FilterUseCase> filters);
}
