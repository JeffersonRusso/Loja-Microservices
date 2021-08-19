package com.microservice.loja.carrinho.usecase.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CarrinhoDomainResponse {
    
    private List<Produto> produtos;
    
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Produto {
    	private String idProduto;
    	private Integer quantidade;   	
    }
}
