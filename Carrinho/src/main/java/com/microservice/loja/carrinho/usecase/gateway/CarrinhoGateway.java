package com.microservice.loja.carrinho.usecase.gateway;

import java.util.Optional;

import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public interface CarrinhoGateway {
	
	Optional<CarrinhoDomainResponse> atualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest); 
		
	Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest);
	
	Optional<CarrinhoDomainResponse> adicionaProduto(CarrinhoDomainRequest carrinhoDomainRequest);
	
	Optional<CarrinhoDomainResponse> criaCarrinho(String idUsuario);
}
