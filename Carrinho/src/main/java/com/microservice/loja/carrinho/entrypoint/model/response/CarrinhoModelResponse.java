package com.microservice.loja.carrinho.entrypoint.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CarrinhoModelResponse {
	private Integer idProduto;
	private Integer quantidade;
}
