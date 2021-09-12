package com.microservice.loja.usuario.entrypoint.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserModelRequest {
	
	private String email;
	private String password;
}