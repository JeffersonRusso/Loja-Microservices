package com.microservice.loja.carrinho.usecase.model.response;

import java.math.BigDecimal;
import java.util.List;

import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarrinhoDomainResponse {
    
    private ProdutoModel produtos;
}
