package com.microservice.loja.carrinho.entrypoint.mapper;

import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;
import com.microservice.loja.carrinho.entrypoint.model.request.CarrinhoModelRequest;
import com.microservice.loja.carrinho.entrypoint.model.response.CarrinhoModelResponse;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoEntryPointDomainMapper {

	//Construtor privado para evitar instanciacao
	private CarrinhoEntryPointDomainMapper() {}
	
	public static CarrinhoModelResponse forModel (CarrinhoDomainResponse response) {
		return CarrinhoModelResponse.builder()
				.idProduto(response.getProdutos().getIdProduto())
				.quantidade(response.getProdutos().getQuantidade())
				.build();
	}
	
	public static CarrinhoDomainRequest forDomain (CarrinhoModelRequest request) {
		return CarrinhoDomainRequest.builder()
				.idCarrinho(request.getIdCarrinho())
				.produtos(new ProdutoModel(request.getIdProduto(), request.getQuantidade()))
				.build();
	}
}
