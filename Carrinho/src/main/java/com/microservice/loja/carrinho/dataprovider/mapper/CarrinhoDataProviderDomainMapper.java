package com.microservice.loja.carrinho.dataprovider.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Splitter;
import com.microservice.loja.carrinho.dataprovider.repository.entity.CarrinhoEntity;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse.Produto;

public class CarrinhoDataProviderDomainMapper {

	//Construtor privado para evitar instanciacao
	private CarrinhoDataProviderDomainMapper () {}
	
	public static CarrinhoDomainResponse toCarrinhoDomain(CarrinhoEntity carrinhoEntity) {
		
		List<Produto> listaDeProdutos = converteStringParaProdutosMapeados(carrinhoEntity.getProdutos());
		
		return CarrinhoDomainResponse.builder()
				.produtos(listaDeProdutos)
				.build();
	}
	
	public static List<Produto> converteStringParaProdutosMapeados(String produtosSeparados) {
		List<CarrinhoDomainResponse.Produto> listaDeProdutos = new ArrayList<>();
		
		Map<String, String> produtos = Splitter.on(",").withKeyValueSeparator(":").split(produtosSeparados);		
		
		for (Map.Entry<String, String> produto : produtos.entrySet()) {
			listaDeProdutos.add(new Produto(produto.getKey(), Integer.parseInt( produto.getValue())));
	    }
		
		return listaDeProdutos;
	}
}
