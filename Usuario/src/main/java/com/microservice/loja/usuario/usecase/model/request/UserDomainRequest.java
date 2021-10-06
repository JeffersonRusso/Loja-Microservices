package com.microservice.loja.usuario.usecase.model.request;

import com.microservice.loja.usuario.enumerator.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDomainRequest {
	
	private String id;
	
	private String email;
	private String password;
	
	private String authId;
	private String identification;
	
	private Status status;
}
