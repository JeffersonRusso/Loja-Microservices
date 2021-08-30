package com.microservice.loja.carrinho.usecase.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarrinhoDomainResponse {
    
	private String idCarrinho;
    
	private Produto produto;
	
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
