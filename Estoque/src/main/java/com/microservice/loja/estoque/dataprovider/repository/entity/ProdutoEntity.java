package com.microservice.loja.estoque.dataprovider.repository.entity;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private String idProduto;
    
	private String nome;
	private String marca;
	private String modelo;
	private String corPrincipal;	
	private BigDecimal preco;
	private Integer quantidade;
	private String imagemMiniatura;
	private String[] imagensNavegadorClassico;
	private String[] imagensNavegadorMobile;
	private String descricao;
	private boolean ativo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
	
	@Embedded
	private Avaliacao avaliacao;

}