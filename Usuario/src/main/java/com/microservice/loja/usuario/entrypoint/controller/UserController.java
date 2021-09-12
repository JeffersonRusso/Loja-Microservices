package com.microservice.loja.usuario.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.microservice.loja.usuario.entrypoint.mapper.UserEntryPointDomainMapper;
import com.microservice.loja.usuario.entrypoint.mapper.UserEntryPointModelMapper;
import com.microservice.loja.usuario.entrypoint.model.request.UserModelRequest;
import com.microservice.loja.usuario.entrypoint.model.response.UserModelResponse;
import com.microservice.loja.usuario.usecase.UserUseCase;

@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	private UserUseCase userUseCase;
	
	@Autowired
	public UserController(UserUseCase userUseCase) {
		this.userUseCase = userUseCase;
	}
	
	@GetMapping(value = "/find")
	public ResponseEntity<UserModelResponse> findByEmail(
			@RequestBody UserModelRequest userModelRequest ) {
		
		return userUseCase.findByEmail(UserEntryPointDomainMapper.forDomain(userModelRequest))
				.map(response -> UserEntryPointModelMapper.forModel(response))
				.map(modelResponse -> new ResponseEntity<>(modelResponse, HttpStatus.OK))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}