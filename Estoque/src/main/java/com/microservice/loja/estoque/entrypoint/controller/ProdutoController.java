package com.microservice.loja.estoque.entrypoint.controller;

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

import com.microservice.loja.estoque.entrypoint.Constants;
import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointMapperRequest;
import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointMapperResponse;
import com.microservice.loja.estoque.entrypoint.model.request.Filter;
import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.ProdutoUseCase;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = Constants.URL)
public class ProdutoController {
	
	private final ProdutoUseCase produtoUseCase;
	private final ProdutoEntryPointMapperRequest requestMapper;
	private final ProdutoEntryPointMapperResponse responseMapper;
	
	@Autowired
	public ProdutoController
			(ProdutoUseCase produtoUseCase,
			ProdutoEntryPointMapperRequest requestMapper,
			ProdutoEntryPointMapperResponse responseMapper )
	{
		this.produtoUseCase = produtoUseCase;
		this.requestMapper = requestMapper;
		this.responseMapper = responseMapper;
	}
	
	@GetMapping (value = Constants.URL_PRODUTOS_POR_ID)
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(@PathVariable String id) {
		
		return produtoUseCase.buscarProdutoPorId(requestMapper.convertToDomain(
				ProdutoModelRequest
				.builder()
				.idProduto(id)
				.build()))
				.map(responseMapper::convertToModel)
				.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping (value = Constants.URL_PRODUTOS_POR_IDS, params = "ids")
	public  ResponseEntity<List<ProdutoModelResponse>> buscarProdutosPorId(@RequestParam List<String> ids) {
		
		List<ProdutoModelRequest> produtosModelRequest = new ArrayList<>();
		for (String id : ids) {
			produtosModelRequest.add(ProdutoModelRequest.builder()
					.idProduto(id)
					.build());
		}	
		
		Optional<List<ProdutoModelResponse>> listaProdutosModelResponse = produtoUseCase.buscarVariosProdutosPorIds(requestMapper.convertToDomainList(produtosModelRequest))
				.map(responseMapper::convertToModelList);
		 
		return  listaProdutosModelResponse
	        	.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
	        	.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping (value = Constants.URL_PRODUTOS_POR_NOME)
	public ResponseEntity<ProdutoModelResponse> buscarProdutosPorNome(@PathVariable String nome) {
		
		return produtoUseCase.buscarProdutoPorId(requestMapper.convertToDomain(
				ProdutoModelRequest.builder()
				.nome(nome)
				.build()))
				.map(responseMapper::convertToModel)
				.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	//CACHED
	@GetMapping (value = Constants.URL_PRODUTOS_VITRINE)
	public  ResponseEntity<List<ProdutoModelResponse>> buscarProdutosVitrine(  
			@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idProduto") String sortBy) {
		
		final List<ProdutoModelResponse> listaProdutosModelResponse = new ArrayList<>();
		
				produtoUseCase.buscaProdutosVitrine(pageNo, pageSize, sortBy)
					.ifPresentOrElse( 
						produtos  
							-> 	listaProdutosModelResponse.addAll(
									responseMapper.convertToModelList(produtos)),
						()
							-> 	log.error("lista de produtos vazia : {}",
									listaProdutosModelResponse.size()));
        
        return Optional.of(listaProdutosModelResponse)
        		.map(response -> new ResponseEntity<>(response, HttpStatus.OK)).
        		orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public  ResponseEntity<List<ProdutoModelResponse>> buscarPorEspecificacao(Filter filter) {
		return null;
	}
	
}