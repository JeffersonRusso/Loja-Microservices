package com.microservice.loja.carrinho.dataprovider.mapper;

import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;

public class CarrinhoDataProviderEntityMapper {
	
	//Construtor privado para evitar instanciacao
	private CarrinhoDataProviderEntityMapper() {}
	
	public static CarrinhoEntity forEntity(CarrinhoDomainRequest carrinhoDomainRequest) {
		return CarrinhoEntity.builder()
					.idCarrinho(carrinhoDomainRequest.getIdCarrinho())
					.produto(CarrinhoEntity.Produto.builder()
							.idProduto(carrinhoDomainRequest.getProduto().getIdProduto())
							.quantidade(carrinhoDomainRequest.getProduto().getQuantidade())
							.build())
					.build();
	}
}
