package com.microservice.loja.carrinho.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.microservice.loja.carrinho.dataprovider.repository.model.ProdutoModel;
import com.microservice.loja.carrinho.entrypoint.constants.Constants;
import com.microservice.loja.carrinho.entrypoint.mapper.CarrinhoEntryPointDomainMapper;
import com.microservice.loja.carrinho.entrypoint.model.request.CarrinhoModelRequest;
import com.microservice.loja.carrinho.entrypoint.model.response.CarrinhoModelResponse;
import com.microservice.loja.carrinho.usecase.CarrinhoUseCase;
import com.microservice.loja.carrinho.usecase.model.request.CarrinhoDomainRequest;
import com.microservice.loja.carrinho.usecase.model.response.CarrinhoDomainResponse;

import static com.microservice.loja.carrinho.entrypoint.mapper.CarrinhoEntryPointDomainMapper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = Constants.URL)
public class CarrinhoController {
	
	private CarrinhoUseCase carrinhoUserCase;
	
	@Autowired
	public CarrinhoController(CarrinhoUseCase carrinhoUserCase) {
		this.carrinhoUserCase = carrinhoUserCase;
	}

	@PatchMapping(value = "/{idCarrinho}/{idProduto}/{quantidade}")
	public ResponseEntity<CarrinhoModelResponse> atualizarProduto(
			  @PathVariable Integer idCarrinho
			, @PathVariable String idProduto
			, @PathVariable Integer quantidade ) {
		
		List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
		produtos.add(new ProdutoModel(idProduto, quantidade));
		
		return carrinhoUserCase.AtualizarProdutoCarrinho(
				forDomain(new CarrinhoModelRequest(idCarrinho, idProduto, quantidade)))
				.map(CarrinhoEntryPointDomainMapper::forModel)
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping(value = "/adiciona")
	public ResponseEntity<CarrinhoModelResponse> adicionarProduto(
			  @RequestBody CarrinhoModelRequest carrinhoModelRequest) {
		
		return carrinhoUserCase.adicionarProduto(
				forDomain(carrinhoModelRequest))
				.map(CarrinhoEntryPointDomainMapper::forModel)
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}
