package com.microservice.loja.carrinho.entrypoint.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CarrinhoModelRequest {
	
	private String idCarrinho;
	
	private Produto produtos;
	
	@Getter
	@Setter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Produto {
		private String idProduto;
		private Integer quantidade;
	}
}