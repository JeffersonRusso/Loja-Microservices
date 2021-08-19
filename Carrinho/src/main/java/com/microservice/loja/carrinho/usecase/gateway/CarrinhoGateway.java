package com.microservice.loja.carrinho.usecase.gateway;

import java.util.Optional;

import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public interface CarrinhoGateway {
	
	Optional<CarrinhoDomainResponse> AtualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest); 
		
	Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest);

	Optional<CarrinhoDomainResponse> adicionarProduto(CarrinhoDomainRequest carrinhoDomainRequest);
		
}