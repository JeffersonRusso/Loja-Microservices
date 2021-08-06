package com.microservice.loja.carrinho.dataprovider.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProdutoModel {
	
	private Integer idProduto;
	
	private Integer quantidade;
}
