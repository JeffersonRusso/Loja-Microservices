package com.microservice.loja.usuario.usecase.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDomainRequest {
	
	private String email;
	private String password;
}
