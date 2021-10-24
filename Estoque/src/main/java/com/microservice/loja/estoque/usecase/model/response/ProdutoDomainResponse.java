package com.microservice.loja.estoque.usecase.model.response;

import java.math.BigDecimal;

import com.microservice.loja.estoque.entrypoint.model.response.Avaliacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDomainResponse {
	
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
	//
	private Categoria categoria;
	private Avaliacao avaliacao;
	private Dimensao dimensao;
}