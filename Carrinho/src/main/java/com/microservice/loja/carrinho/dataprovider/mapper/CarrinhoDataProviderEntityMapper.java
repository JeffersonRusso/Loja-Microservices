package com.microservice.loja.carrinho.dataprovider.mapper;

import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoDataProviderEntityMapper {
	
	//Construtor privado para evitar instanciacao
	private CarrinhoDataProviderEntityMapper() {}
	
	public static CarrinhoEntity forEntity(CarrinhoDomainRequest carrinhoDomainRequest) {
		return CarrinhoEntity.builder()
					.idCarrinho(carrinhoDomainRequest.getIdCarrinho())
					.produtos(carrinhoDomainRequest.getProdutos())
					.build();
	}
}
