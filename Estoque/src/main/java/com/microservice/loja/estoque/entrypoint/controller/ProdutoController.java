package com.microservice.loja.estoque.entrypoint.controller;

import static com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper.fromModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.microservice.loja.estoque.dataprovider.repository.ProdutoRepository;
import com.microservice.loja.estoque.dataprovider.repository.entity.ProdutoEntity;
import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointDomainMapper;
import com.microservice.loja.estoque.entrypoint.mapper.ProdutoEntryPointModelMapper;
import com.microservice.loja.estoque.entrypoint.model.request.ProdutoModelRequest;
import com.microservice.loja.estoque.entrypoint.model.response.ProdutoModelResponse;
import com.microservice.loja.estoque.usecase.ProdutoUseCase;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoUseCase produtoUseCase;
	

	public final ProdutoRepository pr;
	
	@Autowired
	public ProdutoController(ProdutoUseCase produtoUseCase, ProdutoRepository pr) {
		this.produtoUseCase = produtoUseCase;
		this.pr = pr;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutoModelResponse> buscarProdutoPorId(@PathVariable Integer id) {
		
		ProdutoModelRequest produtoRequest = new ProdutoModelRequest();
		produtoRequest.setIdProduto(id);
		
		return produtoUseCase.buscarProdutoPorId(ProdutoEntryPointDomainMapper.fromDomain(produtoRequest))
				.map(ProdutoEntryPointModelMapper::fromModel)
				.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
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
	
	@GetMapping (value = "/buscar_ids", params = "ids")
	public  ResponseEntity<List<ProdutoModelResponse>> buscarProdutosVitrine(@RequestParam List<Integer> ids) {

		List<ProdutoModelRequest> produtosModelRequest = new ArrayList<>();
		for (Integer id : ids) {
			produtosModelRequest.add(new ProdutoModelRequest(id));
		}
		
		Optional<List<ProdutoModelResponse>> listaProdutosModelResponse = produtoUseCase.buscarVariosProdutosPorIds(ProdutoEntryPointDomainMapper.fromListDomain(produtosModelRequest))
				.map(ProdutoEntryPointModelMapper::fromListModel);
		 
		return  listaProdutosModelResponse
	        	.map(response -> new ResponseEntity<>(response, HttpStatus.OK)).
	        	orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}