package com.microservice.loja.carrinho.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	public void atualizarProduto() {}
	
	//cria carrinho para o usuario
	//deleta item carrinho
	//-- adiciona item carrinho
	
	@PostMapping(value = "carrinho/{idproduto}/{quantidade}")
	public ResponseEntity<CarrinhoModelResponse> adicionaProduto(
			  @RequestBody CarrinhoModelRequest carrinhoModelRequest) {
		
		return carrinhoUserCase.adicionaProduto(
				forDomain(carrinhoModelRequest))
				.map(CarrinhoEntryPointDomainMapper::forModel)
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));	
	}
	
	@PatchMapping(value = "carrinho/{idproduto}/{quantidade}")
	public ResponseEntity<CarrinhoModelResponse> atualizarProduto(
			  @RequestBody String idCarrinho
			, @PathVariable String idProduto
			, @PathVariable Integer quantidade ) {
		
		CarrinhoModelRequest carrinhoModelRequest = new CarrinhoModelRequest(idCarrinho, 
				new CarrinhoModelRequest.Produto(idProduto, quantidade));
		
		return carrinhoUserCase.atualizaProdutoCarrinho(
				forDomain(carrinhoModelRequest))
				.map(CarrinhoEntryPointDomainMapper::forModel)
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));	
	}
	
	@PostMapping(value = "/idUsuario")
	public ResponseEntity<CarrinhoModelResponse> criaCarrinho(
			  @RequestBody String idUsuario ) {
		
	return carrinhoUserCase.criaCarrinho(idUsuario)
				.map(CarrinhoEntryPointDomainMapper::forModel)
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));	
	}
}