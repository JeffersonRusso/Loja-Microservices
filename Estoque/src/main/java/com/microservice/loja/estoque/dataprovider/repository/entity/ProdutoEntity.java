package com.microservice.loja.estoque.dataprovider.repository.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
@Entity
public class ProdutoEntity {
	
	@Id
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	private String imagem;
	private String imagemCarinho;
}