package com.microservice.loja.carrinho.dataprovider.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ProdutoModel {
	
	private String idProduto;
	
	private Integer quantidade;
	
	
}
