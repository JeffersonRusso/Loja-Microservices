package com.microservice.loja.carrinho.entrypoint.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarrinhoModelResponse {
	
	private List<Produto> produtos;
	
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