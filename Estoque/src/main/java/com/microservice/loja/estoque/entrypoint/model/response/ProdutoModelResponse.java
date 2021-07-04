package com.microservice.loja.estoque.entrypoint.model.response;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Getter;

/**
 * Mapeia um objeto Produto de retorno para camada EntryPoint.
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 * @version
 */

@Getter
@Builder
@JsonInclude(Include.NON_EMPTY)
@JsonNaming(SnakeCaseStrategy.class)
public class ProdutoModelResponse {
	
	private UUID idProduto;
	private String nome;
	private BigDecimal preco;
	private String imagem;

}
