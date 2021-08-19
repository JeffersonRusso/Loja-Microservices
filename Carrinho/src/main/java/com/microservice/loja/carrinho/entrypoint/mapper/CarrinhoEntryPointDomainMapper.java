package com.microservice.loja.carrinho.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;

import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;
import com.microservice.loja.carrinho.entrypoint.model.request.CarrinhoModelRequest;
import com.microservice.loja.carrinho.entrypoint.model.response.CarrinhoModelResponse;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoEntryPointDomainMapper {

	//Construtor privado para evitar instanciacao
	private CarrinhoEntryPointDomainMapper() {}
	
	public static CarrinhoModelResponse forModel (CarrinhoDomainResponse response) {
		
		List<CarrinhoModelResponse.Produto> listaProdutosDomain = new ArrayList<>();
		
		response.getProdutos().forEach(produto ->
			listaProdutosDomain.add(new CarrinhoModelResponse.Produto(produto.getIdProduto(), produto.getQuantidade()))
		);
		
		return CarrinhoModelResponse.builder()
				.produtos(listaProdutosDomain)
				.build();
	}
	
	public static CarrinhoDomainRequest forDomain (CarrinhoModelRequest request) {	
		
		return CarrinhoDomainRequest.builder()
				.idCarrinho(request.getIdCarrinho())
				.produto(new CarrinhoDomainRequest.Produto(request.getIdProduto(), request.getQuantidade()))
				.build();
	}
}
