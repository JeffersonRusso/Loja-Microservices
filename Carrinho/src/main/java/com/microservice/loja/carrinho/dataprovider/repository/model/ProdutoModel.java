package com.microservice.loja.carrinho.dataprovider.repository.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProdutoModel {
	
	private Integer idProduto;
	
	private Integer quantidade;
}
