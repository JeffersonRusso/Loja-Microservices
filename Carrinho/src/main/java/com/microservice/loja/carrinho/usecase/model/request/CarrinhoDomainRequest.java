package com.microservice.loja.carrinho.usecase.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CarrinhoDomainRequest {

	private String idCarrinho;
	private Produto produto;

	@Builder
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	static public class Produto {
		private String idProduto;
		private Integer quantidade;
	}
}