package com.microservice.loja.estoque.entrypoint.controller;

import static com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper.fromModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointDomainMapper;
import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper;
import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.ProdutoUseCase;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
	
	private ProdutoUseCase produtoUseCase;
	
	@Autowired
	public ProdutoController(ProdutoUseCase produtoUseCase) {
		this.produtoUseCase = produtoUseCase;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(@PathVariable Integer id) {
		
		ProdutoModelRequest produtoRequest = new ProdutoModelRequest();
		produtoRequest.setIdProduto(id);
		
		return produtoUseCase.buscarProdutoPorId(ProdutoEntryPointDomainMapper.fromDomain(produtoRequest))
				.map(produtoDomainResponse -> fromModel(produtoDomainResponse))
				.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @return 
	 */
	
	@GetMapping ("/all")
	public  ResponseEntity<List<ProdutoModelResponse>> buscarProdutosVitrine(  
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idProduto") String sortBy) {
		
		final List<ProdutoModelResponse> listaProdutosModelResponse = new ArrayList<>();
		
		listaProdutosModelResponse.addAll(ProdutoEntryPointModelMapper
				.fromListModel(produtoUseCase.buscaProdutosVitrine(pageNo, pageSize, sortBy).get()));
        
        return Optional.of(listaProdutosModelResponse)
        		.map(response -> new ResponseEntity<>(response, HttpStatus.OK)).
        		orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}