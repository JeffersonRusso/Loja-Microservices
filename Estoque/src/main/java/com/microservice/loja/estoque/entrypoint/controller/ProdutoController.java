package com.microservice.loja.estoque.entrypoint.controller;

import org.springframework.http.ResponseEntity;

import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;

public class ProdutoController {
	
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(ProdutoModelRequest produtoModelRequest) {
		
		return 	null;
	}
	
}
