package com.microservice.loja.estoque.usecase.model.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDomainResponse {
	
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private String imagem;
}