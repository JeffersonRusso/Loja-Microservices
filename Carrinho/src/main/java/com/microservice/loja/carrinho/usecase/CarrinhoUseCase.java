package com.microservice.loja.carrinho.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice.loja.carrinho.usecase.gateway.CarrinhoGateway;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

@Component
public class CarrinhoUseCase {
	
	private CarrinhoGateway carrinhoGateway;
	
	@Autowired
	public CarrinhoUseCase (final CarrinhoGateway carrinhoGateway) {
		this.carrinhoGateway = carrinhoGateway;
	}
	
	public Optional<CarrinhoDomainResponse> AtualizarProdutoCarrinho(CarrinhoDomainRequest carrinhoDomainRequest) {
		return carrinhoGateway.AtualizarProdutoCarrinho(carrinhoDomainRequest);
	} 
	
	public Optional<CarrinhoDomainResponse> buscarCarrinhoPorId(CarrinhoDomainRequest carrinhoDomainRequest) {
		return carrinhoGateway.buscarCarrinhoPorId(carrinhoDomainRequest);
	}
	
	public Optional<CarrinhoDomainResponse> adicionarProduto (CarrinhoDomainRequest carrinhoDomainRequest) {
		return carrinhoGateway.adicionarProduto(carrinhoDomainRequest);
	}
}