package com.microservice.loja.estoque.usecase.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

public interface ProdutoGateway {
	
	Optional<ProdutoDomainResponse> buscarProdutoPorId(ProdutoDomainRequest produtoDomainRequest);
	
	Optional<List<ProdutoDomainResponse>> buscaProdutosVitrine(Pageable paging);
	
	Optional<List<ProdutoDomainResponse>> buscarProdutosPorIds(List<ProdutoDomainRequest> produtosDomainRequest);
}
