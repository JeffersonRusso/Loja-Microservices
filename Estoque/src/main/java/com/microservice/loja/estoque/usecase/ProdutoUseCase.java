package com.microservice.loja.estoque.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.usecase.gateway.ProdutoGateway;
import com.microservice.loja.estoque.usecase.model.request.FilterUseCase;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

@Component
public class ProdutoUseCase {
	
	private ProdutoGateway produtoGateway;
	
	@Autowired
	public ProdutoUseCase(final ProdutoGateway produtoGateway) {
		this.produtoGateway = produtoGateway;
	}
	
	public Optional<ProdutoDomainResponse> buscarProdutoPorId(
			final ProdutoDomainRequest produtoDomainRequest) {
		return this.produtoGateway.buscarProdutoPorId(produtoDomainRequest);
	}
	
	public Optional<List<ProdutoDomainResponse>> buscaProdutosVitrine(
			Integer pageNo,
			Integer pageSize,
			String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		return this.produtoGateway.buscaProdutosVitrine(paging);
	}
	
	public Optional<List<ProdutoDomainResponse>> buscarProdutosPorIds(List<ProdutoDomainRequest> produtosDomainRequest) {
		return this.produtoGateway.buscarProdutosPorIds(produtosDomainRequest);
	}
	
	public Optional<List<ProdutoDomainResponse>> filtrarProdutos(List<FilterUseCase> filters) {
		return this.produtoGateway.filtrarProdutos(filters);
	}
}