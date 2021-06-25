package com.microservice.loja.estoque.usecase.model.request;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoDomainRequest {

	private UUID idProduto;
}
