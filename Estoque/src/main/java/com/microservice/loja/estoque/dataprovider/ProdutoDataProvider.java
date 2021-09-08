package com.microservice.loja.estoque.dataprovider;

import static com.microservice.loja.estoque.dataprovider.mapper.ProdutoDataProviderDomainMapper.toProdutoDomain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.dataprovider.repository.ProdutoRepository;
import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.gateway.ProdutoGateway;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

@Component
public class ProdutoDataProvider implements ProdutoGateway {
	
	/**
	 * @author Jefferson Russo
	 * @since 30/07/2021
	 * 
	 * Classe que trabalha junto ao repositorio, é uma abstração para o repositorio
	 * todo acesso a dados partem dessa classe
	 * classe que consulta o repositorio de PRODUTOS
	 */

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoDataProvider(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest) {
		
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(produtoDomainRequest.getIdProduto());
		
		return produtoEntity.isPresent() ? Optional.of(toProdutoDomain(produtoEntity.get())) : Optional.empty(); 
	}

	@Override
	public Optional<List<ProdutoDomainResponse>> buscaProdutosVitrine(Pageable paging) {

		Page<ProdutoEntity> pagedResult = produtoRepository.findAll(paging);
		
		if(!pagedResult.hasContent()) 
            return Optional.empty();
		
		List<ProdutoDomainResponse> produtosDomainResponse = pagedResult.stream().map(produtoEntity -> toProdutoDomain(produtoEntity)).collect(Collectors.toList());
		
		return !produtosDomainResponse.isEmpty() ? Optional.of(produtosDomainResponse)  : Optional.empty(); 
	}
	
	public Optional<List<ProdutoDomainResponse>> buscarVariosProdutosPorIds(List<ProdutoDomainRequest> produtosDomainRequest) {
		
		List<Integer> idsProdutos = produtosDomainRequest.stream().map(produto -> produto.getIdProduto()).collect(Collectors.toList());
		
		List<ProdutoDomainResponse> produtosDomainResponse = produtoRepository.findByIds(idsProdutos).stream().map(produtoEntity -> toProdutoDomain(produtoEntity)).collect(Collectors.toList());
		
		return !produtosDomainResponse.isEmpty() ? Optional.of(produtosDomainResponse)  : Optional.empty(); 
	}
}