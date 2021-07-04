package com.microservice.loja.estoque.entrypoint.mapper;

import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.usecase.model.request.ProdutoDomainRequest;

/**
 * Mapper que converte um EntryPointModel para um objeto UseCase
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 */

public class ProdutoEntryPointDomainMapper {
	
	/**
	 * Construtor privado para evitar instanciação.
	 */
	private ProdutoEntryPointDomainMapper() {}
	
	public static ProdutoDomainRequest fromDomain(ProdutoModelRequest produtoModelRequest) {
		return ProdutoDomainRequest.builder()
				.idProduto(produtoModelRequest.getIdProduto())
				.build();
	}
}
