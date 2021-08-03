package com.microservice.loja.carrinho.usecase.model.request;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CarrinhoDomainRequest {

	private Integer idCarrinho;
}
