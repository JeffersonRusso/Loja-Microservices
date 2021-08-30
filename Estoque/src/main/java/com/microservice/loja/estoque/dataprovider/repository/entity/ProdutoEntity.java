package com.microservice.loja.estoque.dataprovider.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	private String nome;
	private BigDecimal preco;
	private int quantidade;
	private String imagem;
	private String imagemCarinho;
}