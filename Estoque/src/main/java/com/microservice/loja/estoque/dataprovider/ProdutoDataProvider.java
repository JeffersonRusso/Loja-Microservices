package com.microservice.loja.estoque.dataprovider;

import static com.microservice.loja.estoque.dataprovider.mapper.ProdutoDataProviderDomainMapper.toProdutoDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.loja.estoque.dataprovider.repository.ProdutoRepository;
import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.gateway.ProdutoGateway;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public class ProdutoDataProvider implements ProdutoGateway {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoDataProvider(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest) {
		
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(produtoDomainRequest.getIdProduto());
		
		return produtoEntity.isPresent() ? Optional.empty() : Optional.of(toProdutoDomain(produtoEntity.get()));
	}

	@Override
	public Optional<List<ProdutoDomainResponse>> buscarTodosOsProdutos() {
		
		final List<ProdutoDomainResponse> listaProdutoDomainResponse = new ArrayList<>();
		
		produtoRepository.findAll().stream()
			.map(produtoEntity -> listaProdutoDomainResponse.add(toProdutoDomain(produtoEntity)));
		
		return Optional.ofNullable(listaProdutoDomainResponse);
	}
}