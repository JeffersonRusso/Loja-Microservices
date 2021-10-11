package com.microservice.loja.estoque.entrypoint.model.response;

import lombok.Data;

@Data
public class Avaliacao {
	private Integer qualidadeGeral;
	private Integer custoBeneficio;
	private String design;
}
