package com.microservice.loja.carrinho.usecase.model.request;

import java.util.List;

import javax.persistence.Entity;

import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CarrinhoDomainRequest {

	private Integer idCarrinho;
	private ProdutoModel produtos;
}