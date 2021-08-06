package com.microservice.loja.carrinho.entrypoint.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CarrinhoModelRequest {
	private Integer idCarrinho;
	private Integer idProduto;
	private Integer quantidade;
}
