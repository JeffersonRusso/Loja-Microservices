package com.microservice.loja.estoque.entrypoint.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModelRequest {

	private String idProduto;
	private String nome;
}