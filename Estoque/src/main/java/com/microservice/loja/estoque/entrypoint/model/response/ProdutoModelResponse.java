package com.microservice.loja.estoque.entrypoint.model.response;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapeia um objeto Produto de retorno para camada EntryPoint.
 * 
 * @author Jefferson Russo
 * @since 24/06/2021
 * @version
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonNaming(SnakeCaseStrategy.class)
public class ProdutoModelResponse {
	
	private String idProduto;
	private String nome;
	private String marca;
	private String modelo;
	private String corPrincipal;	
	private BigDecimal preco;
	private Integer quantidade;
	private Integer quantidadeVendidos;
	private String[] imagensNavegadorClassico;
	private String[] imagensNavegadorMobile;
	private String descricao;
	private boolean ativo;
	
	private Categoria categoria;
	private Dimensao dimencao;
	private Avaliacao avaliacao;
}