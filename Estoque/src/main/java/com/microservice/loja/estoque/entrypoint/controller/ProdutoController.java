package com.microservice.loja.estoque.entrypoint.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointDomainMapper.fromDomain;
import static com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper.fromModel;

import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.ProdutoUseCase;


public class ProdutoController {
	
	private ProdutoUseCase produtoUseCase;
	
	@Autowired
	public ProdutoController(ProdutoUseCase produtoUseCase) {
		this.produtoUseCase = produtoUseCase;
	}
	
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(ProdutoModelRequest produtoRequest) {
		
		return produtoUseCase.buscarProdutoPorId(fromDomain(produtoRequest))
				.map(produtoDomainResponse -> fromModel(produtoDomainResponse))
				.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}
