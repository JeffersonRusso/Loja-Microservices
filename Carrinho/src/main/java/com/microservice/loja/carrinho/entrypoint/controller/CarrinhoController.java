package com.microservice.loja.carrinho.entrypoint.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.loja.carrinho.entrypoint.constants.Constants;
import com.microservice.loja.carrinho.entrypoint.model.response.CarrinhoModelResponse;

@RestController
@RequestMapping(value = Constants.URL)
public class CarrinhoController {

	public void atualizarProduto() {}
	
	@PatchMapping(value = "/carrinho/{idproduto}/{quantidade}")
	public CarrinhoModelResponse atualizarProduto(@PathVariable Integer idProduto
			, @PathVariable Integer quantidade ) {
		return null;
	}
}
