package com.microservice.loja.estoque.entrypoint.controller;

import static com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointDomainMapper.fromDomain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper;
import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.ProdutoUseCase;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {
	
	private ProdutoUseCase produtoUseCase;
	
	@Autowired
	public ProdutoController(ProdutoUseCase produtoUseCase) {
		this.produtoUseCase = produtoUseCase;
	}
	
	@GetMapping
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(ProdutoModelRequest produtoRequest) {
		
		return produtoUseCase.buscarProdutoPorId(fromDomain(produtoRequest))
			.map(ProdutoEntryPointModelMapper::fromModel)
			.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoModelResponse>> buscarTodosOsProdutos() {

		return produtoUseCase.buscarTodosOsProdutos()
			.map(ProdutoEntryPointModelMapper::fromListOfModel)
			.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}