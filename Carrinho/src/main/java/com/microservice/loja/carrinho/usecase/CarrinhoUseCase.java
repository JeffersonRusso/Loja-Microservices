package com.microservice.loja.carrinho.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.loja.carrinho.usecase.gateway.CarrinhoGateway;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoUseCase {
	
	@Autowired
	private CarrinhoGateway carrinhoGateway;
	
	public Optional<CarrinhoDomainResponse> atualizaProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest) {
		return carrinhoGateway.AtualizarProdutoCarrinho(carrinhoDomainRequest);
	} 
	
	public Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest) {
		return carrinhoGateway.buscarCarrinhoPorId(carrinhoDomainRequest);
	}
}