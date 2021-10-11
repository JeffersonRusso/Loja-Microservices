package com.microservice.loja.estoque.dataprovider.repository.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Avaliacao {
	private Integer totalAvaliadores;
	private Integer qualidadeGeral;
	private Integer custoBeneficio;
	private String design;
}