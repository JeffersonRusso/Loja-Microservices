package com.microservice.loja.estoque.dataprovider;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.microservice.loja.estoque.dataprovider.mapper.ProdutoDataProviderMapperResponse;
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
	private final ProdutoDataProviderMapperResponse responseMapper;
	
	@Autowired
	public ProdutoDataProvider(
			ProdutoRepository produtoRepository,
			ProdutoDataProviderMapperResponse responseMapper) {
		this.produtoRepository = produtoRepository;
		this.responseMapper = responseMapper;
	}
	
	@Override
	public Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest) {
		
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findByIdProduto(produtoDomainRequest.getIdProduto());
		
		return produtoEntity.isPresent() 
				? Optional.of(responseMapper.convertToDomain(produtoEntity.get())) 
				: Optional.empty(); 
	}

	@Override
	public Optional<List<ProdutoDomainResponse>> buscaProdutosVitrine(Pageable paging) {

		Page<ProdutoEntity> pagedResult = produtoRepository.findAll(paging);

		if(!pagedResult.hasContent()) 
            return Optional.empty();
		
		List<ProdutoDomainResponse> produtosDomainResponse = pagedResult.stream().map(responseMapper::convertToDomain).collect(Collectors.toList());
		
		return !produtosDomainResponse.isEmpty() 
				? Optional.of(produtosDomainResponse)  
				: Optional.empty(); 
	}
	
	public Optional<List<ProdutoDomainResponse>> buscarVariosProdutosPorIds(List<ProdutoDomainRequest> produtosDomainRequest) {
		
		List<String> idsProdutos = produtosDomainRequest.stream().map(ProdutoDomainRequest::getIdProduto).collect(Collectors.toList());
		
		List<ProdutoDomainResponse> produtosDomainResponse = produtoRepository.findByIds(idsProdutos).stream().map(responseMapper::convertToDomain).collect(Collectors.toList());
		
		return !produtosDomainResponse.isEmpty() 
				? Optional.of(produtosDomainResponse) 
				: Optional.empty(); 
	}
	
	public Optional<List<ProdutoDomainResponse>> filtrarProdutos(Specification<ProdutoDomainRequest> especProdutoDomainRequest){
		return null;
	}
}