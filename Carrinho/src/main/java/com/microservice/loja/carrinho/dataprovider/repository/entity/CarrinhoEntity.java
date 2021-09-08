package com.microservice.loja.carrinho.dataprovider.repository.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name = "tb_carrinho")
public class CarrinhoEntity {

	private String idCarrinho;
    
    private String idUsuario;
    
    @Embedded
    private Produto produto;
    
    @Embeddable
    @Builder
    @AllArgsConstructor
    @Getter
    public static class Produto {
    	private String idProduto;
    	private Integer quantidade;
    
    }

}
