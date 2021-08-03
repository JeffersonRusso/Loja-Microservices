package com.microservice.loja.carrinho.dataprovider.mapper;

import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

public class CarrinhoDataProviderDomainMapper {

	//Construtor privado para evitar instanciacao
	private CarrinhoDataProviderDomainMapper () {
		
	}
	
	public static CarrinhoDomainResponse toCarrinhoDomain(CarrinhoEntity carrinhoEntity) {
		return CarrinhoDomainResponse.builder()
				.produtos(carrinhoEntity.getProdutos())
				.build();
	}
}
