package com.microservice.loja.carrinho.entrypoint.mapper;

import com.microservice.loja.carrinho.entrypoint.model.request.CarrinhoModelRequest;
import com.microservice.loja.carrinho.entrypoint.model.response.CarrinhoModelResponse;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoEntryPointDomainMapper {

	//Construtor privado para evitar instanciacao
	private CarrinhoEntryPointDomainMapper() {}
	
	public static CarrinhoModelResponse forModel (CarrinhoDomainResponse response) {
		
		return CarrinhoModelResponse.builder()
				.idCarrinho(response.getIdCarrinho())
				.produto(CarrinhoModelResponse.Produto.builder()
						.idProduto(response.getProduto().getIdProduto())
						.quantidade(response.getProduto().getQuantidade())
						.build())
				.build();
	}
	
	public static CarrinhoDomainRequest forDomain(CarrinhoModelRequest request) {
		
		return CarrinhoDomainRequest.builder()
				.idCarrinho(request.getIdCarrinho())
				.produto(CarrinhoDomainRequest.Produto.builder()
						.idProduto(request.getProdutos().getIdProduto())
						.quantidade(request.getProdutos().getQuantidade())
						.build())
				.build();	
	}
}