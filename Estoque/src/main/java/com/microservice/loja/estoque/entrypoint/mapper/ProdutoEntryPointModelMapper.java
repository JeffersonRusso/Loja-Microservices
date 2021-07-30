package com.microservice.loja.estoque.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;

import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.model.response.ProdutoDomainResponse;

/**
 * Mapper que converte um EntryPointModel para um objeto UseCase
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 */

public class ProdutoEntryPointModelMapper {
	
	/**
	 * Construtor privado para evitar instanciação.
	 */

	private ProdutoEntryPointModelMapper() {}
		
	public static ProdutoModelResponse fromModel(ProdutoDomainResponse produtoDomainResponse) {
		return ProdutoModelResponse.builder()
				.nome(produtoDomainResponse.getNome())
				.preco(produtoDomainResponse.getPreco())
				.imagem(produtoDomainResponse.getImagem())
				.build();
	}
	
	public static List<ProdutoModelResponse> fromListModel(List<ProdutoDomainResponse> produtoDomainResponse) {
		List<ProdutoModelResponse> listaProdutosModelResponses = new ArrayList<>();
		
		for (ProdutoDomainResponse produto : produtoDomainResponse) {
			listaProdutosModelResponses.add(
					ProdutoModelResponse.builder()
							.nome(produto.getNome())
							.preco(produto.getPreco())
							.imagem(produto.getImagem())
							.build());
		}
		return listaProdutosModelResponses;
	}
}